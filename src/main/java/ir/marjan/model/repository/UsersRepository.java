package ir.marjan.model.repository;

import ir.marjan.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsersRepository implements GenericRepository<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(User userTo) {
        entityManager.persist(userTo);
    }

    @Override
    public void update(User userTo) {
        entityManager.merge(userTo);
    }

    @Override
    public void delete(User userTo) {
        entityManager.remove(userTo);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User r where r.id=:x").setParameter("x", id).executeUpdate();
    }

    @Override
    public User select(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> select() {
        return entityManager.createQuery("SELECT e FROM User e").getResultList();
    }


    public User select(String username) {
        return (User) entityManager
                .createQuery("SELECT u FROM User u where u.username=:x")
                .setParameter("x", username)
                .getSingleResult();
    }
}
