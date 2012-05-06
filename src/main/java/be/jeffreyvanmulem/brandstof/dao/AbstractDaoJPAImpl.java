package be.jeffreyvanmulem.brandstof.dao;

import be.jeffreyvanmulem.brandstof.dao.interfaces.Dao;
import be.jeffreyvanmulem.brandstof.model.DomainObject;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDaoJPAImpl<T extends DomainObject> extends JpaDaoSupport implements Dao<T> {

    private Class<T> domainClass;


    public AbstractDaoJPAImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    @Transactional
    public void delete(T object) {
        getJpaTemplate().remove(object);
    }

    @Transactional
    public T load(Serializable id) {
        return (T) getJpaTemplate().find(domainClass, id);
    }

    @Transactional
    public T save(T object) {
        return getJpaTemplate().merge(object);
    }

}


