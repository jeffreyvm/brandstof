package be.jeffreyvanmulem.web.examples.third;

import java.util.Locale;

import be.jeffreyvanmulem.web.examples.first.FirstHomePage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * 
 */
public class ThirdWicketApplication extends WebApplication {

  /**
   * Constructor
   */
  public ThirdWicketApplication() {
  }

  /**
   * Init the application
   */
  @Override
  protected void init() {
    super.init();

    // Define locale to be used when locale can not be determined.
    Locale.setDefault(Locale.ENGLISH);

    initializeBookmarks();
  }

  /**
   * @see org.apache.wicket.Application#getHomePage()
   */
  public Class<? extends Page> getHomePage() {
    return ThirdHomePage.class;
  }

  /**
   * Initializes the bookmarkable pages
   */
  protected void initializeBookmarks() {
    this.mountPage("/first", FirstHomePage.class);
  }

}
