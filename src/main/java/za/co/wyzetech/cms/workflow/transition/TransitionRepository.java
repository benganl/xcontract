package za.co.wyzetech.cms.workflow.transition;

import org.springframework.data.jpa.repository.JpaRepository;

interface TransitionRepository extends JpaRepository<Transition, Long> {

}
