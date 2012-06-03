package be.jeffreyvanmulem.brandstof.model;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 18:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model")
public class Model extends DomainObject {

    @ManyToOne
    @JoinColumn(name = "Make_id")
    private Make make;

    @Column(name = "Name")
    private String name;

    @Column(name = "Year")
    private LocalDate year;

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
