package devs.berki.cellnetbackend.service;

import devs.berki.cellnetbackend.model.Company;

import java.util.List;

public interface CompanyService {
	 List<Company> getAllCompanies();

	 void addCompany(Company company);

	 Company updateCompany(String name, Long id);

	 void removeCompany(Long id);

	 List<Company>  findByName(String name);
}
