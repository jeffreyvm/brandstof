package be.jeffreyvanmulem.web.examples.fourth;

import java.util.Locale;

import be.jeffreyvanmulem.manager.UserManager;
import be.jeffreyvanmulem.web.examples.first.FirstHomePage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * 
 */
public class FourthWicketApplication extends WebApplication {

  private UserManager userManager;

  /**
   * Constructor
   */
  public FourthWicketApplication() {
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
    return FourthHomePage.class;
  }

  /**
   * Initializes the bookmarkable pages
   */
  protected void initializeBookmarks() {
    this.mountPage("/first", FirstHomePage.class);
  }

  public UserManager getUserManager() {
    return userManager;
  }

  public void setUserManager(UserManager userManager) {
    this.userManager = userManager;
  }

}
