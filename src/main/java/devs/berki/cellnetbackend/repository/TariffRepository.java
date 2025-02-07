package devs.berki.cellnetbackend.repository;

import devs.berki.cellnetbackend.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {
	List<Tariff> findAllByCompanyId(Long companyId);

	boolean existsByCompanyId(Long companyId);
}