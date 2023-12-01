package br.ufmg.classes;

import br.ufmg.enums.TipoPlano;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlanoTest {

    static Plano planoBasico;

    @BeforeAll
    static void setUp() {
        //ARRANGE
        planoBasico = new Plano(TipoPlano.BASICO, 25.90);
    }

    @Test
    void getTipo_DeveraRetornarTipoDoPlano() {
        //ACT
        var tipo = planoBasico.getTipo();

        //ASSERT
        assertEquals(TipoPlano.BASICO, tipo);
    }

    @Test
    void getPreco_DeveraRetornarPrecoDoPlano() {
        //ACT
        var preco = planoBasico.getPreco();

        //ASSERT
        assertEquals(25.9, preco);
    }
}