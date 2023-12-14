package za.co.wyzetech.cms.security.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.security.user.User;

interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}