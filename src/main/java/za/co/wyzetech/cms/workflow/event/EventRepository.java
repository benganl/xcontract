package za.co.wyzetech.cms.workflow.event;

import org.springframework.data.jpa.repository.JpaRepository;

interface EventRepository extends JpaRepository<Event, Long> {

}
