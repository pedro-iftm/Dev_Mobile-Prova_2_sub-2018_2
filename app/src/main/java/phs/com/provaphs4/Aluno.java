package phs.com.provaphs4;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Aluno implements Serializable {

    @SerializedName("nome")
    private String nome;

    @SerializedName("nota")
    private int nota;

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
