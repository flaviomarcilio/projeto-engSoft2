package br.ufmg.services;

import br.ufmg.classes.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ApplicationService {

    static UsuarioService _usuarioService;
    static PlanoService _planoService;
    static FilmeService _filmeService;
    static SerieService _serieService;

    public ApplicationService(UsuarioService usuarioService, PlanoService planoService, FilmeService filmeService,
                              SerieService serieService) {
        _usuarioService = usuarioService;
        _planoService = planoService;
        _filmeService = filmeService;
        _serieService = serieService;
    }

    public String menuPrincipal() throws IOException {
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

    public void Acessar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o username: ");
        String username = br.readLine();

        System.out.print("Digite o password: ");
        String password = br.readLine();

        Usuario user = _usuarioService.BuscarUsuario(username, password);

        if (user != null)
        {
            Perfil perfil = _usuarioService.retornarPerfilDefault(user);

            String option = Menu(user, perfil);

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
                        break;
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

    public void Cadastrar() throws IOException {
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

        ArrayList<Plano> planos = _planoService.retornarTodos();

        System.out.println("Planos Disponíveis");
        for (int i = 0; i < planos.size(); i++) {

            Plano plano = planos.get(i);
            System.out.printf("%d - Plano %s - Preço: R$%.2f\n", i, plano.getTipo(), plano.getPreco());
        }

        System.out.print("Qual plano desejado? ");
        int option = Integer.parseInt(br.readLine());

        Conta conta = new Conta(planos.get(option));
        usuario.setConta(conta);

        _usuarioService.cadastrar(usuario);
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

        ArrayList<Perfil> perfis = _usuarioService.retornarPerfis(usuario);

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

        ArrayList<Filme> filmes = _filmeService.retornarLista();

        for (Filme filme : filmes) {
            System.out.printf("Filme: %s\n", filme.getTitulo());
        }
    }

    private static void AcessarSeries() {

        ArrayList<Serie> series = _serieService.retornarLista();

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
