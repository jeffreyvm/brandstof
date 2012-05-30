package be.jeffreyvanmulem.brandstof.service;

import be.jeffreyvanmulem.brandstof.model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 30/05/12
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    User findById(Long id);

    void save(User location);

    User update(User location);

    void remove(User location);

    long size();

    List<User> findAll();
}
