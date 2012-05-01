package be.jeffreyvanmulem.manager.impl;

import java.util.Collection;

import be.jeffreyvanmulem.dao.UserDao;
import be.jeffreyvanmulem.dao.UserRoleDao;
import be.jeffreyvanmulem.manager.UserManager;
import be.jeffreyvanmulem.model.User;
import be.jeffreyvanmulem.model.UserRole;

/**
 * Implementation of Manager to handle User data.
 * 
 * @author rjansen
 */
public class UserManagerImpl extends GenericEntityManagerImpl<User> implements
    UserManager {

  private UserDao userDao;

  private UserRoleDao userRoleDao;

  /**
   * Set the dao
   * 
   * @param userDao
   *          the user dao to set
   */
  public void setUserDao(UserDao userDao) {
    super.setEntityDao(userDao);
    this.userDao = userDao;
  }

  /**
   * Set the dao
   * 
   * @param userDao
   *          the user dao to set
   */
  public void setUserRoleDao(UserRoleDao userRoleDao) {
    this.userRoleDao = userRoleDao;
  }

  /**
   * Will return the user based on the username
   * 
   * @param username
   *          the username
   * @return the user information if available
   */
  public User get(String username) {
    return userDao.get(username);
  }

  /**
   * Get all user roles
   * 
   * @return the user roles
   */
  public Collection<UserRole> getAllRoles() {
    return userRoleDao.getAll();
  }
}
