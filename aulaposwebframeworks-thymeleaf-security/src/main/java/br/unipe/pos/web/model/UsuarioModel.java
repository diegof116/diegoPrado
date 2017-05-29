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
package br.unipe.pos.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe mepeda com JPA para uma base de dados.
 * 
 * @author Rodrigo C. Fujioka
 * @date 22 de abr de 2017
 * @time 20:27:06
 * 
 */
@Entity
@Table(name = "tb_usuario")
public class UsuarioModel implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "senha")
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


}
