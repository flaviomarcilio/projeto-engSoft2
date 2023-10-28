package classes;

import enums.Genero;

import java.util.ArrayList;

public class Serie {
    private String titulo;
    private ArrayList<String> elenco;
    private int classificacao;
    private Genero genero;
    private String lancamento;
    private String duracao;
    private String diretor;
    private int temporadas;

    public Serie(String titulo, int classificacao, Genero genero, String lancamento, String duracao,
                 String diretor, int temporadas) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.lancamento = lancamento;
        this.duracao = duracao;
        this.diretor = diretor;
        this.temporadas = temporadas;
        this.elenco = new ArrayList<String>();
    }

    public void Classificar() {
        //TODO: Implementar
    }

    public void Assistir() {
        //TODO: Implementar
    }

    public void AdicionarMinhaLista() {
        //TODO: Implementar
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

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
}
