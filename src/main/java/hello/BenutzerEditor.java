package hello;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in VaadinUI.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX. See e.g. AbstractForm in Viritin
 * (https://vaadin.com/addon/viritin).
 */
@SpringComponent
@UIScope
public class BenutzerEditor extends VerticalLayout {

    private final BenutzerRepository repository;

    /**
     * The currently edited customer
     */
    private Benutzer benutzer;

    /* Fields to edit properties in Customer entity */
    TextField email = new TextField("Email");
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    TextField password = new TextField("Password");


    /* Action buttons */
    Button save = new Button("Save", VaadinIcons.CHECK);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcons.TRASH);
    CssLayout actions = new CssLayout(save, cancel, delete);

    Binder<Benutzer> binder = new Binder<>(Benutzer.class);

    @Autowired
    public BenutzerEditor(BenutzerRepository repository) {
        this.repository = repository;

        addComponents(firstName, lastName, email, password, actions);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> repository.save(benutzer));
        delete.addClickListener(e -> repository.delete(benutzer));
        cancel.addClickListener(e -> editBenutzer(benutzer));
        setVisible(false);
    }

    public interface ChangeHandler {

        void onChange();
    }

    public final void editBenutzer(Benutzer b) {
        if (b == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = b.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            benutzer = repository.findById(b.getId()).get();
        } else {
            benutzer = b;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(benutzer);

        setVisible(true);

        // A hack to ensure the whole form is visible
        save.focus();
        // Select all text in firstName field automatically
        firstName.selectAll();
    }

    public  void checkLoginBenutzer(Benutzer b)
    {
        boolean bool;
        boolean bool2;

        //for (Benutzer l : repository.findByEmailStartsWithIgnoreCase(b.getEmail()))
        //{
         //   bool = true;
        //}

        //for (Benutzer l : repository.checkEmailAndPassword(b.getEmail(),b.getPassword()))
        //{
        //    bool = true;
        //}



        //if(bool=true)
        //{
        //    System.out.println("stimmt");
        //}
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }
}