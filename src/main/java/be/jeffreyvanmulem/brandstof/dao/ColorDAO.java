package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.abstr.AbstractTypeDAO;
import be.jeffreyvanmulem.brandstof.model.types.Color;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 11/05/12
 * Time: 22:12
 * To change this template use File | Settings | File Templates.
 */

@Repository(value = "colorDao")
public class ColorDAO extends AbstractTypeDAO<Color> implements be.jeffreyvanmulem.brandstof.dao.interfaces.types.ColorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<Color> getClazz() {
        return Color.class;
    }
}
