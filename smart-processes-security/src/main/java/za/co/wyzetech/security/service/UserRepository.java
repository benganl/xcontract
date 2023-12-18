package za.co.wyzetech.security.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.wyzetech.security.user.User;

import java.util.Optional;
import java.util.UUID;

interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}