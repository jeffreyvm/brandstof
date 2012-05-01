package be.jeffreyvanmulem.web.examples.fifth;

import be.jeffreyvanmulem.manager.GenericEntityManager;
import be.jeffreyvanmulem.model.User;
import be.jeffreyvanmulem.web.WicketApplication;
import be.jeffreyvanmulem.web.dataprovider.ParentModelDataProvider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;

@SuppressWarnings("serial")
public class SidebarLoremPanel extends Panel {

  /** the logger */
  private static final Log LOG = LogFactory.getLog(SidebarLoremPanel.class);

  public SidebarLoremPanel(String id) {
    super(id);
    ParentModelDataProvider<User> dataProvider = new ParentModelDataProvider<User>() {

      @Override
      protected GenericEntityManager<User> getManager() {
        return ((FifthWicketApplication) WicketApplication.get())
            .getUserManager();
      }
    };

    DataView<User> dataview = new DataView<User>("dataview", dataProvider) {

      @Override
      protected void populateItem(Item<User> item) {
        LOG.debug("Create item for user "
            + item.getDefaultModelObjectAsString());
        item.add(new Label("username", item.getModelObject().getUsername()));
      }
    };
    add(dataview);
  }
}
