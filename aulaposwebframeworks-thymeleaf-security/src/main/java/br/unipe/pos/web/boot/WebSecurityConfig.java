/**
 * Projeto das trilhas de treinamento de Java básico ou avançado 
 * com foco nas certificações java e em treinamentos corporativos. 
 * Fontes disponíveis em https://github.com/rodrigofujioka
 * 
 * Professor: Rodrigo da Cruz Fujioka
 * Ano: 2016
 * http://www.rodrigofujioka.com
 * http://www.fujideia.com.br
 * http://lattes.cnpq.br/0843668802633139
 * 
 * Contato: rcf4@cin.ufpe.br 
 */
package br.unipe.pos.web.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Rodrigo C. Fujioka 
 * @date 30 de abr de 2017 
 * @time 03:51:35
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 	
	     .authorizeRequests()
	        .antMatchers("/").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .exceptionHandling()
            .accessDeniedPage("/negado")
            .and()
        .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=1")
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .invalidateHttpSession(true)
            .permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("diego").password("123").roles("USER");
    }
	
}