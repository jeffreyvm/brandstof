package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDAO;
import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
@Repository(value="userDao")
public class UserDaoImpl extends AbstractDAO<User> implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<User> getClazz() {
        return User.class;
    }
}

