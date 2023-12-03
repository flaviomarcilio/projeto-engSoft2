package br.ufmg;

import br.ufmg.services.*;

import java.io.IOException;

public class Main {

    static ApplicationService applicationService;
    public static void main(String[] args) throws IOException {
        UsuarioService usuarioService = new UsuarioService();
        PlanoService planoService = new PlanoService();
        FilmeService filmeService = new FilmeService();
        SerieService serieService = new SerieService();

        applicationService = new ApplicationService(usuarioService, planoService, filmeService, serieService);

        String option = applicationService.menuPrincipal();
        String sair = "X";

        while (!option.equals(sair)) {

            if ("1".equals(option)) {
                applicationService.Acessar();
            } else if ("2".equals(option)) {
                applicationService.Cadastrar();
            } else {
                break;
            }

            option = applicationService.menuPrincipal();
        }
        System.out.println("Obrigado por utilizar nossos serviços.");
    }
}
