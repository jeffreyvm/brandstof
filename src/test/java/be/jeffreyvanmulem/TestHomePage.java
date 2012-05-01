package be.jeffreyvanmulem;

import junit.framework.TestCase;
import be.jeffreyvanmulem.web.WicketApplication;
import be.jeffreyvanmulem.web.examples.first.FirstHomePage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.util.tester.WicketTester;

/**
 * Simple test using the WicketTester
 * 
 * @author rjansen
 */
public class TestHomePage extends TestCase {
  private WicketTester tester;

  @Override
  public void setUp() {
    tester = new WicketTester(new WicketApplication());
  }

  public void testRenderMyPage() {
    // start and render the test page
    tester.startPage(FirstHomePage.class);

    // assert rendered page class
    tester.assertRenderedPage(FirstHomePage.class);

    tester.assertComponent("header", Label.class);
  }
}
