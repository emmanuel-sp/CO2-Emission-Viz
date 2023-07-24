package emmanuel.carbonemissions.window;

import com.storedobject.chart.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import emmanuel.carbonemissions.components.CompanyChart;
import emmanuel.carbonemissions.model.Company;
import emmanuel.carbonemissions.repository.CompanyRepository;
import com.vaadin.flow.component.dialog.Dialog;

@Route("")
public class MainView extends VerticalLayout {

    Select<Integer> yearSelect = new Select<>();
    Select<String> sectorSelect = new Select<>();
    TextField enterName = new TextField("Company Name");
    NumberField enterCO2 = new NumberField("Carbon Emissions in MtCO2e");
    Select<String> enterSector = new Select<>();
    Select<Integer> enterYear = new Select<>();

    public MainView(CompanyRepository companyRepository) {
        setAlignItems(Alignment.CENTER);
        setSpacing(false);
        setJustifyContentMode(JustifyContentMode.EVENLY);
        CompanyChart starterChart = new CompanyChart(companyRepository, "", "", 2022);

        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Add Company Data");
        VerticalLayout dialogLayout = createDialogLayout();
        dialog.add(dialogLayout);
        Button saveButton = new Button("Save", e -> {
            dialog.close();
            companyRepository.save(new Company(companyRepository.count() + 1,
                    enterName.getValue(),
                    enterCO2.getValue(),
                    enterSector.getValue(),
                    enterYear.getValue()
                    )
            );


        });
        Button cancelButton = new Button("Cancel", e -> dialog.close());
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);
        Button button = new Button("Add Company Data", e -> dialog.open());
        add(dialog, button);

        // Sector Selection
        sectorSelect.setLabel("Filter by Sector:");
        sectorSelect.setItems("All", "Technology", "Financials", "Healthcare", "Utilities", "Energy",
                "Materials", "Transport", "Industrials", "Consumer Discretionary", "Consumer Staple");
        sectorSelect.setValue("All");
        sectorSelect.setPlaceholder("All");
        sectorSelect.addValueChangeListener((e) -> {
            CompanyChart ct = new CompanyChart(companyRepository,"Sector", e.getValue(), yearSelect.getValue());
            replace(getComponentAt(3),ct);
        });

        //Year Selection
        yearSelect.setLabel("Year:");
        yearSelect.setItems(2019, 2020, 2021, 2022);
        yearSelect.setValue(2022);
        yearSelect.addValueChangeListener((e) -> {
            CompanyChart ct = new CompanyChart(companyRepository,"Sector", sectorSelect.getValue(), e.getValue()); //Add a bool variable when you add more filtering
            replace(getComponentAt(3),ct);
        });

        //Add components
        add(
                new H1("Company CO2 Emission Visualizer"),
                starterChart, new HorizontalLayout(yearSelect, sectorSelect)
        );
    } // Constructor

    private VerticalLayout createDialogLayout() {
            enterSector.setLabel("Sector");
            enterSector.setItems("Technology", "Financials", "Healthcare", "Utilities", "Energy",
                "Materials", "Transport", "Industrials", "Consumer Discretionary", "Consumer Staple");
            enterSector.setPlaceholder("");
            enterYear.setLabel("Year");
            enterYear.setItems(2019,2020,2021,2022);
            enterYear.setPlaceholder("");
            VerticalLayout dialogLayout = new VerticalLayout(this.enterName, this.enterCO2, enterSector, enterYear);
            dialogLayout.setPadding(false);
            dialogLayout.setSpacing(false);
            dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
            dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

            return dialogLayout;
    }
} // Class

