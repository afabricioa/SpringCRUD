package br.ufpi.dc.estagio.servico;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.ufpi.dc.estagio.dao.UsuarioDAO;
import br.ufpi.dc.estagio.entidades.Usuario;

@Service
@ManagedBean(name="userService")
public class UserServiceImpl implements UserService, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;
	
	public void setUsuarioDAO(UsuarioDAO userDAO){
		this.usuarioDAO = userDAO;
	}

	@Override
	@Transactional
	public void salvar(Usuario usuario) {
		System.out.println("dsdsadas");
		this.usuarioDAO.salvar(usuario);
		
	}

	@Override
	@Transactional
	public void remover(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void alterar(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Usuario> listarUsuarios() {
		return this.usuarioDAO.listarUsuarios();
	}

}
