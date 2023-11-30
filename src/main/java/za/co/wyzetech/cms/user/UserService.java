package za.co.wyzetech.cms.user;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
		"User not found with username: " + username));

	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(
		user.getRoles()));
    }

    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
	return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toSet());
    }

    public void createUser(String username, String password) {
	User newUser = new User();
	newUser.setUsername(username);
	newUser.setPassword(password);
	newUser.setDateCreated(new Date());
	newUser.setRoles(null);
	userRepository.save(newUser);
	
    }
}
