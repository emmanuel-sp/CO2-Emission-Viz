package emmanuel.carbonemissions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double co2emissions;

    public Company() {

    }

    public Company(Long id, String name, Double co2emissions) {
        this.id = id;
        this.name = name;
        this.co2emissions = co2emissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCo2emissions() {
        return co2emissions;
    }

    public void setCo2emissions(Double co2emissions) {
        this.co2emissions = co2emissions;
    }
}
