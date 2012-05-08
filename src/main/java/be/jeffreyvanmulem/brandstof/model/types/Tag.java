package be.jeffreyvanmulem.brandstof.model.types;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Tag")
public class Tag extends DomainObjectType {
    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
