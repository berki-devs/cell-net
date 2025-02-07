package devs.berki.cellnetbackend.controllers;

import devs.berki.cellnetbackend.model.Company;
import devs.berki.cellnetbackend.service.CompanyService;
import devs.berki.cellnetbackend.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {
	private final CompanyService companyService;
	private final TariffService tariffService;


	@GetMapping
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("/{name}")
	public List<Company> findByName(@PathVariable String name) {
		return companyService.findByName(name);
	}

	@PostMapping("add")
	public String addCompany(@RequestBody Company company) {
		companyService.addCompany(company);
		return "Company successfully added";
	}

	@PutMapping("update/{id}")
	public Company updateCompany(@RequestBody Company company, @PathVariable Long id) {
		return companyService.updateCompany(company.getCompanyName(), id);
	}

	@DeleteMapping("remove/{id}")
	public String removeCompany(@PathVariable Long id) {
		companyService.removeCompany(id);
		return "Company successfully deleted";
	}
}
