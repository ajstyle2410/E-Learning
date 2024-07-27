package com.elearning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.elearning.Handler.CustomSucessHandler;
import com.elearning.auth.CustomUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
     
	@Autowired
	private CustomSucessHandler customSucessHandler;
     
     @Autowired
     private CustomUserService customUserService;

	@Bean
	 static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/admin").hasAnyAuthority("ADMIN")
						.requestMatchers("user").hasAnyAuthority("USER").requestMatchers("/reigstration").permitAll()

				)
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
						.successHandler(customSucessHandler).permitAll())
				.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
						.permitAll());

		return http.build();
	}
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
	}
}
