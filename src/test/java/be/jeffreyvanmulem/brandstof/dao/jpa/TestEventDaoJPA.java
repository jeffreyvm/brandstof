package be.jeffreyvanmulem.brandstof.dao.jpa;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */

import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffrey Van Mulem
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestEventDaoJPA {

    @Autowired
    private UserDao userDao;

    protected User user;

    @Before
    public void startTransaction() {
        user = new User();
        user.setUsername("new user");
        user = userDao.save(user);
    }


    /**
     * Test method for {@link be.jeffreyvanmulem.brandstof.dao.UserDaoImpl#findAll()}.
     */
    @Test
    @Transactional
    @Rollback
    public void testFindAll() {
        List<User> users = new ArrayList<User>();
        users.add(user);
        Assert.assertEquals(users, userDao.findAll());
    }

    /**
     * Test method for {@link be.jeffreyvanmulem.brandstof.dao.UserDaoImpl#countAll()}.
     */
    @Test
    @Transactional
    @Rollback
    public void testCountAll() {
        Assert.assertEquals(1, userDao.countAll());
    }

    /**
     * Test method for AbstractDaoImpl#delete(DomainObject)
     */
    @Test
    @Transactional
    @Rollback
    public void testDelete() {
        userDao.delete(user);
        Assert.assertEquals(0, userDao.countAll());
    }

    /**
     * Test method for {@link be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDaoImpl#load(java.io.Serializable)}.
     */
    @Test
    @Transactional
    @Rollback
    public void testLoad() {
        User user2 = userDao.load(user.getId());
        Assert.assertEquals(user, user2);
    }

    /**
     * Test method for {@link be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDaoImpl#save(be.jeffreyvanmulem.brandstof.model.abstr.DomainObject)}.
     */
    @Test
    @Transactional
    @Rollback
    public void testSave() {
        //if we have got this far then save works
    }

}
