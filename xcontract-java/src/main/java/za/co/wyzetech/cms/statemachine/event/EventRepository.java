package za.co.wyzetech.cms.statemachine.event;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface EventRepository extends JpaRepository<Event, UUID> {

    Event findByName(String name);

}
