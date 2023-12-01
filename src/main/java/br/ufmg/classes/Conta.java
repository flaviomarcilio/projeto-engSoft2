package br.ufmg.classes;

import java.util.ArrayList;

public class Conta {
    private Plano plano;
    private final ArrayList<Perfil> perfis;
    private boolean ativo;

    public Conta(Plano plano) {
        this.plano = plano;
        ativo = true;
        perfis = new ArrayList<>();

        Perfil perfil = new Perfil(18, "Português");
        perfis.add(perfil);
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

    public Perfil retornarPerfilDefault() {
        return retornarPerfilPorId(0);
    }

    public Perfil retornarPerfilPorId(int id) {
        return perfis.get(id);
    }

    public ArrayList<Perfil> retornarListaPerfis() {
        return perfis;
    }
}
