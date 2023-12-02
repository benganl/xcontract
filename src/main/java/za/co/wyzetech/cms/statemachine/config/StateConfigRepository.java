package za.co.wyzetech.cms.statemachine.config;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface StateConfigRepository extends JpaRepository<StateConfig, UUID> {

}
