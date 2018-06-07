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

@SpringComponent
@UIScope
public class BenutzerLogin extends VerticalLayout
{
    private final BenutzerRepository repository;
    private Benutzer benutzer;


    /* Fields to edit properties in Customer entity */
    TextField email = new TextField("Email");
    TextField password = new TextField("Password");


    /* Action buttons */
    Button save = new Button("Login", VaadinIcons.CHECK);
    //Button cancel = new Button("Cancel");
    //Button delete = new Button("Delete", VaadinIcons.TRASH);
    CssLayout actions = new CssLayout(save);

    Binder<Benutzer> binder = new Binder<>(Benutzer.class);

    @Autowired
    public BenutzerLogin(BenutzerRepository repository)
    {
        this.repository = repository;



        addComponents(email, password, actions);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

    // wire action buttons to save, delete and reset
        save.addClickListener(e -> checkLoginBenutzer(benutzer));
        //delete.addClickListener(e -> repository.delete(benutzer));
        //cancel.addClickListener(e -> editBenutzer(benutzer));
        setVisible(false);
}

public interface ChangeHandler {

    void onChange();
}

    public final void loginBenutzer()
    {


        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(benutzer);

        setVisible(true);

        // A hack to ensure the whole form is visible
        save.focus();
        // Select all text in firstName field automatically
        //firstName.selectAll();
    }

    public  void checkLoginBenutzer(Benutzer b)
    {
        boolean bool;
        boolean bool2;

        //for (Benutzer l : repository.findByEmailStartsWithIgnoreCase(b.getEmail()))
        //{
        //   bool = true;
        //}

        for (Benutzer l : repository.checkEmailAndPassword(b.getEmail(),b.getPassword()))
        {
            bool = true;
        }



        if(bool=true)
        {
            System.out.println("stimmt");
        }
    }

    public void setChangeHandler(BenutzerEditor.ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        save.addClickListener(e -> h.onChange());
        //delete.addClickListener(e -> h.onChange());
    }
}
