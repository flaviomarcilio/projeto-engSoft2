package br.ufmg.services;

import br.ufmg.classes.Plano;
import br.ufmg.repositories.PlanosRepository;

import java.util.ArrayList;

public class PlanoService {

    PlanosRepository _planosRepository;

    public PlanoService(PlanosRepository planosRepository) {
        _planosRepository = planosRepository;
    }

    public PlanoService() {
        _planosRepository = new PlanosRepository();
    }

    public ArrayList<Plano> retornarTodos() {

        return _planosRepository.retornarLista();
    }
}
