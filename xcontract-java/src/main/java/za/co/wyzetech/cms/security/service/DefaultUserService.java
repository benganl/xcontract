package za.co.wyzetech.cms.security.service;

import java.util.Date;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import za.co.wyzetech.cms.security.UserService;
import za.co.wyzetech.cms.security.user.User;

@Service
class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
	return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
		"User not found with username: " + username));
    }

    @Override
    public void createUser(String username, String password) {
	User newUser = new User();
	newUser.setUsername(username);
	newUser.setPassword(password);
	newUser.setDateCreated(new Date());
	newUser.setRoles(null);
	userRepository.save(newUser);
    }
}
