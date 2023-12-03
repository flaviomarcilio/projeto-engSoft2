package br.ufmg.services;

import br.ufmg.classes.Conta;
import br.ufmg.classes.Perfil;
import br.ufmg.classes.Usuario;
import br.ufmg.repositories.UsuariosRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes de Integração do serviço de Usuário")
class UsuarioServiceIT {

    @Mock
    private UsuariosRepository mockUsuariosRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    @DisplayName("Quando cadastrar novo usuário, o método cadastrar do repositório de usuário deverá ser chamado")
    void cadastrar() {
        //ARRANGE
        Usuario usuarioMock = mock(Usuario.class);

        //ACT
        usuarioService.cadastrar(usuarioMock);

        //ASSERT - Verifica se o método cadastrar do repositório foi chamado com o usuário correto
        verify(mockUsuariosRepository).cadastrar(usuarioMock);
    }

    @Test
    @DisplayName("Quando busca um usuário, o método buscarUsuario do repositório de usuário deverá ser chamado")
    void buscarUsuario() {
        //ARRANGE
        String username = "Username";
        String password = "Senha";

        //ACT
        usuarioService.BuscarUsuario(username, password);

        //ASSERT - Verifica se o método buscarUsuario do repositório foi chamado com os parâmetros corretos
        verify(mockUsuariosRepository).BuscarUsuario(username, password);
    }

    @Test
    @DisplayName("Quando solicitar os perfis do usuário, o método retornarListaPerfis da conta do usuário deverá ser chamado")
    void retornarPerfis() {
        //ARRANGE
        Usuario usuarioMock = mock(Usuario.class);

        Conta contaMock = mock(Conta.class);
        when(usuarioMock.getConta()).thenReturn(contaMock);

        ArrayList<Perfil> perfisMock = new ArrayList<>();
        when(contaMock.retornarListaPerfis()).thenReturn(perfisMock);

        //ACT
        usuarioService.retornarPerfis(usuarioMock);

        //ARRANGE - Verifica se o método retornarListaPerfis da conta foi chamado
        verify(contaMock).retornarListaPerfis();
    }

    @Test
    @DisplayName("Quando solicitar o perfil default, o método retornarPerfilDefault da conta do usuário deverá ser chamado")
    void retornarPerfilDefault() {
        //ARRANGE
        Usuario usuarioMock = mock(Usuario.class);

        Conta contaMock = mock(Conta.class);
        when(usuarioMock.getConta()).thenReturn(contaMock);

        //ACT
        usuarioService.retornarPerfilDefault(usuarioMock);

        //ASSERT - Verifica se o método retornarPerfilDefault da conta foi chamado
        verify(contaMock).retornarPerfilDefault();
    }
}