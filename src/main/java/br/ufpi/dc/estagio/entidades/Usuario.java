package br.ufpi.dc.estagio.entidades;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@Table(name="usuario")
//@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@ManagedBean
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="email")
	private String email;
	
	public Usuario(){
		
	}
	
//	public Usuario(String nome, String email) {
//		super();
//		this.nome = nome;
//		this.email = email;
//	}
	
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
	
	
}
