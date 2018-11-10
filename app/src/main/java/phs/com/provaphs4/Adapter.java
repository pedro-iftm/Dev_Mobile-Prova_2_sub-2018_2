package phs.com.provaphs4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    Context contexto;
    List<Aluno> lista;

    public Adapter(Context contexto, List<Aluno> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.list_activity, null);
        Aluno post = lista.get(position);

        TextView nome = linha.findViewById(R.id.tv_nome);
        TextView nota = linha.findViewById(R.id.tv_nota);

        nome.setText(post.getNome());
        nota.setText(post.getNota());
        return linha;
    }
}
