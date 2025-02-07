package devs.berki.cellnetbackend.controllers;

import devs.berki.cellnetbackend.model.Tariff;
import devs.berki.cellnetbackend.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tariffs")
@AllArgsConstructor
public class TariffController {
	private final TariffService tariffService;

	@GetMapping("/{companyId}")
	public List<Tariff> getAllTariffs(@PathVariable Long companyId) {
		return tariffService.getAllTariffs(companyId);
	}

	@PostMapping("add/{companyId}")
	public String addTariff(@RequestBody Tariff tariff, @PathVariable Long companyId) {
		tariffService.addTariff(tariff, companyId);
		return "Tariff successfully added";
	}

	@PutMapping("update/{companyId}/{id}")
	public Tariff updateTariff(@RequestBody Tariff tariff, @PathVariable Long id, @PathVariable Long companyId) {
		return tariffService.updateTariff(tariff.getName(), tariff.getPrice(), id, companyId);
	}

	@DeleteMapping("remove/{id}")
	public String removeTariff(@PathVariable Long id) {
		tariffService.removeTariff(id);
		return "Tariff successfully deleted";
	}
}