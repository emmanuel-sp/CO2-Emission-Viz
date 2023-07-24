package emmanuel.carbonemissions.components;

import com.storedobject.chart.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import emmanuel.carbonemissions.model.Company;
import emmanuel.carbonemissions.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CompanyChart extends BasicChart {

    public CompanyChart(CompanyRepository companyRepository, String filter, String type, int yr) {
        super(companyRepository);
        // Chart Area
        SOChart soChart = new SOChart();
        soChart.setSize("1080px", "530px");

        List<Company> newComps = getAllCompanies(yr);
        newComps.removeIf((e) -> {
            if (type.equals("All")) {
                return false;
            }
            if (filter.equals("Sector")) {
                return !e.getSector().equals(type);
            }
            return false;
        });

        //Data
        CategoryData labels = new CategoryData(getAllCompanyNames(newComps));
        Data data = new Data(getAllCompanyEmissions(newComps));

        // Axes
        XAxis xAxis;
        YAxis yAxis;

        // Creating barchart
        BarChart bc = new BarChart(labels, data);
        xAxis = new XAxis(labels);
        xAxis.getLabel(true).setRotation(45);
        yAxis = new YAxis(data);
        RectangularCoordinate coordinate = new RectangularCoordinate(xAxis, yAxis);
        bc.plotOn(coordinate); // Bar chart needs to be plotted on a coordinate system

        soChart.disableDefaultLegend();

        Toolbox toolbox = new Toolbox();
        toolbox.addButton(new Toolbox.Download(), new Toolbox.Zoom());

        Title title = new Title("Bar Chart: Company Name");
        //title.setSubtext("C");
        soChart.add(bc, toolbox, title);

        add(new HorizontalLayout(soChart));
    } // Constructor
} // ChartTest