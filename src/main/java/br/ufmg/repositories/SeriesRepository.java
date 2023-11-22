package br.ufmg.repositories;

import br.ufmg.classes.Serie;
import br.ufmg.enums.Genero;

import java.util.ArrayList;

public class SeriesRepository {

    private ArrayList<Serie> _seriesDisponiveis;

    public SeriesRepository() {
        _seriesDisponiveis = new ArrayList<Serie>();

        Serie s1 = new Serie("Série1", 14, Genero.FANTASIA, "14/12/2021",
                "1:20", "Diretor", 3);
        Serie s2 = new Serie("Série2", 14, Genero.FANTASIA, "12/01/2018",
                "1:30", "Diretor", 3);
        Serie s3 = new Serie("Série3", 14, Genero.FANTASIA, "20/05/2012",
                "1:00", "Diretor", 3);
        _seriesDisponiveis.add(s1);
        _seriesDisponiveis.add(s2);
        _seriesDisponiveis.add(s3);
    }

    public ArrayList<Serie> retornarLista() {
        return _seriesDisponiveis;
    }
}
