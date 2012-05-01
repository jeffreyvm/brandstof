package be.jeffreyvanmulem.dao.impl;

import be.jeffreyvanmulem.dao.UserRoleDao;
import be.jeffreyvanmulem.model.UserRole;

public class UserRoleDaoImpl extends GenericEntityDaoImpl<UserRole> implements
    UserRoleDao {

  protected UserRoleDaoImpl() {
    super(UserRole.class);
  }

}
