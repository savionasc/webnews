package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="aluno")
public class Aluno {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="{aluno.nome.vazio}")
	@Size(min=5,message="{aluno.nome.min}")
	private String nome;
	
	private Double IRA;
	
	private String login;
	
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getIRA() {
		return IRA;
	}
	public void setIRA(Double iRA) {
		IRA = iRA;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Aluno))
			return false;
		
		Aluno ref = (Aluno)obj;
		if(ref.getId()==this.id)
			return true;
		return false;
		
	}
	
}











