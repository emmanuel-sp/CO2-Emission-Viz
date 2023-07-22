package emmanuel.carbonemissions.window;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import emmanuel.carbonemissions.controller.CompanyController;
import emmanuel.carbonemissions.model.Company;
import emmanuel.carbonemissions.repository.CompanyRepository;

@Route("")
public class MainView extends VerticalLayout {

    private final CompanyRepository companyRepository;
    static long count = 1L;

    public MainView(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
        VerticalLayout todolist = new VerticalLayout();
        TextField items = new TextField();
        Button but = new Button("Add");
        Button remover = new Button("Clear");


        but.addClickListener((e) -> {
            Checkbox item = new Checkbox(items.getValue());
            Company comp = new Company(count++, items.getValue(), 1.02, "Testor");
            item.addClickListener((k) -> {
                item.removeFromParent();
                companyRepository.deleteById(comp.getId());
            });
            todolist.add(item);
            companyRepository.save(comp);
        });
        remover.addClickListener((e) ->
                todolist.removeAll()
        );
        add(
                new H1("Vaadin Todo"),
                todolist,
                new HorizontalLayout(items, but),
                remover
                //new Chart(ChartType.BUBBLE)
        );
    }
}

