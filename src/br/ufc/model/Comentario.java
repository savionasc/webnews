package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="comentario")
public class Comentario {

	@Id
	@Column(name="COMENTARIO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comentarioId;
	
	@OneToOne(optional=true)
    @JoinColumn(name = "noticia_id", unique=false)
	private Noticia noticia;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario autor;
	
	private String texto;

	public Long getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(Long comentarioId) {
		this.comentarioId = comentarioId;
	}

	
	public Noticia getNoticia() {
		return noticia;
	}


	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}


	public Usuario getAutor() {
		return autor;
	}


	public void setAutor(Usuario autor) {
		this.autor = autor;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
