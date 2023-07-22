package emmanuel.carbonemissions.window;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        VerticalLayout todolist = new VerticalLayout();
        TextField items = new TextField();
        Button but = new Button("Add");
        Button remover = new Button("Clear");

        but.addClickListener((e) -> {
            Checkbox item = new Checkbox(items.getValue());
            item.addClickListener((k) -> item.removeFromParent());
            todolist.add(item);
        });
        remover.addClickListener((e) ->
                todolist.removeAll()
        );
        add(
                new H1("Vaadin Todo"),
                todolist,
                new HorizontalLayout(items, but),
                remover
        );
    }
}

