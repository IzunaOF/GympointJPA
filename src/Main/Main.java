package Main;

import Entities.Usuario;
import Repositories.Hibernate.HibernateUsuarioRepository;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        HibernateUsuarioRepository repo = new HibernateUsuarioRepository();

        Usuario user = repo.buscarPorEmail("teste@gmail.com");

        System.out.println(user.getNome());
    }

}
