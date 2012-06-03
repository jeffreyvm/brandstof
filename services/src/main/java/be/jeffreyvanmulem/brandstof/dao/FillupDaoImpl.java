package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDAO;
import be.jeffreyvanmulem.brandstof.dao.interfaces.FillupDao;
import be.jeffreyvanmulem.brandstof.model.Fillup;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 11/05/12
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "fillupDao")
public class FillupDaoImpl extends AbstractDAO<Fillup> implements FillupDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<Fillup> getClazz() {
        return Fillup.class;
    }
}
