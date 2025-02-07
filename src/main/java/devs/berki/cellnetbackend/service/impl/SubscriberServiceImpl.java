package devs.berki.cellnetbackend.service.impl;

import devs.berki.cellnetbackend.model.Subscriber;
import devs.berki.cellnetbackend.model.Tariff;
import devs.berki.cellnetbackend.repository.SubscriberRepository;
import devs.berki.cellnetbackend.repository.TariffRepository;
import devs.berki.cellnetbackend.service.SubscriberService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class SubscriberServiceImpl implements SubscriberService {
	private final SubscriberRepository subscriberRepository;
	private final TariffRepository tariffRepository;

	@Override
	public List<Subscriber> getAllSubscribers(Long tariffId) {
		return subscriberRepository.findAllByTariffId(tariffId);
	}

	@Override
	public void addSubscriber(Subscriber subscriber, Long tariffId) {
		Tariff tariff = tariffRepository.findById(tariffId).orElse(null);
		if (tariff != null) {
			subscriber.setTariff(tariff);
			subscriberRepository.save(subscriber);
		}
	}


	// TODO: Fix this shit, I'm so tired right now
	@Override
	public Subscriber updateSubscriber(Subscriber subscriber, Long id, Long tariffId) {
		Subscriber existingSubscriber = subscriberRepository.findById(id).orElse(null);
		if (existingSubscriber != null) {
			if (subscriber.getFirstName() != null) {
				existingSubscriber.setFirstName(subscriber.getFirstName());
			}
			if (subscriber.getLastName() != null) {
				existingSubscriber.setLastName(subscriber.getLastName());
			}
			if (subscriber.getPhoneNumber() != null) {
				existingSubscriber.setPhoneNumber(subscriber.getPhoneNumber());
			}
			if (subscriber.getBalance() != null) {
				existingSubscriber.setBalance(subscriber.getBalance());
			}

			return subscriberRepository.save(existingSubscriber);
		}
		return null;
	}

	@Override
	public void removeSubscriber(Long id) {
		subscriberRepository.deleteById(id);
	}
}