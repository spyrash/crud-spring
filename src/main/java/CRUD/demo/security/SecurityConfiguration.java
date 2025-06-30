package CRUD.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    // this configuration overrides the default security configuration in the application.properties file without it,
    // we would have to provide a username and password in the application.properties file
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User
                .withUsername("admin")
                .authorities("BASIC", "SPECIAL")
                .password(passwordEncoder.encode("1"))   // spring boot won't let you use raw text for passwords
                .build();

        UserDetails user = User
                .withUsername("user")
                .authorities("BASIC")
                .password(passwordEncoder.encode("2"))
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // allows for POST, PUT, DELETE mappings with authentication
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/open").permitAll();
                    authorize.requestMatchers("/closed").authenticated();
                    authorize.requestMatchers(HttpMethod.POST, "/product").authenticated();
                    authorize.requestMatchers(HttpMethod.GET, "/special").hasAuthority("SPECIAL");
                    authorize.requestMatchers(HttpMethod.GET, "/basic").hasAnyAuthority("BASIC", "SPECIAL");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
        // video 9:11
    }
}
