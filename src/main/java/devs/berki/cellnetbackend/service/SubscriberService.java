package devs.berki.cellnetbackend.service;

import devs.berki.cellnetbackend.model.Subscriber;

import java.util.List;

public interface SubscriberService {
	List<Subscriber> getAllSubscribers(Long tariffId);

	void addSubscriber(Subscriber subscriber, Long tariffId);

	Subscriber updateSubscriber(Subscriber subscriber, Long id, Long tariffId);

	void removeSubscriber(Long id);
}