package za.co.wyzetech.cms.statemachine.state;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface StateRepository extends JpaRepository<State, UUID> {

    State findByName(String name);

}
