package br.ufmg.classes;

import br.ufmg.enums.OpcaoPagamento;
import br.ufmg.enums.TipoPlano;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste Unitário da classe Conta")
class ContaTest {

    @Test
    @DisplayName("Quando adicionar novo perfil, a conta deverá possuir 2 perfis")
    void adicionarPerfil_QuandoAdicionaNovoPerfil_DeveraConterDoisPerfis() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);
        Perfil perfil = new Perfil(14, "Inglês");

        //Act
        conta.AdicionarPerfil(perfil);

        //Assert
        assertEquals(2, conta.retornarListaPerfis().size());

    }

    @Test
    @DisplayName("Quando criar uma nova conta, esta conta deverá estar ativa")
    void isAtivo_QuandoCriaUmaConta_ContaDeveraEstarAtiva() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);

        //Act
        boolean result = conta.isAtivo();

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Quando cancelar uma conta ela deve ser desativada")
    void cancelar_QuandoCancelaUmaConta_ContaDeveraEstarDesativada() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);

        //Act
        conta.Cancelar();
        boolean result = conta.isAtivo();

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Quando solicitar o plano, deverá retornar o plano cadastrado")
    void getPlano_DeveraRetornaPlanoDaConta() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);

        //Act
        Plano result = conta.getPlano();

        //Assert
        assertEquals(plano, result);
    }

    @Test
    @DisplayName("Quando solicitar troca de plano, deverá retornar novo plano")
    void setPlano_QuandoTrocarPlano_ContaDeveraRetornarNovoPlano() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);

        Plano plano2 = new Plano(TipoPlano.PREMIUM, 59.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);

        //Act
        conta.setPlano(plano2);
        Plano result = conta.getPlano();

        //Assert
        assertEquals(plano2, result);
    }

    @Test
    @DisplayName("Quando solicitar perfil default, deverá retornar o perfil default")
    void retornarPerfilDefault_DeveraRetornarPerfilDefault() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);

        //Act
        Perfil result = conta.retornarPerfilDefault();

        //Assert
        assertEquals("Default", result.getNome());

    }
}