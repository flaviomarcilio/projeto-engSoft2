package br.ufmg.classes;

import br.ufmg.enums.TipoPlano;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Teste Unitário da Classe Usuário")
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
    @DisplayName("Quando chamar getUsername deverá retornar o Username do Usuário")
    void getUsername_DeveraRetornarUsernameDoUsuario() {
        //ACT
        var result = usuario.getUsername();

        //ASSERT
        assertEquals(username, result);
    }

    @Test
    @DisplayName("Quando chamar getPassword, deverá retornar o Password do Usuário")
    void getPassword_DeveraRetornarPasswordDoUsuario() {
        //ACT
        var result = usuario.getPassword();

        //ASSERT
        assertEquals(password, result);
    }

    @Test
    @DisplayName("Quando chamar getNome deverá retornar o Nome do Usuário")
    void getNome_DeveraRetornarNomeDoUsuario() {
        //ACT
        var result = usuario.getNome();

        //ASSERT
        assertEquals(nome, result);
    }

    @Test
    @DisplayName("Quando chamar getTelefone deverá retornar o telefone do usuário")
    void getTelefone_DeveraRetornarTelefoneDoUsuario() {
        //ACT
        var result = usuario.getTelefone();

        //ASSERT
        assertEquals(telefone, result);
    }

    @Test
    @DisplayName("Quando chamar getEmail deverá retornar o email do usuário")
    void getEmail_DeveraRetornarEmailDoUsuario() {
        //ACT
        var result = usuario.getEmail();

        //ASSERT
        assertEquals(email, result);
    }

    @Test
    @DisplayName("Quando chamar getConta deverá retornar a conta do usuário")
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