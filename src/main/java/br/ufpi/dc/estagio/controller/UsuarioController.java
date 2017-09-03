package br.ufpi.dc.estagio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import br.ufpi.dc.estagio.dao.UsuarioDAO;
import br.ufpi.dc.estagio.entidades.Usuario;
import br.ufpi.dc.estagio.servico.UserService;

@ManagedBean(name="usuarioController")
public class UsuarioController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@PostConstruct
	public void construirListaUsuarios(){
		usuarios = usuarioDAO.listarUsuarios();
		usuario = new Usuario();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String salvarUsuario() {
		usuarioDAO.salvar(usuario);
		usuarios = usuarioDAO.listarUsuarios();
		for (Usuario u : usuarios) {
			System.out.println("nome: " + u.getNome());
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido com sucesso!"));
//		new UsuarioDAO().salvar(usuario);
//		usuarios = new UsuarioDAO().listarUsuarios();
		
		return "cadastrarUsuario";
	}
	
	public void onRowEdit(RowEditEvent event){
		Usuario u = (Usuario)event.getObject();
		usuarioDAO.alterar(u);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Usuario alterado: " + u.getNome() + " com sucesso"));
	}
	
	public String removerUsuario(Usuario u){
		try {
			usuarioDAO.deletar(u);
			usuarios = usuarioDAO.listarUsuarios();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("O usuario "+ usuario.getNome() +" foi deletado com sucesso!"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarUsuarios";
		
	}
	
	public void prepararRemover(Usuario u){
		this.usuario = u;
	}
	
	
//	public List<Usuario> getUsuarios(){
//		return usuarios;
//	}
//	
//	public void setUsuarios(List<Usuario> listaUsuarios){
//		this.usuarios = listaUsuarios;
//	}
	
	public Usuario getUser(){
		return usuario;
	}
	
	public void setNome(String nome) {
		this.usuario.setNome(nome);
	}

	public void setEm(String em) {
		this.usuario.setEmail(em);
	}	

}
