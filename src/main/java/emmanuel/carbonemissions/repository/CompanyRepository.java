package emmanuel.carbonemissions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import emmanuel.carbonemissions.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
