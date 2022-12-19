package web_crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web_crud.model.User;


import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(Long aLong);

    @Override
    Iterable<User> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(User entity);

    @Override
    void deleteAll();
}