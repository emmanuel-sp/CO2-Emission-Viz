package emmanuel.carbonemissions.window;

import com.storedobject.chart.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import emmanuel.carbonemissions.components.CompanyChart;
import emmanuel.carbonemissions.datatypes.Sector;
import emmanuel.carbonemissions.model.Company;
import emmanuel.carbonemissions.repository.CompanyRepository;

@Route("")
public class MainView extends VerticalLayout {

    public MainView(CompanyRepository companyRepository) {
        CompanyChart starterChart = new CompanyChart(companyRepository, "", "");
        Select<String> select = new Select<>();
        select.setLabel("Filter by Sector");
        select.setItems("Technology", "Financials", "Healthcare", "Utilities", "Energy",
                "Materials", "Transport", "Industrials", "Consumer Discretionary", "Consumer Staple");
        select.setPlaceholder("Select sector");
        select.addValueChangeListener((e) -> {
            CompanyChart ct = new CompanyChart(companyRepository,"Sector" ,select.getValue());
            replace(getComponentAt(1),ct);

        });
        add(
                new H1("Company CO2 Emission Visualizer"),
                starterChart, select
        );
    } // Constructor


} // Class

