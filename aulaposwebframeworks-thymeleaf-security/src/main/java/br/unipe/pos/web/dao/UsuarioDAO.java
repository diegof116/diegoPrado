package br.unipe.pos.web.dao;


/**
 * Projeto das trilhas de especialização em desenvolvimento Web coordenada 
 * pelo professor Rodrigo Fujioka.
 * Disciplina: Web Frameworks.
 * Fontes disponíveis em https://github.com/rodrigofujioka/aulaposwebframeworks
 * 
 * Professor: Rodrigo da Cruz Fujioka
 * Ano: 2017
 * http://www.rodrigofujioka.com
 * http://www.fujideia.com.br
 * http://lattes.cnpq.br/0843668802633139
 * 
 * Contato: rcf4@cin.ufpe.br 
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.web.model.UsuarioModel;

/**
 * @author Rodrigo C. Fujioka 
 * @date 29 de abr de 2017 
 * @time 06:47:38
 *
 */
@Repository
public interface UsuarioDAO 
extends JpaRepository<UsuarioModel, Integer>{

	public void findByNome(String nome);

}
