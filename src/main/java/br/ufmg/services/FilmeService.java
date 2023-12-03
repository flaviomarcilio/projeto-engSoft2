package br.ufmg.services;

import br.ufmg.classes.Filme;
import br.ufmg.repositories.FilmesRepository;

import java.util.ArrayList;

public class FilmeService {

    FilmesRepository _filmesRepository;

    public FilmeService(FilmesRepository filmesRepository) {
        _filmesRepository = filmesRepository;
    }

    public FilmeService() {
        _filmesRepository = new FilmesRepository();
    }

    public ArrayList<Filme> retornarLista() {
        return _filmesRepository.retornarLista();
    }
}
