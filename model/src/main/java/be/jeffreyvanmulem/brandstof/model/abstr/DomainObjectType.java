package be.jeffreyvanmulem.brandstof.model.abstr;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class DomainObjectType extends DomainObject{
    @Column(name="Code", length = 10)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
