package com.example.larn.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPassEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String userQuery;
	
	@Value("${spring.queries.roles-query}")
	private String roleQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(userQuery).authoritiesByUsernameQuery(roleQuery)
			.dataSource(dataSource).passwordEncoder(bCryptPassEncoder);
	}
	
	@Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MyUrlAuthenticationSuccessHandler();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/register/**").permitAll()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers("/student/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "STUDENT_USER")
			.antMatchers("/teacher/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "TEACHER_USER")
			.antMatchers("/both/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "STUDENTY_USER", "TEACHER_USER")
			.anyRequest().authenticated()
			.and()
			.csrf().disable().formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.successHandler(myAuthenticationSuccessHandler())
			.usernameParameter("inputEmail")
			.passwordParameter("inputPassword")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**","/images/**", "/webjars/**",
				"/font/**", "/libs/**","/jquery/**");
	}
}
