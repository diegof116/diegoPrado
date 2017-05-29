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

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Arquivo de configura��o do Sprint utilizado para indicar onde o Spring deve
 * procurar as classes.
 * 
 * @author Rodrigo C. Fujioka
 * @date 30 de abr de 2017
 * @time 03:00:53
 *
 */
@EntityScan(basePackages = { "br.unipe.pos.web.model" })
@EnableJpaRepositories(basePackages = { "br.unipe.pos.web.dao" })
@ComponentScan(basePackages = { "br.unipe.pos.web.controller",
		                        "br.unipe.pos.web.service" })
public class LoadPackageConfig {    }

