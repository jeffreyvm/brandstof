package be.jeffreyvanmulem.brandstof.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffreyvanmulem
 */
@Entity
@Table(name = "User")
@NamedQueries(
        {
                @NamedQuery(name = User.FINDALL, query = "select p from User p")
        }
)
public class User extends DomainObject {

    public static final String FINDALL = "User.FindAll";

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Description")
    private String description;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    private Set<UserRole> roles = new HashSet<UserRole>();

    /**
     * The default constructor
     */
    public User() {
        super();
        this.roles = new HashSet<UserRole>();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the roles
     */
    public Set<UserRole> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}