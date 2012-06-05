package be.jeffreyvanmulem.brandstof;

import be.jeffreyvanmulem.brandstof.pages.UserPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Application object for your web application.
 *
 *  <p/>
 *      Created by IntelliJ IDEA.
 *      User: Jeffrey
 *      Date: 6/05/12
 *      Time: 22:56
 *      To change this template use File | Settings | File Templates.
 */
public class WicketApplication extends WebApplication {
    protected SpringComponentInjector getSpringInjector() {
        return new SpringComponentInjector(this);
    }

    @Override
    protected void init() {
        super.init();

        mountPage("user", UserPage.class);
        getComponentInstantiationListeners().add(getSpringInjector());

    }

    /* (non-Javadoc)
    * @see org.apache.wicket.Application#getHomePage()
    */
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

}