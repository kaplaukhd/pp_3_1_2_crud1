package web_crud.service;

import web_crud.model.User;
import java.util.Optional;

public interface UserService {

    <S extends User> S save(S entity);

    Optional<User> findById(Long aLong);

    Iterable<User> findAll();

    void deleteById(Long aLong);

    void delete(User entity);

    void deleteAll();
}
