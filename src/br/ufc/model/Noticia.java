package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="noticia")
public class Noticia {
	@Id
	@Column(name="NOTICIA_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noticiaId;
	
	private String titulo;
	
	private String texto;
	
	private Long acesso = 0l;
	
	/*
	@Column(name="SECAO_ID",
			insertable=false,
			updatable=false,
			nullable=false)*/
	//private Long secaoId;
	
	
	//@OneToOne(cascade = CascadeType.ALL, optional=true)
	//@JoinColumn(name="AUTOR_ID")
	//private Usuario autor;
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="id_secao",
				referencedColumnName="SECAO_ID", unique=false)
	private Secao secao;
	
	/*
	@OneToOne(optional=true, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "id", unique=false)
	private Usuario id;*/
	
	@ManyToOne(optional=true, cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario autor;
	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	/*public Usuario getSecao() {
		return id;
	}

	public void setId(Usuario id) {
		this.id = id;
	}*/
	
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Long getAcesso() {
		return acesso;
	}

	public void setAcesso(Long acesso) {
		this.acesso = acesso;
	}
	
	
}
