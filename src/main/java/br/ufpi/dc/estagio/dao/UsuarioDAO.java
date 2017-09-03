package br.ufpi.dc.estagio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.ufpi.dc.estagio.entidades.Usuario;

public class UsuarioDAO {
	
	public void salvar(Usuario usuario){
		EntityManager em = JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//	@SuppressWarnings({"unchecked" })
	public List<Usuario> listarUsuarios(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		List<Usuario> listUsuarios = query.getResultList();
				
		return listUsuarios;
		
	}
	
	public void alterar(Usuario usuario){
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void deletar(Usuario usuario){
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
