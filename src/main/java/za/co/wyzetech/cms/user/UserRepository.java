package za.co.wyzetech.cms.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}