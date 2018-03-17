package ir.marjan.model.service;

import ir.marjan.model.entity.User;
import ir.marjan.model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements GenericService<User> {

    @Autowired
    private UsersRepository ur;

    @Override
    public void save(User user) {
        ur.insert(user);
    }

    @Override
    public void edit(User user) {
        ur.update(user);
    }

    @Override
    public void remove(User user) {
        ur.delete(user);
    }

    @Override
    public void remove(long id) {
        ur.delete(id);
    }

    @Override
    public User find(long id) {
        return ur.select(id);
    }

    @Override
    public List<User> findAll() {
        return ur.select();
    }

    public User findByUserName(String username) {
        return ur.select(username);
    }
}
