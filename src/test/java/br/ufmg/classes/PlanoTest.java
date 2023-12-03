package br.ufmg.classes;

import br.ufmg.enums.TipoPlano;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Teste Unitário da Classe Plano")
class PlanoTest {

    static Plano planoBasico;

    @BeforeAll
    static void setUp() {
        //ARRANGE
        planoBasico = new Plano(TipoPlano.BASICO, 25.90);
    }

    @Test
    @DisplayName("Quando chamar getTipo deverá retornar o tipo do plano")
    void getTipo_DeveraRetornarTipoDoPlano() {
        //ACT
        var tipo = planoBasico.getTipo();

        //ASSERT
        assertEquals(TipoPlano.BASICO, tipo);
    }

    @Test
    @DisplayName("Quando chamar getPreco deverá retornar o preço do plano")
    void getPreco_DeveraRetornarPrecoDoPlano() {
        //ACT
        var preco = planoBasico.getPreco();

        //ASSERT
        assertEquals(25.9, preco);
    }
}