package be.jeffreyvanmulem.brandstof;

import be.jeffreyvanmulem.brandstof.pages.UserPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends WebPage{
    public HomePage(final PageParameters parameters) {
        add(new BookmarkablePageLink<Void>("user", UserPage.class));
    }
}
