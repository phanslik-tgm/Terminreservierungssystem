package hello;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
/**
 * Die EventUI Klasse erzeugt die GUI in der man ein neues Event erstellen kann.
 * Sie wurde nur zum Testen erstellt.
 * man erreicht diese seite mit: localhost:8080/event2
 */
@SpringUI(path="/event2")
public class EventUI2 extends UI{

	 //private final EventRepository repo;

	 //final Grid<Event> grid;

    /**
     * Constructor
     */
    public EventUI2() {
    }

    /**
     * init methode
     * @param request
     */
    @Override
    protected void init(VaadinRequest request) {
	    setContent(new Button("Click me", e -> Notification.show("Neues Event")));
	    
    }

    /**
     * Diese methode gibt alle events in das Grid
     */
    private void listEvents() {
    	//grid.setItems(repo.findAll());
    }
}