package classes;

import enums.Genero;

import java.util.ArrayList;

public class Serie extends EntidadeBase {
    private int temporadas;

    public Serie(String titulo, int classificacao, Genero genero, String lancamento, String duracao,
                 String diretor, int temporadas) {

        super(titulo, classificacao, genero, lancamento, duracao, diretor);
        this.temporadas = temporadas;

    }
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
}
