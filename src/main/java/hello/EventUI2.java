package hello;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
public class EventUI2 extends UI {
	 private final EventRepository repo;
	    final Grid<Event> grid;

    @Override
    protected void init(VaadinRequest request) {
	    setContent(new Button("Click me", e -> Notification.show("Neues Event")));
	    
    }
    
    private void listEvents() {
    	grid.setItems(repo.findAll());
    }
}