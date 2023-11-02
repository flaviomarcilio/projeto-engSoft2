package classes;

import java.util.ArrayList;

public class Conta {
    private Plano plano;
    private ArrayList<Perfil> perfis;
    private boolean ativo;

    private int idPerfilEmUso;

    public Conta(Plano plano) {
        this.plano = plano;
        ativo = true;
        perfis = new ArrayList<Perfil>();

        Perfil perfil = new Perfil(18, "Português");
        perfis.add(perfil);
        idPerfilEmUso = 0;
    }

    public void AdicionarPerfil(Perfil perfil) {
        if (perfis.size() >= 5) {
            System.out.println("Não é possível adicionar outro perfil.");
            return;
        }
        perfis.add(perfil);
    }

    public boolean isAtivo() {

        return ativo;
    }

    public void Cancelar() {

        ativo = false;
    }

    public Plano getPlano() {

        return plano;
    }

    public void setPlano(Plano plano) {

        this.plano = plano;
    }

    public Perfil retornarPerfilPorId(int id) {

        return perfis.get(id);
    }

    public ArrayList<Perfil> retornarListaPerfis() {

        return perfis;
    }

    public Perfil retornarPerfilEmUso() {
        return perfis.get(idPerfilEmUso);
    }
}
