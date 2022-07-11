package com.appForTruckDriver.appForTruckDriver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT username, password, enabled from customer where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority " +
                                "FROM authority a, customer u " +
                                "WHERE u.username = ? " +
                                "AND u.id = a.user_id"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll(); //Leidzia matyti visus endpointus po slasho
        http.formLogin(); //pateikiame useriui login forma.
        // ne authenticated useriams leidziamas matyti "/" adresas, o visi kiti adresai tik authenticated usersiams
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/admin").hasAuthority("ADMIN")
//                .antMatchers("/products").hasAuthority("USER")
//                .anyRequest().authenticated();
    }


}
