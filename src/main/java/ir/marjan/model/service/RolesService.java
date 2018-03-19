package ir.marjan.model.service;

import ir.marjan.model.entity.Role;
import ir.marjan.model.entity.User;
import ir.marjan.model.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService implements GenericService<Role>{


    @Autowired
    private RolesRepository rr;

    @Override
    public void save(Role role) {
        rr.insert(role);
    }

    @Override
    public void edit(Role role) {
        rr.update(role);
    }

    @Override
    public void remove(Role role) {
        rr.delete(role);
    }

    @Override
    public void remove(long id) {
        rr.delete(id);
    }

    @Override
    public Role find(long id) {
        return rr.select(id);
    }

    public Role findByUsername(String username){
        return rr.select(username);
    }
    @Override
    public List<Role> findAll() {
        return rr.select();
    }
}
