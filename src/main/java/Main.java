import classes.*;
import enums.Genero;
import enums.TipoPlano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Usuario> _usuariosCadastrados = new ArrayList<Usuario>();
    static ArrayList<Plano> _planosDisponiveis = new ArrayList<Plano>();
    static ArrayList<Filme> _filmesDisponiveis = new ArrayList<Filme>();
    static ArrayList<Serie> _seriesDisponiveis = new ArrayList<Serie>();

    public static void main(String[] args) throws IOException {

        Plano p1 = new Plano(TipoPlano.BASICO, 25.90);
        Plano p2 = new Plano(TipoPlano.PADRAO, 39.90);
        Plano p3 = new Plano(TipoPlano.PREMIUM, 55.90);
        _planosDisponiveis.add(p1);
        _planosDisponiveis.add(p2);
        _planosDisponiveis.add(p3);

        Filme f1 = new Filme("Filme1", 16, Genero.ACAO, "12/12/2023",
                "2:30", "Diretor");
        Filme f2 = new Filme("Filme2", 18, Genero.TERROR, "12/12/2022",
                "2:30", "Diretor");
        Filme f3 = new Filme("Filme3", 12, Genero.COMEDIA, "01/01/2020",
                "1:40", "Diretor");
        _filmesDisponiveis.add(f1);
        _filmesDisponiveis.add(f2);
        _filmesDisponiveis.add(f3);

        Serie s1 = new Serie("Série1", 14, Genero.FANTASIA, "14/12/2021",
                "1:20", "Diretor", 3);
        Serie s2 = new Serie("Série2", 14, Genero.FANTASIA, "12/01/2018",
                "1:30", "Diretor", 3);
        Serie s3 = new Serie("Série3", 14, Genero.FANTASIA, "20/05/2012",
                "1:00", "Diretor", 3);
        _seriesDisponiveis.add(s1);
        _seriesDisponiveis.add(s2);
        _seriesDisponiveis.add(s3);

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

        if (UsuarioCadastrado(username, password))
        {
            Usuario usuario = BuscarUsuario(username, password);
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
        for (Serie serie : _seriesDisponiveis) {
            System.out.printf("Serie: %s\n", serie.getTitulo());
        }
    }

    private static void AcessarFilmes(Perfil perfil) {
        for (Filme filme : _filmesDisponiveis) {
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

    private static boolean UsuarioCadastrado(String username, String password)
    {
        if (_usuariosCadastrados.isEmpty()) return false;

        for (Usuario usuario : _usuariosCadastrados) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static Usuario BuscarUsuario(String username, String password)
    {
        for (Usuario usuario : _usuariosCadastrados)
        {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password))
            {
                return usuario;
            }
        }
        return null;
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

        System.out.println("Planos Disponíveis");
        for (int i = 0; i < _planosDisponiveis.size(); i++) {

            Plano plano = _planosDisponiveis.get(i);
            System.out.printf("%d - Plano %s - Preço: R$%.2f\n", i, plano.getTipo(), plano.getPreco());
        }

        System.out.print("Qual plano desejado? ");
        int opcaoPlano = Integer.parseInt(br.readLine());

        Conta conta = new Conta(_planosDisponiveis.get(opcaoPlano));
        usuario.setConta(conta);

        _usuariosCadastrados.add(usuario);
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
