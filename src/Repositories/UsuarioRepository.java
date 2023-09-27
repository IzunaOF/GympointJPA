package Repositories;

import Entities.Usuario;

public interface UsuarioRepository {
    public Usuario criar(Usuario usuario);
    public Usuario buscarPorEmail(String email);
}
