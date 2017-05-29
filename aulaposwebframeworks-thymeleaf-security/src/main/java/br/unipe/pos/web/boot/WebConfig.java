/**
 * Projeto das trilhas de treinamento de Java b�sico ou avan�ado 
 * com foco nas certifica��es java e em treinamentos corporativos. 
 * Fontes dispon�veis em https://github.com/rodrigofujioka
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author Rodrigo C. Fujioka
 * @date 29 de abr de 2017
 * @time 14:06:21
 *
 */
@SpringBootApplication
public class WebConfig {

	static Class[] listaConfiguracao = { LoadPackageConfig.class, 
										 WebSecurityConfig.class, 
										 WebTemplateConfig.class,										 
											WebConfig.class };
	/**
	 * Inclui as libs do bootstrap no projeto 
	 * @param registry
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}

	
	/**
	 * Inicia a aplicação. 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(listaConfiguracao, args);
	}
}


