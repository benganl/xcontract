package za.co.wyzetech.cms.statemachine.stateitem;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface StateItemRepository extends JpaRepository<StateItem, UUID> {

}
