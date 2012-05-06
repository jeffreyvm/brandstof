package be.jeffreyvanmulem.brandstof;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */

import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.model.User;

public class DataInitialiser {

    private static String[] dummySurNames = {"Heather", "Candice", "Angelina", "Megan"};
    private static String[] dummyNames = {"Huntington", "Swaenepoel", "Jolie", "Fox"};

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    public void dataInit()
    {
        for(int i = 0; i < 10; i++)
        {
            User user = new User();
            StringBuilder bldr = new StringBuilder();
            bldr.append(dummySurNames[(int)(Math.random() * dummySurNames.length)]);
            bldr.append(" ");
            bldr.append(dummyNames[(int)(Math.random() * dummyNames.length)]);
            user.setUsername(bldr.toString());
            userDao.save(user);
        }
    }

}
