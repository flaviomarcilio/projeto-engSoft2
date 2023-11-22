package br.ufmg.repositories;

import br.ufmg.classes.Usuario;

import java.util.ArrayList;

public class UsuariosRepository {

    private ArrayList<Usuario> _usuariosCadastrados;
    public UsuariosRepository() {
        _usuariosCadastrados = new ArrayList<Usuario>();
    }

    public void cadastrar(Usuario usuario) {
        _usuariosCadastrados.add(usuario);
    }

    public Usuario BuscarUsuario(String username, String password)
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

    public boolean UsuarioCadastrado(String username, String password)
    {
        if (_usuariosCadastrados.isEmpty()) return false;

        for (Usuario usuario : _usuariosCadastrados) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
