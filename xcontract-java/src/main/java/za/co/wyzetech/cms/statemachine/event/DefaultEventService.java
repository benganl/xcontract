package za.co.wyzetech.cms.statemachine.event;

import org.springframework.stereotype.Service;

@Service
class DefaultEventService implements EventService {
    private final EventRepository eventRepository;

    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event eventByName(String name) {
        Event event = eventRepository.findByName(name);
        return event;
    }
}
