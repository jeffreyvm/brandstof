package be.jeffreyvanmulem.brandstof.model;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;
import be.jeffreyvanmulem.brandstof.model.types.UserRole;

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

    @Column(name = "Email")
    private String email;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "Name")
    private String name;

    @Column(name = "SurName")
    private String surName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Car> cars = new HashSet<Car>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    private Set<UserRole> userRoles = new HashSet<UserRole>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}