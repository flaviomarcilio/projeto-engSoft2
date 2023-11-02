package classes;

import enums.Genero;

import java.util.ArrayList;

public class Filme extends EntidadeBase {
    public Filme(String titulo, int classificacao, Genero genero, String lancamento, String duracao,
                 String diretor) {
        super(titulo, classificacao, genero, lancamento, duracao, diretor);
    }
}
