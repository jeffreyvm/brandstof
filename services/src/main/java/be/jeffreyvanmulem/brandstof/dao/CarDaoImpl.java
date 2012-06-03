package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.abstr.AbstractDAO;
import be.jeffreyvanmulem.brandstof.dao.interfaces.CarDao;
import be.jeffreyvanmulem.brandstof.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 11/05/12
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "carDao")
public class CarDaoImpl extends AbstractDAO<Car> implements CarDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<Car> getClazz() {
        return Car.class;
    }
}