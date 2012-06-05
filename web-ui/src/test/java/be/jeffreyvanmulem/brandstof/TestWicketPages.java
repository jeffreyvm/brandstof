package be.jeffreyvanmulem.brandstof;

import be.jeffreyvanmulem.brandstof.HomePage;
import be.jeffreyvanmulem.brandstof.WicketApplication;
import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.pages.UserPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class TestWicketPages {

    protected WicketTester tester;

    @Before
    public void setup()
    {
        final ApplicationContextMock acm = new ApplicationContextMock();

        UserDao userDao = Mockito.mock(UserDao.class);

        acm.putBean("userDao", userDao);

        tester = new WicketTester(new WicketApplication(){
            @Override
            protected SpringComponentInjector getSpringInjector() {
                return  new SpringComponentInjector(this, acm, true);
            }
        });
    }

    @Test
    public void testStartPage()
    {
        tester.startPage(HomePage.class);
    }

    @Test
    public void testEventPage()
    {
        tester.startPage(UserPage.class);
    }
}
