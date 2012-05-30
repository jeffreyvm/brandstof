package be.jeffreyvanmulem.brandstof.model.abstr;

import com.eaio.uuid.UUID;
import org.hibernate.annotations.AccessType;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 5/05/12
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class DomainObject extends AbstractAuditable implements IEntity {

    @Version
    @Column(name = "Version")
    private Integer version;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @AccessType("property")
    private Long id;

    @Column(name = "UniqueIdentifier", unique = true, nullable = false, updatable = false, length = 36)
    private String uniqueIdentifier = new UUID().toString();

    public static String newUuid() {
        return new UUID().toString();
    }

    public DomainObject() {
        super();
    }

    public boolean isNew() {
        return getId() == null;
    }

    public boolean isPersisted(){
        return !isNew();
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return getClass().getName() + ":" + getId() + ":" + getVersion() + ":" + getUniqueIdentifier();
    }

    public boolean isEersteOpgeslagenVersie() {
        return (getVersion() == null) || getVersion() == 0;
    }
}
