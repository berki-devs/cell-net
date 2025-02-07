package devs.berki.cellnetbackend.controllers;

import devs.berki.cellnetbackend.model.Subscriber;
import devs.berki.cellnetbackend.service.SubscriberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscribers")
@AllArgsConstructor
public class SubscriberController {
	private final SubscriberService subscriberService;

	@GetMapping("/{tariffId}")
	public List<Subscriber> getAllSubscribers(@PathVariable Long tariffId) {
		return subscriberService.getAllSubscribers(tariffId);
	}

	@PostMapping("add/{tariffId}")
	public String addSubscriber(@RequestBody Subscriber subscriber, @PathVariable Long tariffId) {
		subscriberService.addSubscriber(subscriber, tariffId);
		return "Subscriber successfully added";
	}

	@PutMapping("update/{tariffId}/{id}")
	public Subscriber updateSubscriber(@RequestBody Subscriber subscriber, @PathVariable Long id, @PathVariable Long tariffId) {
		return subscriberService.updateSubscriber(subscriber, id, tariffId);
	}

	@DeleteMapping("remove/{id}")
	public String removeSubscriber(@PathVariable Long id) {
		subscriberService.removeSubscriber(id);
		return "Subscriber successfully deleted";
	}
}