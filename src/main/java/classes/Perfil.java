package classes;

import java.util.ArrayList;

public class Perfil {
    private int classificacao;
    private String idioma;
    private String nome;
    private ArrayList<Filme> filmesAssistidos;
    private ArrayList<Serie> seriesAssistidas;
    private ArrayList<Filme> minhaListaFilmes;
    private ArrayList<Serie> minhaListaSeries;
    private boolean ativo;

    public Perfil(int classificacao, String idioma) {
        this.classificacao = classificacao;
        this.idioma = idioma;
        this.nome = "Default";
        this.filmesAssistidos = new ArrayList<Filme>();
        this.seriesAssistidas = new ArrayList<Serie>();
        this.minhaListaFilmes = new ArrayList<Filme>();
        this.minhaListaSeries = new ArrayList<Serie>();
        this.ativo = true;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void Excluir() {
        this.ativo = false;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Filme> getMinhaListaFilmes() {
        return minhaListaFilmes;
    }

    public void AdicionarFilmeNaMinhaLista(Filme filme) {
        minhaListaFilmes.add(filme);
    }

    public ArrayList<Serie> getMinhaListaSeries() {
        return minhaListaSeries;
    }

    public void AdicionarSeriaNaMinhaLista(Serie serie) {
        minhaListaSeries.add(serie);
    }

    public ArrayList<Filme> getFilmesAssistidos() {
        return filmesAssistidos;
    }

    public void setFilmesAssistidos(ArrayList<Filme> filmesAssistidos) {
        this.filmesAssistidos = filmesAssistidos;
    }

    public ArrayList<Serie> getSeriesAssistidas() {
        return seriesAssistidas;
    }

    public void setSeriesAssistidas(ArrayList<Serie> seriesAssistidas) {
        this.seriesAssistidas = seriesAssistidas;
    }
}
