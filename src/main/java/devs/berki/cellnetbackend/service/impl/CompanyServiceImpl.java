package devs.berki.cellnetbackend.service.impl;

import devs.berki.cellnetbackend.model.Company;
import devs.berki.cellnetbackend.repository.CompanyRepository;
import devs.berki.cellnetbackend.repository.TariffRepository;
import devs.berki.cellnetbackend.service.CompanyService;
import devs.berki.cellnetbackend.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CompanyServiceImpl implements CompanyService {
	private final CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public void addCompany(Company company) {
		companyRepository.save(company);
	}

	@Override
	public Company updateCompany(String name, Long id) {
		if (companyRepository.existsById(id)) {
			Company company = companyRepository.findById(id).orElse(null);
			if (company != null) {
				company.setCompanyName(name);
				return companyRepository.save(company);
			}
		}
		return null;
	}

	@Override
	public void removeCompany(Long id) {
		companyRepository.deleteById(id);
	}

	@Override
	public List<Company> findByName(String name) {
		return companyRepository.findByCompanyNameContainsIgnoreCase(name);
	}
}
