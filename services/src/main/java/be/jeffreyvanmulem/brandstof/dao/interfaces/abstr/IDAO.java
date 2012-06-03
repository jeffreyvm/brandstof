package be.jeffreyvanmulem.brandstof.dao.interfaces.abstr;

import be.jeffreyvanmulem.brandstof.model.abstr.IEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 30/05/12
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
public interface IDAO<EntityClass extends IEntity>  {
    List<EntityClass> findAll();

    EntityClass findById(Long id);

    EntityClass findByProperty(String propertyName, Object propertyValue);

    void remove(EntityClass entity);

    void removeSafely(EntityClass entity);

    void persist(EntityClass entity);

    EntityClass merge(EntityClass entity);

    EntityManager getEntityManager();

    long size();

    Class<EntityClass> getClazz();

    EntityClass getReference(EntityClass entity);
}
