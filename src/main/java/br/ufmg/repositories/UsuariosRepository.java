package br.ufmg.repositories;

import br.ufmg.classes.Usuario;

import java.util.ArrayList;

public class UsuariosRepository {

    private final ArrayList<Usuario> usuarios;
    public UsuariosRepository() {
        usuarios = new ArrayList<>();
    }

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario BuscarUsuario(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean UsuarioCadastrado(String username, String password) {
        if (usuarios.isEmpty()) return false;

        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
