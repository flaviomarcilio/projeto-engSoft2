package br.ufmg.services;

import br.ufmg.repositories.FilmesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes de Integração do Serviço de Filme")
class FilmeServiceIT {

    @Mock
    private FilmesRepository mockFilmesRepository;

    @InjectMocks
    private FilmeService filmeService;

    @Test
    @DisplayName("Quando solicitar a lista de filmes, o método retornarLista do repositório de filmes deverá ser chamado")
    void retornarListaDeFilmes() {
        //ARRANGE
        //ACT
        filmeService.retornarLista();

        //ASSERT - Verifica se o método retornarLista do repositório foi chamado
        verify(mockFilmesRepository).retornarLista();
    }
}