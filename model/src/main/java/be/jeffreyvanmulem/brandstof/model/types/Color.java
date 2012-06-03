package be.jeffreyvanmulem.brandstof.model.types;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Color")
public class Color extends DomainObjectType {
    @Column(name = "HexCode")
    private String hexCode;

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }
}
