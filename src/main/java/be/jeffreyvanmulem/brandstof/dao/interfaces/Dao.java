package be.jeffreyvanmulem.brandstof.dao.interfaces;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public interface Dao<T extends DomainObject>
{
    public void delete(T o);

    public T load(Serializable id);

    public T save(T o);

    public List<T> findAll();

    public int countAll();
}

