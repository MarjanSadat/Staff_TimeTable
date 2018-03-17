package ir.marjan.model.service;

import ir.marjan.model.entity.TimeTable;
import ir.marjan.model.entity.User;
import ir.marjan.model.repository.TimeTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimeTableService implements GenericService<TimeTable> {

    @Autowired
    private TimeTablesRepository ttr;

    @Override
    public void save(TimeTable timeTables) {
        ttr.insert(timeTables);
    }

    @Override
    public void edit(TimeTable timeTables) {
        ttr.update(timeTables);
    }

    @Override
    public void remove(TimeTable timeTables) {
        ttr.delete(timeTables);
    }

    @Override
    public void remove(long id) {
        ttr.delete(id);
    }

    @Override
    public TimeTable find(long id) {
        return ttr.select(id);
    }

    @Override
    public List<TimeTable> findAll() {
        return ttr.select();
    }
}
