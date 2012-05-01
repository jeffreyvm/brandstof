package be.jeffreyvanmulem.dao.impl;

import java.util.List;

import be.jeffreyvanmulem.dao.UserDao;
import be.jeffreyvanmulem.model.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

/**
 * @author rjansen
 * 
 */
public class UserDaoImpl extends GenericEntityDaoImpl<User> implements UserDao {

  /** The logging class. */
  private static final Log LOG = LogFactory.getLog(UserDaoImpl.class);

  /**
   * Constructor for UserDaoImpl.
   */
  public UserDaoImpl() {
    super(User.class);
  }

  /**
   * Will return the user based on the username
   * 
   * @param username
   *          the username
   * @return the user if found, else null
   */
  @SuppressWarnings("unchecked")
  public User get(String username) {
    LOG.debug("get user for username " + username);
    User foundUser = null;
    DetachedCriteria searchCriteria = DetachedCriteria.forClass(User.class);
    searchCriteria.add(Expression.eq("username", username));
    List<User> values = (List<User>) getHibernateTemplate().findByCriteria(
        searchCriteria);
    if (values != null && values.size() >= 1) {
      foundUser = values.get(0);
    }
    return foundUser;
  }
}
