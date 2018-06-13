package hello;


import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
/**
 * Diese klasse ist die GUI die alle benutzer anzeigt. Hier kann man sie auch bearbeiten und löschen.
 * dank path="/benutzer" kann man diese seite über --> localhost:8080/benutzer <-- erreichen
 */
@SpringUI(path="/benutzer")
public class BenutzerUI extends UI
{

    private final BenutzerRepository repo;

    private final BenutzerEditor editor;

    final Grid<Benutzer> grid;

    final TextField filter;

    private final Button addNewBtn;

    /**
     * Constructor.
     *
     * @param repo
     * @param editor
     */
    public BenutzerUI(BenutzerRepository repo, BenutzerEditor editor) {
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid<>(Benutzer.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New benutzer", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);

        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "email");

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listBenutzer(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editBenutzer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editBenutzer(new Benutzer(false, "", "", "",""))); //TODO// false muss von oben kommen

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listBenutzer(filter.getValue());
        });

        // Initialize listing
        listBenutzer(null);
    }

    // tag::listCustomers[]
    void listBenutzer(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repo.findAll());
        }
        else {
            grid.setItems(repo.findByEmailStartsWithIgnoreCase(filterText));
        }
    }
    // end::listCustomers[]

}
