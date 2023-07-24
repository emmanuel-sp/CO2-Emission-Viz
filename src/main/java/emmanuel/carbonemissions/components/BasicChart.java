package emmanuel.carbonemissions.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import emmanuel.carbonemissions.model.Company;
import emmanuel.carbonemissions.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

public class BasicChart extends HorizontalLayout {
    private final CompanyRepository companyRepository;
    public BasicChart(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }
    public List<Company> getAllCompanies(int year) {
        List<Company> temp = this.companyRepository.findAll();
        temp.removeIf((e) -> (e.getYear() != year));
        return temp;
    }
    public String[] getAllCompanyNames(List<Company> companies) {
        List<String> output = new ArrayList<>();
        for (Company company : companies) {
            output.add(company.getName());
        }
        return output.toArray(new String[0]);
    }
    public Double[] getAllCompanyEmissions(List<Company> companies) {
        List<Double> output = new ArrayList<>();
        for (Company company : companies) {
            output.add(company.getCo2emissions());
        }
        return output.toArray(new Double[0]);
    }
}
