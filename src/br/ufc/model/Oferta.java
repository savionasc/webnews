package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="oferta")
public class Oferta {

	@Id
	@Column(name="id_oferta",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_oferta;
	
	private Double preco;
		
	@OneToOne(optional=true)
	@JoinColumn(name="CLASSIFICADO_ID",
				referencedColumnName="CLASSIFICADO_ID")
	private Classificado classificado;
	
	@OneToOne(optional=true)
    @JoinColumn(name = "usuario_id", unique=false)
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new Date();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(Long id_oferta) {
		this.id_oferta = id_oferta;
	}

	public Classificado getClassificado() {
		return classificado;
	}

	public void setClassificado(Classificado classificado) {
		this.classificado = classificado;
	}
}
