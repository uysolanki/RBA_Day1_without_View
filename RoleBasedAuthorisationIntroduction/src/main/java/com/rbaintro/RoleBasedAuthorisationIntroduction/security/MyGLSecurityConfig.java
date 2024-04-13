package com.rbaintro.RoleBasedAuthorisationIntroduction.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rbaintro.RoleBasedAuthorisationIntroduction.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class MyGLSecurityConfig //extends WebSecurityConfigurerAdapter
{

//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.authenticationProvider(glAuthPro());  //single point of contact method for the authentication
//}

@Bean
public DaoAuthenticationProvider glAuthPro() {
	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	daoAuthenticationProvider.setUserDetailsService(glUserDetails());
	daoAuthenticationProvider.setPasswordEncoder(glPasswordEncoder());
	return daoAuthenticationProvider;
}

@Bean
public PasswordEncoder glPasswordEncoder() {
	return new BCryptPasswordEncoder();
}

@Bean
public UserDetailsService glUserDetails() {
	return new UserDetailsServiceImpl();
}

//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests()
//	            .antMatchers("/","/getAPI","/insertAPI").hasAnyAuthority("USER","ADMIN")
//	            .antMatchers("/updateAPI","/deleteAPI").hasAuthority("ADMIN")
//	            .anyRequest().authenticated()
//	            .and()
//	            .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAPI").permitAll()
//	            .and()
//	            .logout().logoutSuccessUrl("/login").permitAll()
//	            .and()
//	            .exceptionHandling().accessDeniedPage("/unauthUser")
//	            .and()
//	            .cors().and().csrf().disable();
//}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeRequests()
    .antMatchers("/","/getAPI","/insertAPI").hasAnyAuthority("USER","ADMIN")
    .antMatchers("/updateAPI","/deleteAPI").hasAuthority("ADMIN")
    .anyRequest().authenticated()
    .and()
    .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAPI").permitAll()
    .and()
    .logout().logoutSuccessUrl("/login").permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/unauthUser")
    .and()
    .cors().and().csrf().disable();
	
	http.authenticationProvider(glAuthPro());
	return http.build();

}
}
