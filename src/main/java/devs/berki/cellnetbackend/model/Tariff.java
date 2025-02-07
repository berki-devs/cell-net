package devs.berki.cellnetbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "tariffs")
public class Tariff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private BigInteger price;

	@ManyToOne
	@JoinColumn(name = "company_id")
	@JsonBackReference
	private Company company;

	@OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Subscriber> subscribers;
}