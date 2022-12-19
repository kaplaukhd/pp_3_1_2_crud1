package web_crud.service;

import org.springframework.stereotype.Service;
import web_crud.model.User;
import web_crud.repository.UserRepo;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    public UserServiceImpl (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public <S extends User> S save(S entity) {
        return userRepo.save(entity);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    @Override
    public void delete(User entity) {
        userRepo.delete(entity);
    }

    @Override
    public void deleteAll() {
        userRepo.deleteAll();
    }
}
