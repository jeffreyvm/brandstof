package be.jeffreyvanmulem.brandstof.model.abstr;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 30/05/12
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public interface IEntity extends Serializable {

    Long getId();

    boolean isNew();

    boolean isPersisted();

}
