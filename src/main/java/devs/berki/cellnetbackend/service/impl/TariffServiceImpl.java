package devs.berki.cellnetbackend.service.impl;

import devs.berki.cellnetbackend.model.Company;
import devs.berki.cellnetbackend.model.Tariff;
import devs.berki.cellnetbackend.repository.CompanyRepository;
import devs.berki.cellnetbackend.repository.TariffRepository;
import devs.berki.cellnetbackend.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class TariffServiceImpl implements TariffService {
	private final TariffRepository tariffRepository;
	private final CompanyRepository companyRepository;

	@Override
	public List<Tariff> getAllTariffs(Long companyId) {
		return tariffRepository.findAllByCompanyId(companyId);
	}

	@Override
	public void addTariff(Tariff tariff, Long companyId) {
		Company company = companyRepository.findById(companyId).orElse(null);
		if (company != null) {
			company.addTariff(tariff);
			companyRepository.save(company);
		}
	}

	// TODO: Fix here too...
	@Override
	public Tariff updateTariff(String name, BigInteger price, Long id, Long companyId) {
		if (tariffRepository.existsByCompanyId(companyId)) {
			Tariff tariff = tariffRepository.findById(id).orElse(null);
			if (tariff != null) {
				if (name != null) {
					tariff.setName(name);
				}
				if (price != null) {
					tariff.setPrice(price);
				}
				return tariffRepository.save(tariff);
			}
		}
		return null;
	}

	@Override
	public void removeTariff(Long id) {
		tariffRepository.deleteById(id);
	}
}