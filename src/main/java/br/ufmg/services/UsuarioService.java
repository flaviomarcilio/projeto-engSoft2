package br.ufmg.services;

import br.ufmg.classes.Perfil;
import br.ufmg.classes.Usuario;
import br.ufmg.repositories.UsuariosRepository;

import java.util.ArrayList;

public class UsuarioService {

    private UsuariosRepository _usuariosRepository;

    public UsuarioService(UsuariosRepository usuariosRepository) {
        _usuariosRepository = usuariosRepository;
    }

    public UsuarioService() {
        _usuariosRepository = new UsuariosRepository();
    }

    public void cadastrar(Usuario usuario) {
        _usuariosRepository.cadastrar(usuario);
    }

    public Usuario BuscarUsuario(String username, String password) {
        return _usuariosRepository.BuscarUsuario(username, password);
    }

    public ArrayList<Perfil> retornarPerfis(Usuario usuario) {
        return usuario.getConta().retornarListaPerfis();
    }

    public Perfil retornarPerfilDefault(Usuario usuario) {
        return usuario.getConta().retornarPerfilDefault();
    }
}
