package web_crud.service;


import web_crud.dao.UserDao;
import web_crud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService<Long, User> {

    private final UserDao<Long, User> userDao;

    public UserServiceImpl(UserDao<Long, User> userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}