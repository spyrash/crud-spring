package CRUD.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final CustomUserRepository customUserRepository;

    public CustomUserDetailService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //can add logic to deal with the optional here
        CustomUser customUser = customUserRepository.findById(username).get();

        //this is where you can add roles and authorities to the user

        // relational mapping to get roles and authorities

        return User.withUsername(customUser.getUsername()).password(customUser.getPassword()).build();
    }
}
