package hello;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.*;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.boot.VaadinAutoConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BenutzerUITest.Config.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BenutzerUITest{

    @Autowired BenutzerRepository repository;

    VaadinRequest vaadinRequest = Mockito.mock(VaadinRequest.class);

    BenutzerEditor editor;

    BenutzerUI benutzerUI;

    @Before
    public void setup() {
        this.editor = new BenutzerEditor(this.repository);
        this.benutzerUI = new BenutzerUI(this.repository, editor);
    }

    @Test
    public void shouldInitializeTheGridWithBenutzerRepositoryData() {
        int benutzerCount = (int) this.repository.count();

        benutzerUI.init(this.vaadinRequest);

        then(benutzerUI.grid.getColumns()).hasSize(3);
        then(getBenutzerInGrid()).hasSize(benutzerCount);
    }

    private List<Benutzer> getBenutzerInGrid() {
        ListDataProvider<Benutzer> ldp = (ListDataProvider) benutzerUI.grid.getDataProvider();
        return new ArrayList<>(ldp.getItems());
    }

    //@Test
    //public void shouldFillOutTheGridWithNewData() {
    //    int initialBenutzerCount = (int) this.repository.count();
    //    this.benutzerUI.init(this.vaadinRequest);
    //    //benutzerDataWasFilled(editor,false, "Marcin", "Grzejszczak","","");

    //    this.editor.save.click();

     //   then(getBenutzerInGrid()).hasSize(initialBenutzerCount + 1);

     //   then(getBenutzerInGrid().get(getBenutzerInGrid().size() - 1))
     //           .extracting("firstName", "lastName")
     //           .containsExactly("Marcin", "Grzejszczak");

    //}

    @Test
    public void shouldFilterOutTheGridWithTheProvidedLastName() {
        this.benutzerUI.init(this.vaadinRequest);
        this.repository.save(new Benutzer(false,"Josh", "Long","",""));

        benutzerUI.listBenutzer("Long");

        then(getBenutzerInGrid()).hasSize(1);
        then(getBenutzerInGrid().get(getBenutzerInGrid().size() - 1))
                .extracting("firstName", "lastName")
                .containsExactly("Josh", "Long");
    }

    @Test
    public void shouldInitializeWithInvisibleEditor()
    {
        this.benutzerUI.init(this.vaadinRequest);

        then(this.editor.isVisible()).isFalse();
    }

    @Test
    public void shouldMakeEditorVisible() {
        this.benutzerUI.init(this.vaadinRequest);
        Benutzer first = getBenutzerInGrid().get(0);
        this.benutzerUI.grid.select(first);

        then(this.editor.isVisible()).isTrue();
    }

    //private void BenutzerDataWasFilled(BenutzerEditor editor, String firstName,
     //                                  String lastName) {
     //   this.editor.firstName.setValue(firstName);
     //   this.editor.lastName.setValue(lastName);
     //   editor.editBenutzer(new Benutzer(false,firstName, lastName,"",""));
    //}

    @Configuration
    @EnableAutoConfiguration(exclude = VaadinAutoConfiguration.class)
    static class Config {

        @Autowired
        BenutzerRepository repository;

        @PostConstruct
        public void initializeData() {
            this.repository.save(new Benutzer(false, "Jack", "Bauer","",""));
            this.repository.save(new Benutzer(false, "Chloe", "O'Brian","",""));
            this.repository.save(new Benutzer(false, "Kim", "Bauer","",""));
            this.repository.save(new Benutzer(false, "David", "Palmer","",""));
            this.repository.save(new Benutzer(false, "Michelle", "Dessler","",""));
        }
    }
}
