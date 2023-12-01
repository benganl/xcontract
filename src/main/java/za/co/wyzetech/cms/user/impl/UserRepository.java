package za.co.wyzetech.cms.user.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.user.User;

interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}