package br.ufc.model;

import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="noticia")
public class Noticia {
	
	@Id
	@Column(name="NOTICIA_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noticiaId;
	
	private String titulo;
	
	private String texto;
	
	private Long acesso = 0l;
	
	private Locale locale;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="id_secao",
				referencedColumnName="SECAO_ID", unique=false)
	private Secao secao;
	
	@ManyToOne(optional=true, cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario autor;
	
	@OneToMany(mappedBy="noticia",
			   targetEntity=Favorito.class,
			   fetch=FetchType.EAGER)
	private List<Favorito> favoritos;
	
	private boolean inativo = false;
	
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
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

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

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}
}
