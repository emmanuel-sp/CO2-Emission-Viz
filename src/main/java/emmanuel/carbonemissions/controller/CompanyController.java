package emmanuel.carbonemissions.controller;

import emmanuel.carbonemissions.model.Company;
import emmanuel.carbonemissions.repository.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();

    }

}
