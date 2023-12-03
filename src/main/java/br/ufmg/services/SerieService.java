package br.ufmg.services;

import br.ufmg.classes.Serie;
import br.ufmg.repositories.SeriesRepository;

import java.util.ArrayList;

public class SerieService {

    SeriesRepository _serieRepository;

    public SerieService(SeriesRepository serieRepository) {
        _serieRepository = serieRepository;
    }

    public SerieService() {
        _serieRepository = new SeriesRepository();
    }

    public ArrayList<Serie> retornarLista() {
        return _serieRepository.retornarLista();
    }
}
