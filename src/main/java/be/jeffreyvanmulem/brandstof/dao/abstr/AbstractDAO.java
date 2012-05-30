package be.jeffreyvanmulem.brandstof.dao.abstr;

import be.jeffreyvanmulem.brandstof.dao.interfaces.abstr.IDAO;
import be.jeffreyvanmulem.brandstof.model.abstr.DomainObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 30/05/12
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDAO<EntityClass extends DomainObject> implements IDAO<EntityClass> {

    private static Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

    public List<EntityClass> findAll() {
        Query query = getFindAllQuery();
        return query.getResultList();
    }

    protected Query getFindAllQuery() {
        return getEntityManager().createQuery(getBaseQueryBuilder().toString());
    }

    private StringBuilder getBaseQueryBuilder() {
        StringBuilder queryBuilder = new StringBuilder("select entity from ");
        queryBuilder.append(getClazz().getName());
        queryBuilder.append(" entity");
        return queryBuilder;
    }

    public EntityClass findById(Long id) {
        return getEntityManager().find(getClazz(), id);
    }

    public EntityClass findByProperty(String propertyName, Object propertyValue) {

        if (propertyName == null || propertyValue == null) {
            throw new IllegalArgumentException("Property name and value cannot be null! Values: propertyName" + propertyName + ", propertyValue = " + propertyValue);
        }

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EntityClass> findEntityQuery = cb.createQuery(getClazz());
        Root<EntityClass> entity = findEntityQuery.from(getClazz());

        Predicate propertyPredicate = cb.equal(entity.get(propertyName), propertyValue);

        findEntityQuery.where(propertyPredicate);

        TypedQuery<EntityClass> query = getEntityManager().createQuery(findEntityQuery);
        List<EntityClass> entities = query.setMaxResults(1).getResultList();

        if (entities.isEmpty()) {
            return null;
        } else {
            return entities.get(0);
        }

    }

    public void persist(EntityClass entity) {
        getEntityManager().persist(entity);
    }

    public void remove(EntityClass entity) {
        getEntityManager().remove(entity);
    }

    public void removeSafely(EntityClass entity) {
        getEntityManager().remove(
                getEntityManager().getReference(getClazz(), entity.getId()));
    }

    public EntityClass getReference(EntityClass entity) {

        if (entity.isNew()) {
            return entity;
        } else {
            return getEntityManager().getReference(getClazz(), entity.getId());
        }
    }

    public long size() {
        StringBuilder query = new StringBuilder("select count(entity) from ");
        query.append(getClazz().getName());
        query.append(" entity");

        Long result = (Long) getEntityManager().createQuery(query.toString())
                .getSingleResult();
        return result.longValue();
    }

    public EntityClass merge(EntityClass entity) {
        return getEntityManager().merge(entity);
    }
}
