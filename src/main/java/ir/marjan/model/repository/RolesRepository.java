package ir.marjan.model.repository;

import ir.marjan.model.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RolesRepository implements GenericRepository<Role> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM Role r where r.id=:x").setParameter("x", id).executeUpdate();
    }

    @Override
    public Role select(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> select() {
        return entityManager.createQuery("SELECT e FROM Role e").getResultList();
    }

    public Role select(String username){
        return (Role) entityManager.createQuery("select r from Role r where r.username=:x").setParameter("x",username).getSingleResult();
    }
}
