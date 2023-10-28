package classes;

import enums.OpcaoPagamento;
import enums.TipoPlano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void adicionarPerfil_QuandoAdicionaUmPerfil_DeveraConterDoisPerfis() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);
        Perfil perfil = new Perfil(14, "Inglês");

        //Act
        conta.AdicionarPerfil(perfil);

        //Assert
        assertEquals(conta.retornarListaPerfis().size(), 2);

    }

    @Test
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
    void retornarPerfilPorId_DeveraRetornarPerfilDefault() {
        //Arrange
        Plano plano = new Plano(TipoPlano.BASICO, 18.90, LocalDate.of(2020,12,1),
                OpcaoPagamento.CARTAO_CREDITO);
        Conta conta = new Conta(plano);

        //Act
        Perfil result = conta.retornarPerfilPorId(0);

        //Assert
        assertEquals(result.getNome(), "Default");

    }
}