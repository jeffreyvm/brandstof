package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.model.User;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoJPAImp extends AbstractDaoJPAImpl<User> implements UserDao {

    public UserDaoJPAImp() {
        super(User.class);
    }

    @Transactional
    public List<User> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<User>>() {
            public List<User> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<User> query = em.createQuery("select e from User e", User.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from User e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }
}

