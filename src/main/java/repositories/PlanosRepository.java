package repositories;

import classes.Plano;
import enums.TipoPlano;

import java.util.ArrayList;

public class PlanosRepository {

    private ArrayList<Plano> _planosDisponiveis;
    public PlanosRepository() {
        _planosDisponiveis = new ArrayList<Plano>();
        Plano p1 = new Plano(TipoPlano.BASICO, 25.90);
        Plano p2 = new Plano(TipoPlano.PADRAO, 39.90);
        Plano p3 = new Plano(TipoPlano.PREMIUM, 55.90);
        _planosDisponiveis.add(p1);
        _planosDisponiveis.add(p2);
        _planosDisponiveis.add(p3);
    }

    public ArrayList<Plano> retornarLista() {
        return _planosDisponiveis;
    }
}
