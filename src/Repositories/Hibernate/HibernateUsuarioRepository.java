package Repositories.Hibernate;

import Entities.Usuario;
import Enums.Funcao;
import Repositories.UsuarioRepository;
import Utils.JpaManager;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class HibernateUsuarioRepository implements UsuarioRepository {

    private final EntityManager entityManager;

    public HibernateUsuarioRepository() {
        this.entityManager = JpaManager.getEntityManager();
    }

    @Override
    public Usuario criar(Usuario usuario) {
        Usuario user = null;
        try {
            user = new Usuario("teste", "teste@gmail.com", "teste123", Funcao.CLIENTE);
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(user);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Algo deu errado!");
        } finally {
            this.entityManager.close();
            return user;
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) {

        try {
            TypedQuery<Usuario> query = this.entityManager.createQuery("SELECT u FROM Usuario as u WHERE u.email = :email", Usuario.class);
            query.setParameter("email", email);
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        } finally {
            this.entityManager.close();
        }
    }

}
