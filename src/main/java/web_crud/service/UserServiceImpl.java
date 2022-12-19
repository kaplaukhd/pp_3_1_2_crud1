package web_crud.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web_crud.model.User;
import web_crud.repository.UserRepo;

import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    public UserServiceImpl (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    @Override
    public <S extends User> S save(S entity) {
        return userRepo.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    @Transactional
    @Override
    public void delete(User entity) {
        userRepo.delete(entity);
    }

    @Transactional
    @Override
    public void deleteAll() {
        userRepo.deleteAll();
    }
}
