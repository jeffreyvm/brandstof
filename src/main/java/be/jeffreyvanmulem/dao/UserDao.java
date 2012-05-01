package be.jeffreyvanmulem.dao;

import be.jeffreyvanmulem.model.User;

/**
 * @author rjansen
 * 
 */
public interface UserDao extends GenericEntityDao<User> {

  /**
   * Will return the user based on the username
   * 
   * @param username
   *          the username
   * @return the user if found, else null
   */
  User get(String username);

}
