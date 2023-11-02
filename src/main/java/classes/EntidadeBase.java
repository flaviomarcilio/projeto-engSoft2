package classes;

import enums.Genero;

import java.util.ArrayList;

public class EntidadeBase {
    private String titulo;
    private ArrayList<String> elenco;
    private int classificacao;
    private Genero genero;
    private String lancamento;
    private String duracao;
    private String diretor;

    public EntidadeBase(String titulo, int classificacao, Genero genero, String lancamento,
                        String duracao, String diretor) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.lancamento = lancamento;
        this.duracao = duracao;
        this.diretor = diretor;
        this.elenco = new ArrayList<String>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getElenco() {
        return elenco;
    }

    public void setElenco(ArrayList<String> elenco) {
        this.elenco = elenco;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
