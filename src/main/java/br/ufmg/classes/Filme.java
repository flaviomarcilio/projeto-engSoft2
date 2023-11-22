package br.ufmg.classes;

import br.ufmg.enums.Genero;

public class Filme extends EntidadeBase {
    public Filme(String titulo, int classificacao, Genero genero, String lancamento, String duracao,
                 String diretor) {
        super(titulo, classificacao, genero, lancamento, duracao, diretor);
    }
}
