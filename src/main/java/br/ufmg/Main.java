package br.ufmg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import br.ufmg.classes.Conta;
import br.ufmg.classes.Filme;
import br.ufmg.classes.Perfil;
import br.ufmg.classes.Plano;
import br.ufmg.classes.Serie;
import br.ufmg.classes.Usuario;
import br.ufmg.repositories.FilmesRepository;
import br.ufmg.repositories.PlanosRepository;
import br.ufmg.repositories.SeriesRepository;
import br.ufmg.repositories.UsuariosRepository;

public class Main {

    static UsuariosRepository _usuariosRepository;
    static PlanosRepository _planosRepository;
    public static void main(String[] args) throws IOException {

        _usuariosRepository = new UsuariosRepository();
        _planosRepository = new PlanosRepository();

        String option = menuPrincipal();
        String sair = "X";

        while (!option.equals(sair)) {

            if ("1".equals(option)) {
                Acessar();
            } else if ("2".equals(option)) {
                Cadastrar();
            } else {
                break;
            }

            option = menuPrincipal();
        }
        System.out.println("Obrigado por utilizar nossos serviços.");
    }

    private static String menuPrincipal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printHeader(null, null);
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Acessar");
        System.out.println("2 - Cadastrar");
        System.out.println("X - Sair");
        printFooter();

        System.out.print("O que gostaria de fazer? ");

        return br.readLine();
    }

    private static void Acessar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o username: ");
        String username = br.readLine();

        System.out.print("Digite o password: ");
        String password = br.readLine();

        if (_usuariosRepository.UsuarioCadastrado(username, password))
        {
            Usuario user = _usuariosRepository.BuscarUsuario(username, password);
            Perfil perfil = user.getConta().retornarPerfilDefault();

            String option = Menu(user, perfil);

            label:
            while (!option.equals("X"))
            {
                switch (option) {
                    case "1":
                        perfil = TrocarPerfil(user);
                        break;
                    case "2":
//                        CriarNovoPerfil(user);
                        break;
                    case "3":
                        AcessarFilmes();
                        break;
                    case "4":
                        AcessarSeries();
                        break;
                    case "5":
                        AcessarMinhaLista(perfil);
                        break;
                    case "6":
//                        EfetuarPagamento(user);
                        break;
                    default:
                        break label;
                }

                option = Menu(user, perfil);
            }
        }
        else
        {
            System.out.println("> Usuário não cadastrado.");
            System.out.println("> Crie uma conta para poder acessar a plataforma.");
        }
    }

    private static String Menu(Usuario usuario, Perfil perfil) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printHeader(usuario, perfil);
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Trocar Perfil");
        System.out.println("2 - Criar Novo Perfil");
        System.out.println("3 - Acessar Seção de Filmes");
        System.out.println("4 - Acessar Seção de Séries");
        System.out.println("5 - Acessar Minha Lista");
        System.out.println("6 - Efetuar Pagamento");
        System.out.println("X - Sair");
        printFooter();

        System.out.print("Qual opção? " );
        String option = br.readLine();

        return option.toUpperCase();
    }

    private static Perfil TrocarPerfil(Usuario usuario) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Perfil> perfis = usuario.getConta().retornarListaPerfis();

        System.out.println("Perfis Cadastrados");
        for (int i = 0; i < perfis.size(); i++) {
            Perfil perfil = perfis.get(i);

            System.out.printf("%d - %s", i, perfil.getNome());
        }

        System.out.print("Qual perfil deseja acessar? " );
        int option = Integer.parseInt(br.readLine());

        return perfis.get(option);
    }

    private static void AcessarFilmes() {
        FilmesRepository filmesRepository = new FilmesRepository();

        ArrayList<Filme> filmes = filmesRepository.retornarLista();

        for (Filme filme : filmes) {
            System.out.printf("Filme: %s\n", filme.getTitulo());
        }
    }

    private static void AcessarSeries() {
        SeriesRepository seriesRepository = new SeriesRepository();

        ArrayList<Serie> series = seriesRepository.retornarLista();

        for (Serie serie : series) {
            System.out.printf("Serie: %s\n", serie.getTitulo());
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

    private static void Cadastrar() throws IOException {
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

        ArrayList<Plano> planos = _planosRepository.retornarLista();
        System.out.println("Planos Disponíveis");
        for (int i = 0; i < planos.size(); i++) {

            Plano plano = planos.get(i);
            System.out.printf("%d - Plano %s - Preço: R$%.2f\n", i, plano.getTipo(), plano.getPreco());
        }

        System.out.print("Qual plano desejado? ");
        int option = Integer.parseInt(br.readLine());

        Conta conta = new Conta(planos.get(option));
        usuario.setConta(conta);

        _usuariosRepository.cadastrar(usuario);
    }

    private static void printHeader(Usuario usuario, Perfil perfil) {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("****** Sistema de Gerenciamento de Vídeos ******");
        if (usuario != null || perfil != null) {
            String username = null;
            if (usuario != null) {
                username = usuario.getUsername();
            }
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
