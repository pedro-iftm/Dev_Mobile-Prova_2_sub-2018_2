package phs.com.provaphs4;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ListActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chamaRetrofit();

        img = findViewById(R.id.iv_bola);
    }

    private void chamaRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://angoti.atwebpages.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        AlunoService pedidoServico = retrofit.create(AlunoService.class);
        Call<List<Aluno>> pedidoResponse = pedidoServico.getAlunos();

        pedidoResponse.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Aluno> aluno = response.body();
                    setListAdapter(new Adapter(MainActivity.this, aluno));
                    for (int i = 0; i < aluno.size(); i++) {
                        if (response.body().get(i).getNota() < 6) {
                            img.setImageResource(R.drawable.layout_imagem_red);
                        } else {
                            img.setImageResource(R.drawable.layout_imagem_blue);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.i("teste", t.getMessage());
            }
        });
    }
}
