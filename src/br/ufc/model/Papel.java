package br.ufc.model;

import java.util.List; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="papel")
public class Papel {
	
	public Papel() {
		super();
	}
	
	public Papel(String papel) {
		this.papel = papel;
	}

	@Id
	@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String papel;

	
	@ManyToMany(mappedBy="papelList", fetch=FetchType.LAZY)
	private List<Usuario> listaUsuarios;
	
	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
