package be.jeffreyvanmulem.brandstof.dao.abstr;

import be.jeffreyvanmulem.brandstof.dao.interfaces.abstr.TypeDao;
import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 8/05/12
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractTypeDaoImpl<T extends DomainObjectType> extends AbstractDaoImpl<T> implements TypeDao<T> {

    public AbstractTypeDaoImpl(Class<T> domainClass) {
        super(domainClass);
    }
}
