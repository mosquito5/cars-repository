package pl.mosquito.cars.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.mosquito.cars.service.CustomUserDetailsService;

import static pl.mosquito.cars.controller.rest.RestURIConstants.ADVERTISE_API;
import static pl.mosquito.cars.controller.rest.RestURIConstants.USER_API;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeRequests().antMatchers("/").permitAll();
//        httpSecurity
//                .authorizeRequests()
//                    .antMatchers("/", "/signup", "/api/newUser/add").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/signin")
//                        .permitAll();


//
//        httpSecurity.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/User/add", "/api/User/resetpass").permitAll()
//                .antMatchers().hasRole("USER").anyRequest().authenticated()
//                .and()
//                    .httpBasic()
//                    .realmName("TEST");

        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/User/add", "/api/User/resetpass").permitAll()
                .antMatchers(USER_API, ADVERTISE_API).hasRole("USER").anyRequest().authenticated()
                .antMatchers().hasRole("ADMIN").anyRequest().authenticated()
                .and()
                .httpBasic()
                .realmName("TEST");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
          return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return  authenticationProvider;
    }
}
