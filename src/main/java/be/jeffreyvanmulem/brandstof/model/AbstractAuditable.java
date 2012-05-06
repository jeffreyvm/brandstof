package be.jeffreyvanmulem.brandstof.model;

import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 5/05/12
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class AbstractAuditable implements Serializable {

    @Column(name="CreationUser", length= 30, updatable = false)
    private String creationUser;

    @Column(name="CreationDate",updatable = false)
    private LocalDate creationDate;

    @Column(name="ModificationUser", length= 30)
    private String modificationUser;

    @Column(name="ModificationDate")
    private LocalDate modificationDate;

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
