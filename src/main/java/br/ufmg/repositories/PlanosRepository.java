package br.ufmg.repositories;

import br.ufmg.classes.Plano;
import br.ufmg.enums.TipoPlano;

import java.util.ArrayList;

public class PlanosRepository {

    private final ArrayList<Plano> _planos;
    public PlanosRepository() {
        _planos = new ArrayList<>();
        Plano p1 = new Plano(TipoPlano.BASICO, 25.90);
        Plano p2 = new Plano(TipoPlano.PADRAO, 39.90);
        Plano p3 = new Plano(TipoPlano.PREMIUM, 55.90);
        _planos.add(p1);
        _planos.add(p2);
        _planos.add(p3);
    }

    public ArrayList<Plano> retornarLista() {
        return _planos;
    }
}
