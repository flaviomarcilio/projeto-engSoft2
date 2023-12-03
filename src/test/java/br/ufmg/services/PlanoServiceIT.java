package br.ufmg.services;

import br.ufmg.repositories.PlanosRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes de Integração do Serviço de Plano")
class PlanoServiceIT {

    @Mock
    private PlanosRepository mockPlanosRepository;

    @InjectMocks
    private PlanoService planoService;

    @Test
    @DisplayName("Quando solicitar a lista de planos disponíveis, o método retornarTodos do repositório de planos deverá ser chamado")
    void retornarTodosPlanosDisponíveis() {
        //ARRANGE
        //ACT
        planoService.retornarTodos();

        //ASSERT - Verifica se o método retornarTodos do repositório foi chamado
        verify(mockPlanosRepository).retornarLista();
    }
}