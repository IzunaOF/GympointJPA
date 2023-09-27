package Repositories.InMemory;

import Entities.Usuario;
import Repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUsuarioRepository implements UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario criar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }

        return null;
    }

}
