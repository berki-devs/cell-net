package devs.berki.cellnetbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_name")
	private String companyName;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Tariff> tariffs;

	public void addTariff(Tariff tariff) {
		tariffs.add(tariff);
		tariff.setCompany(this);
	}

//	public void removeTariff(Tariff tariff) {
//		tariffs.remove(tariff);
//		tariff.setCompany(null);
//	}
}