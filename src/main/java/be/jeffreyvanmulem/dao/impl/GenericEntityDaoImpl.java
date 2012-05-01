package be.jeffreyvanmulem.dao.impl;

import java.util.Collection;
import java.util.List;

import be.jeffreyvanmulem.dao.GenericEntityDao;
import be.jeffreyvanmulem.model.ParentModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Abstract base class for a DAO
 * 
 * @author rjansen
 */
public abstract class GenericEntityDaoImpl<T extends ParentModel> extends
    HibernateDaoSupport implements GenericEntityDao<T> {

  /** the logger */
  private static final Log LOG = LogFactory.getLog(GenericEntityDaoImpl.class);

  /**
   * The class of the entity of this DAO.
   */
  private Class<T> entityClass;

  /**
   * Construct this DAO for the supplied model class.
   * 
   * @param entityClass
   *          The model class that is persisted.
   */
  protected GenericEntityDaoImpl(final Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  @SuppressWarnings("unchecked")
  public Collection<T> getAll() {
    LOG.debug("Get all" + entityClass.getSimpleName());
    Collection<T> values = (List<T>) getHibernateTemplate().findByCriteria(
        DetachedCriteria.forClass(entityClass));
    return values;
  }

  @SuppressWarnings("unchecked")
  public T get(Long id) {
    LOG.debug("Get all" + entityClass.getSimpleName() + " with id " + id);
    return (T) getHibernateTemplate().get(entityClass, id.longValue());
  }

  public void save(T item) {
    LOG.debug("save new item");
    item.prePersist();
    getHibernateTemplate().save(item);
  }

  public void update(T item) {
    LOG.debug("update item");
    item.prePersist();
    getHibernateTemplate().merge(item);
  }

  public void delete(T item) {
    LOG.debug("update item");
    getHibernateTemplate().delete(item);
  }

  /**
   * {@inheritDoc}
   */
  public void evictFromHibernate(T item) {
    getHibernateTemplate().flush();
    getHibernateTemplate().evict(item);
  }

}
