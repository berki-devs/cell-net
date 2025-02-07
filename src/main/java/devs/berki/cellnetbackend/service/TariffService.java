package devs.berki.cellnetbackend.service;

import devs.berki.cellnetbackend.model.Tariff;

import java.math.BigInteger;
import java.util.List;

public interface TariffService {
	List<Tariff> getAllTariffs(Long companyId);

	void addTariff(Tariff tariff, Long companyId);

	Tariff updateTariff(String name, BigInteger price, Long id, Long companyId);

	void removeTariff(Long id);
}