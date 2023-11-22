package br.ufmg.repositories;

import br.ufmg.classes.Filme;
import br.ufmg.enums.Genero;

import java.util.ArrayList;

public class FilmesRepository {

    private ArrayList<Filme> _filmesDisponiveis;
    public FilmesRepository() {
        _filmesDisponiveis = new ArrayList<Filme>();

        Filme f1 = new Filme("Filme1", 16, Genero.ACAO, "12/12/2023",
                "2:30", "Diretor");
        Filme f2 = new Filme("Filme2", 18, Genero.TERROR, "12/12/2022",
                "2:30", "Diretor");
        Filme f3 = new Filme("Filme3", 12, Genero.COMEDIA, "01/01/2020",
                "1:40", "Diretor");

        _filmesDisponiveis.add(f1);
        _filmesDisponiveis.add(f2);
        _filmesDisponiveis.add(f3);
    }

    public ArrayList<Filme> retornarLista() {
        return _filmesDisponiveis;
    }
}
