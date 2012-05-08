package be.jeffreyvanmulem.brandstof.model;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;
import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "GasStation")
public class GasStation extends DomainObject {
    @Column(name = "Name")
    private String name;

    @Column(name = "Adres")
    private String adres;

    @Column(name = "Lattitude")
    private float lattitude;

    @Column(name = "Longitude")
    private float longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public float getLattitude() {
        return lattitude;
    }

    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
