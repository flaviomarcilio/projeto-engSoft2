package br.ufmg.classes;

import br.ufmg.enums.Genero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PerfilTest {

    Perfil perfil;

    @BeforeEach
    void setUp() {
        //ARRANGE
        perfil = new Perfil(18, "English");
    }

    @Test
    void isAtivo_QuandoCriarNovoPerfil_PerfilDeveraEstarAtivo() {
        //ACT
        var result = perfil.isAtivo();

        //ASSERT
        assertTrue(result);
    }

    @Test
    void excluir_QuandoExcluirPerfil_PerfilNaoDeveraEstarAtivo() {
        //ACT
        perfil.Excluir();
        var result = perfil.isAtivo();

        //ASSERT
        assertFalse(result);
    }

    @Test
    void getMinhaListaFilmes_QuandoAdicionarFilmesNaMinhaLista_MinhaListaDeFilmesNaoDeveraEstarVazia() {
        //ARRANGE
        Filme f1 = new Filme("Filme1", 16, Genero.ACAO, "12/12/2023",
                "2:30", "Diretor");
        Filme f2 = new Filme("Filme2", 18, Genero.TERROR, "12/12/2022",
                "2:30", "Diretor");
        Filme f3 = new Filme("Filme3", 12, Genero.COMEDIA, "01/01/2020",
                "1:40", "Diretor");

        perfil.AdicionarFilmeNaMinhaLista(f1);
        perfil.AdicionarFilmeNaMinhaLista(f2);
        perfil.AdicionarFilmeNaMinhaLista(f3);

        //ACT
        var listaFilmes = perfil.getMinhaListaFilmes();

        //ASSERT
        assertFalse(listaFilmes.isEmpty());
    }

    @Test
    void getMinhaListaSeries_QuandoAdicionarSeriesNaMinhaLista_MinhaListaDeSeriesNaoDeveraEstarVazia() {
        //ARRAGE
        Serie s1 = new Serie("Série1", 14, Genero.FANTASIA, "14/12/2021",
                "1:20", "Diretor", 3);
        Serie s2 = new Serie("Série2", 14, Genero.FANTASIA, "12/01/2018",
                "1:30", "Diretor", 3);
        Serie s3 = new Serie("Série3", 14, Genero.FANTASIA, "20/05/2012",
                "1:00", "Diretor", 3);

        perfil.AdicionarSerieNaMinhaLista(s1);
        perfil.AdicionarSerieNaMinhaLista(s2);
        perfil.AdicionarSerieNaMinhaLista(s3);

        //ACT
        var listaSeries = perfil.getMinhaListaSeries();

        //ASSERT
        assertFalse(listaSeries.isEmpty());
    }
}