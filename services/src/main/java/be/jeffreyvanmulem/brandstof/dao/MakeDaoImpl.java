package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDAO;
import be.jeffreyvanmulem.brandstof.dao.interfaces.types.MakeDao;
import be.jeffreyvanmulem.brandstof.model.Make;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 11/05/12
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "makeDao")
public class MakeDaoImpl extends AbstractDAO<Make> implements MakeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<Make> getClazz() {
        return Make.class;
    }
}
