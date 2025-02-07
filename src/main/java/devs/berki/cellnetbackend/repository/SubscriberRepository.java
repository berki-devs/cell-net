package devs.berki.cellnetbackend.repository;

import devs.berki.cellnetbackend.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
	List<Subscriber> findAllByTariffId(Long tariffId);

	boolean existsByTariffId(Long tariffId);
}
