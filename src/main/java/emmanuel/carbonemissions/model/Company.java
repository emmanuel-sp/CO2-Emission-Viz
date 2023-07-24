package emmanuel.carbonemissions.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double co2emissions;

    private String sector;

    private int year;
    public Company() {

    }

    public Company(Long id, String name, Double co2emissions, String sector, int year) {
        this.id = id;
        this.name = name;
        this.co2emissions = co2emissions;
        this.sector = sector;
        this.year = year;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
