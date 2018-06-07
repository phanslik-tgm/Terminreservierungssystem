package hello;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import com.vaadin.shared.ui.datefield.DateTimeResolution;

@SpringUI(path="/event")
public class event extends UI {

    private Label startdatelabel = new Label("Wählen Sie das Startdatum aus :");
    private Label enddatelabel = new Label("Wählen Sie das Enddatum aus :");
    private Label beschreibunglabel = new Label("Beschreiben Sie Ihr Event :");
    private TextField event_name = new TextField("Wie soll das Event heißen :");
    private TextArea beschreibung = new TextArea();


    private Button Home = new Button("Startseite");
    private Button Create_Event = new Button("Create Event");

    @Override
    protected void init(VaadinRequest request) {


            GridLayout grid = new GridLayout(1000,1000);
            grid.setWidth("100%");
            grid.setHeight("100%");

        VerticalLayout layout = new VerticalLayout();
        grid.addComponent(layout,330,170);

        Home.setIcon(VaadinIcons.HOME);
        grid.addComponent(Home,100,30);

        layout.addComponent(startdatelabel);

        DateTimeField startdate = new DateTimeField();
        startdate.setValue(LocalDateTime.now());
        startdate.setLocale(Locale.GERMANY);
        startdate.setResolution(DateTimeResolution.MINUTE);

        layout.addComponent(startdate);

        layout.addComponent(enddatelabel);
        DateTimeField enddate = new DateTimeField();
        enddate.setValue(LocalDateTime.now());
        enddate.setLocale(Locale.GERMANY);
        enddate.setResolution(DateTimeResolution.MINUTE);

        layout.addComponent(enddate);

        layout.addComponent(event_name);
        layout.addComponent(beschreibunglabel);
        layout.addComponent(beschreibung);
        Create_Event.setIcon(VaadinIcons.PLUS);
        layout.addComponent(Create_Event);



        setContent(grid);




    }

}

