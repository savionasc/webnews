package br.ufc.model;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	private String email;	
	
	private boolean imgEstado = false;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Favorito.class,
			   fetch=FetchType.EAGER)
	private List<Favorito> favoritos;
	
	@ManyToMany(fetch=FetchType.EAGER)
	//id desse usuario
	@JoinTable(name="PAPEL_USUARIO",
			joinColumns=@JoinColumn(name="USUARIO_ID",
									referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="PAPEL_ID",
										   referencedColumnName="id"))
	private List<Papel> papelList;
	
	@OneToMany(mappedBy="autor",
			   targetEntity=Noticia.class,
			   fetch=FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String login, String senha, String nome,
		List<Papel> papelList) {
		this.login = login;
		setSenha(senha);
		this.nome = nome;
		this.papelList = papelList;
	}
	
	public List<Papel> getPapelList() {
		return papelList;
	}

	public void setPapelList(List<Papel> papelList) {
		this.papelList = papelList;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		MD5Criptografia md5 = new MD5Criptografia();
        this.senha = md5.criptografar(senha);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isImgEstado() {
		return imgEstado;
	}

	public void setImgEstado(boolean imgEstado) {
		this.imgEstado = imgEstado;
	}
	
	public List<Favorito> getFavoritos() {
		return favoritos;
	}
	
	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
	
	@Override
	public boolean equals(Object obj) {	
		if(!(obj instanceof Usuario))
			return false;
		
		Usuario ref = (Usuario)obj;
		if(ref.getId()==this.id)
			return true;
		return false;	
	}	
}