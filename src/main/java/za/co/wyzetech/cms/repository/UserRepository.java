package za.co.wyzetech.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.wyzetech.cms.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}