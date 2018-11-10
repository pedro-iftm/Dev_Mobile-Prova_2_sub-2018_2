package phs.com.provaphs4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface AlunoService {

    @GET("/lista_de_alunos")
    Call<List<Aluno>> getAlunos();
}
