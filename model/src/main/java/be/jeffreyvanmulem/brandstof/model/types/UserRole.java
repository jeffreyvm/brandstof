package be.jeffreyvanmulem.brandstof.model.types;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jeffreyvanmulem
 */
@Entity
@Table(name = "UserRole")
public class UserRole extends DomainObjectType {

    @Column(name = "Role")
    private String role;

    @Column(name = "Description")
    private String description;

    public UserRole() {
        super();
    }

    public UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
