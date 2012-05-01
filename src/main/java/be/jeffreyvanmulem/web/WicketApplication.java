package be.jeffreyvanmulem.web;

import be.jeffreyvanmulem.web.examples.first.FirstWicketApplication;

/**
 * Application object for your web application.
 * 
 * We will use this (empty) class to extend from different implementations in
 * the examples. This way we don't have to change the Spring configuation if we want to use
 * another example.
 */
public class WicketApplication extends FirstWicketApplication {
 
  /* Attention. In case of example fourth and fifth you'll need to uncomment the parameter
   * for the usermanager in the Spring configuration for this WicketApplication bean.
   * You can do this on line 10 of the applicationContext.xml
  */
}
