package be.jeffreyvanmulem.brandstof.model;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;
import be.jeffreyvanmulem.brandstof.model.types.Color;
import be.jeffreyvanmulem.brandstof.model.types.FuelType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Car")
@NamedQueries(
        {
                @NamedQuery(name = Car.FINDALL, query = "select c from Car c")
        }
)
public class Car extends DomainObject {

    public static final String FINDALL = "Car.FindAll";

    @Column(name = "LicensePlate", unique = true, nullable = false)
    private String licensePlate;

    @Column(name = "EngineSize")
    private Float engineSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Model_id")
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FuelType_id")
    private FuelType fuelType;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Set<Fillup> fillups = new HashSet<Fillup>();

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Float engineSize) {
        this.engineSize = engineSize;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Fillup> getFillups() {
        return fillups;
    }

    public void setFillups(Set<Fillup> fillups) {
        this.fillups = fillups;
    }
}
