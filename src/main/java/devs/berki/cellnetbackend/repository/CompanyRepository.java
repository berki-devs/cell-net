package devs.berki.cellnetbackend.repository;

import devs.berki.cellnetbackend.model.Company;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	void deleteById(@NonNull Long id);

	boolean existsById(@NonNull Long id);
	
	List<Company> findByCompanyNameContainsIgnoreCase(String companyName);
}