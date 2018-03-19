package ir.marjan.model.repository;

import ir.marjan.model.entity.TimeTable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TimeTablesRepository implements GenericRepository<TimeTable> {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(TimeTable timetable) {
        entityManager.persist(timetable);
    }

    @Override
    public void update(TimeTable timetable) {
        entityManager.merge(timetable);
    }

    @Override
    public void delete(TimeTable timetable) {
        entityManager.remove(timetable);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM TimeTable r where r.id=:x").setParameter("x", id).executeUpdate();
    }

    @Override
    public TimeTable select(long id) {
        return entityManager.find(TimeTable.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TimeTable> select() {
        return entityManager.createQuery("SELECT e FROM TimeTable e order by e.id").getResultList();
    }
}
