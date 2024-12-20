package com.msr.blog.auth;



import com.msr.blog.MasUser.MasUser;
import com.msr.blog.MasUser.MasUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailSerice implements UserDetailsService {
    private final MasUserRepository userRepository;

    public CustomUserDetailSerice(MasUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MasUser user = this.userRepository.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("username or password not found");
        return new CustomUserDetail(user.getId(),user.getUsername(), user.getPassword(),authorities(),user.getName());
    }

    public Collection<? extends GrantedAuthority> authorities()
    {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
