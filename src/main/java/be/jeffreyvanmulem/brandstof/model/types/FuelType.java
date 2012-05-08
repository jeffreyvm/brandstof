package be.jeffreyvanmulem.brandstof.model.types;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;
import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "FuelType")
public class FuelType extends DomainObjectType {
    @Column(name="Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
