package it.aulab.learningplatform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager users() {
        UserBuilder admin = User.withUsername("admin")
                                .password(encoder().encode("admin"))
                                .roles("ADMIN");
        // UserBuilder user = User.withUsername("user")
        //                         .password(encoder().encode("user"))
        //                         .roles("SIMPLE");

        // return new InMemoryUserDetailsManager(admin.build(), user.build());
        return new InMemoryUserDetailsManager(admin.build());
    }

    @Bean
    public SecurityFilterChain configSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
            .requestMatchers("/api/**").permitAll()
            .anyRequest().authenticated()
        .and().formLogin()
              .loginPage("/login")
              .loginProcessingUrl("/login")
              .defaultSuccessUrl("/", true)
              .permitAll()
        .and().logout()
              .logoutUrl("/logout")
              .logoutSuccessUrl("/login")
              .permitAll()
        .and().csrf().ignoringRequestMatchers("/api/**");

        return http.build();
    }

}
