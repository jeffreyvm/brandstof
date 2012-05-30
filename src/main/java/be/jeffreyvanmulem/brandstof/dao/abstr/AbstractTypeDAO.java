package be.jeffreyvanmulem.brandstof.dao.abstr;

import be.jeffreyvanmulem.brandstof.dao.interfaces.abstr.TypeDAO;
import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 8/05/12
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractTypeDAO<T extends DomainObjectType> extends AbstractDAO<T> implements TypeDAO<T> {

}
