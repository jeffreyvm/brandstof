package be.jeffreyvanmulem.brandstof.service;

import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 30/05/12
 * Time: 20:54
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    public long size() {
        return userDao.size();
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public void remove(User location) {
        userDao.remove(location);
    }

    public void save(User location) {
        userDao.persist(location);
    }

    public User update(User location) {
        return userDao.merge(location);
    }
}
