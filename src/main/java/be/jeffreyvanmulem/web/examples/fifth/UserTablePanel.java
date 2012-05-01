package be.jeffreyvanmulem.web.examples.fifth;

import java.util.ArrayList;
import java.util.List;

import be.jeffreyvanmulem.manager.GenericEntityManager;
import be.jeffreyvanmulem.model.User;
import be.jeffreyvanmulem.web.WicketApplication;
import be.jeffreyvanmulem.web.component.datatable.DatePropertyColumn;
import be.jeffreyvanmulem.web.dataprovider.ParentModelDataProvider;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

@SuppressWarnings("serial")
public class UserTablePanel extends Panel {

  public UserTablePanel(String id) {
    super(id);

    ParentModelDataProvider<User> dataProvider = new ParentModelDataProvider<User>() {
      @Override
      protected GenericEntityManager<User> getManager() {
        return ((FifthWicketApplication) WicketApplication.get())
        .getUserManager();
      }
    };
    
    AjaxFallbackDefaultDataTable<User> dataTable = new AjaxFallbackDefaultDataTable<User>(
        "datatable", getColumns(), dataProvider, 5);
    add(dataTable);
  }

  private List<IColumn<User>> getColumns() {
    List<IColumn<User>> result = new ArrayList<IColumn<User>>();
    result.add(new PropertyColumn<User>(new Model<String>("Username"),
        "username", "username"));
    result.add(new PropertyColumn<User>(new Model<String>("Password"),
        "password", "password"));
    result.add(new PropertyColumn<User>(new Model<String>("Description"),
        "description", "description"));
    result.add(new DatePropertyColumn<User>(new Model<String>("Date of birth"),
        "dateOfBirth", "dateOfBirth"));
    return result;
  }

}
