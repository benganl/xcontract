package za.co.wyzetech.cms.workflow.state;

import org.springframework.data.jpa.repository.JpaRepository;

interface StateRepository extends JpaRepository<State, Long> {

    State getByName(String value);

}
