package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDAO;
import be.jeffreyvanmulem.brandstof.dao.interfaces.types.ModelDao;
import be.jeffreyvanmulem.brandstof.model.Model;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 11/05/12
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "modelDao")
public class ModelDaoImpl extends AbstractDAO<Model> implements ModelDao {

    public EntityManager getEntityManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Class<Model> getClazz() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
