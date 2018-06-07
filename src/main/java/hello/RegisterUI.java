package hello;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.util.StringUtils;

@SpringUI(path="/register")
public class RegisterUI extends UI
{

    private final BenutzerRepository repo;

    private final BenutzerEditor editor;
    //private final BenutzerLogin login;

    //final Grid<Benutzer> grid;

    //final TextField filter;

    private final Button registerBtn, loginBtn;

    public RegisterUI(BenutzerRepository repo, BenutzerEditor editor) {
        this.repo = repo;
        this.editor = editor;
        //this.grid = new Grid<>(Benutzer.class);
        //this.filter = new TextField();
        this.registerBtn = new Button("Register", FontAwesome.PLUS);
        this.loginBtn = new Button("Login", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout( registerBtn,loginBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, editor);
        setContent(mainLayout);

        //grid.setHeight(300, Unit.PIXELS);
        //grid.setColumns("id", "email");

        //filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        //filter.setValueChangeMode(ValueChangeMode.LAZY);
        //filter.addValueChangeListener(e -> listBenutzer(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        //grid.asSingleSelect().addValueChangeListener(e -> {
         //   editor.editBenutzer(e.getValue());
        //});

        // Instantiate and edit new Customer the new button is clicked
        registerBtn.addClickListener(e -> editor.editBenutzer(new Benutzer(false, "", "", "",""))); //TODO// false muss von oben kommen
        //loginBtn.addClickListener(e -> login.loginBenutzer();

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            //listBenutzer(filter.getValue());
        });

        // Initialize listing
        listBenutzer(null);
    }

    // tag::listCustomers[]
    void listBenutzer(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            //grid.setItems(repo.findAll());
        }
        else {
            //grid.setItems(repo.findByEmailStartsWithIgnoreCase(filterText));
        }
    }
    // end::listCustomers[]

}
