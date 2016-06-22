package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="classificado")
public class Classificado {
	
	@Id
	@Column(name="CLASSIFICADO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	
	private String texto;
	
	private Double preco;
	
	private String telefone;
	
	//@Column(name="melhorOferta_id",	nullable=true)
	//private Long classificadoId;
	
	@OneToOne(optional=true)
	@JoinColumn(name="melhorOferta_id",
				referencedColumnName="id_oferta")
	private Oferta melhorOferta;
	
	@Column(name="data_oferta")
	private String data;
	
	Boolean ativo = false; 
	
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario autor;

	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Oferta getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(Oferta melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	 
}
