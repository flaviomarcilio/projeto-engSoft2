import classes.*;
import repositories.FilmesRepository;
import repositories.PlanosRepository;
import repositories.SeriesRepository;
import repositories.UsuariosRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static UsuariosRepository _usuariosRepository;
    static PlanosRepository _planosRepository;
    public static void main(String[] args) throws IOException {

        _usuariosRepository = new UsuariosRepository();
        _planosRepository = new PlanosRepository();

        String opcao = menuPrincipal();
        String sair = "X";

        while (!opcao.equals(sair)) {

            if ("1".equals(opcao)) {
                Acessar();
            } else if ("2".equals(opcao)) {
                Cadastrar();
            } else {
                break;
            }

            opcao = menuPrincipal();
        }
        System.out.println("Obrigado por utilizar nossos serviços.");
    }

    private static String menuPrincipal() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printHeader(null, null);
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Acessar");
        System.out.println("2 - Cadastrar");
        System.out.println("X - Sair");
        printFooter();

        System.out.print("O que gostaria de fazer? ");
        String opcao = br.readLine();

        return opcao;
    }

    private static void Acessar() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o username: ");
        String username = br.readLine();

        System.out.print("Digite o password: ");
        String password = br.readLine();

        if (_usuariosRepository.UsuarioCadastrado(username, password))
        {
            Usuario usuario = _usuariosRepository.BuscarUsuario(username, password);
            Perfil perfil = usuario.getConta().retornarPerfilPorId(0);

            String opcao = Menu(usuario, perfil);

            while (!opcao.equals("X"))
            {
                if ("1".equals(opcao)) {
                    perfil = TrocarPerfil(usuario);
                } else if ("2".equals(opcao)) {
                    AcessarFilmes(perfil);
                } else if ("3".equals(opcao)) {
                    AcessarSeries(perfil);
                } else if ("4".equals(opcao)) {
                    AcessarMinhaLista(perfil);
                } else {
                    break;
                }

                opcao = Menu(usuario, perfil);
            }
        }
        else
        {
            System.out.println("> Usuário não cadastrado.");
            System.out.println("> Crie uma conta para poder acessar a plataforma.");
        }
    }

    private static void AcessarMinhaLista(Perfil perfil) {
        for (Filme filme : perfil.getMinhaListaFilmes()) {
            System.out.printf("Filme: %s\n", filme.getTitulo());
        }
        for (Serie serie : perfil.getMinhaListaSeries()) {
            System.out.printf("Série: %s\n", serie.getTitulo());
        }
    }

    private static void AcessarSeries(Perfil perfil) {
        SeriesRepository seriesRepository = new SeriesRepository();

        ArrayList<Serie> seriesDisponiveis = seriesRepository.retornarLista();

        for (Serie serie : seriesDisponiveis) {
            System.out.printf("Serie: %s\n", serie.getTitulo());
        }
    }

    private static void AcessarFilmes(Perfil perfil) {
        FilmesRepository filmesRepository = new FilmesRepository();

        ArrayList<Filme> filmesDisponiveis = filmesRepository.retornarLista();

        for (Filme filme : filmesDisponiveis) {
            System.out.printf("Filme: %s\n", filme.getTitulo());
        }
    }

    private static Perfil TrocarPerfil(Usuario usuario) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Perfil> perfis = usuario.getConta().retornarListaPerfis();

        System.out.println("Perfis Cadastrados");
        for (int i = 0; i < perfis.size(); i++) {
            Perfil perfil = perfis.get(i);

            System.out.printf("%d - %s", i, perfil.getNome());
        }

        System.out.print("Qual perfil deseja? " );
        int opcao = Integer.parseInt(br.readLine());

        return perfis.get(opcao);
    }

    private static String Menu(Usuario usuario, Perfil perfil) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printHeader(usuario, perfil);
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Trocar Perfil");
        System.out.println("2 - Acessar Seção de Filmes");
        System.out.println("3 - Acessar Seção de Séries");
        System.out.println("4 - Acessar Minha Lista");
        System.out.println("X - Sair");
        printFooter();

        System.out.print("Qual opção? " );
        String opcao = br.readLine();

        return opcao.toUpperCase();
    }

    private static void Cadastrar() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite seu Nome: ");
        String nome = br.readLine();

        System.out.print("Digite seu Email: ");
        String email = br.readLine();

        System.out.print("Digite seu Telefone: ");
        String telefone = br.readLine();

        System.out.print("Digite seu nome de usuário: ");
        String username = br.readLine();

        System.out.print("Digite sua senha: ");
        String senha = br.readLine();

        Usuario usuario = new Usuario(nome, telefone, email, username, senha);

        ArrayList<Plano> planosDisponiveis = _planosRepository.retornarLista();
        System.out.println("Planos Disponíveis");
        for (int i = 0; i < planosDisponiveis.size(); i++) {

            Plano plano = planosDisponiveis.get(i);
            System.out.printf("%d - Plano %s - Preço: R$%.2f\n", i, plano.getTipo(), plano.getPreco());
        }

        System.out.print("Qual plano desejado? ");
        int opcaoPlano = Integer.parseInt(br.readLine());

        Conta conta = new Conta(planosDisponiveis.get(opcaoPlano));
        usuario.setConta(conta);

        _usuariosRepository.cadastrar(usuario);
    }

    private static void printHeader(Usuario usuario, Perfil perfil) {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("****** Sistema de Gerenciamento de Vídeos ******");
        if (usuario != null || perfil != null) {
            String username = usuario.getUsername();
            String perfilName = perfil.getNome();
            System.out.printf("Usuário Logado: %s | Perfil: %s\n", username, perfilName);
        }
        System.out.println("************************************************");
        System.out.println();
    }

    private static void printFooter() {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*********** EnGSoFT 2 - 2023/2 *****************");
        System.out.println("************************************************");
        System.out.println();
    }
}
