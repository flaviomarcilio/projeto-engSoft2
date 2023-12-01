package br.ufmg.classes;

import br.ufmg.enums.TipoPlano;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {

    static Usuario usuario;
    static final String nome = "Flávio";
    static final String telefone = "(31)987654321";
    static final String email = "email@email.com";
    static final String username = "admin";
    static final String password = "123456";
    @BeforeAll
    static void setUp() {
        //ARRANGE
        usuario = new Usuario(nome, telefone, email, username, password);
    }

    @Test
    void getUsername_DeveraRetornarUsernameDoUsuario() {
        //ACT
        var result = usuario.getUsername();

        //ASSERT
        assertEquals(username, result);
    }

    @Test
    void getPassword_DeveraRetornarPasswordDoUsuario() {
        //ACT
        var result = usuario.getPassword();

        //ASSERT
        assertEquals(password, result);
    }

    @Test
    void getNome_DeveraRetornarNomeDoUsuario() {
        //ACT
        var result = usuario.getNome();

        //ASSERT
        assertEquals(nome, result);
    }

    @Test
    void getTelefone_DeveraRetornarTelefoneDoUsuario() {
        //ACT
        var result = usuario.getTelefone();

        //ASSERT
        assertEquals(telefone, result);
    }

    @Test
    void getEmail_DeveraRetornarEmailDoUsuario() {
        //ACT
        var result = usuario.getEmail();

        //ASSERT
        assertEquals(email, result);
    }

    @Test
    void getConta_DeveraRetornarContaDoUsuario() {
        //ARRANGE
        Plano plano = new Plano(TipoPlano.BASICO, 25.90);
        Conta conta = new Conta(plano);
        usuario.setConta(conta);

        //ACT
        var result = usuario.getConta();

        //ASSERT
        assertEquals(conta, result);
    }
}