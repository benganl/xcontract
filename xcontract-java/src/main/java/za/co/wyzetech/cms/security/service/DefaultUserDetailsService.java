package za.co.wyzetech.cms.security.service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import za.co.wyzetech.cms.security.UserService;
import za.co.wyzetech.cms.security.user.Role;
import za.co.wyzetech.cms.security.user.User;

@Service
class DefaultUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public DefaultUserDetailsService(UserService userService) {
	this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userService.findByUsername(username);
	if (Objects.nonNull(user)) {
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
		    getAuthorities(user.getRoles()));
	} else {
	    throw new UsernameNotFoundException("Incorrect and/or invalid credentials");
	}
    }
    
    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
	return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toSet());
    }
}
