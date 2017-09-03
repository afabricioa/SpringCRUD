package br.ufpi.dc.estagio.servico;

import java.util.List;

import br.ufpi.dc.estagio.entidades.*;

public interface UserService {
	
	public void salvar(Usuario usuario);
    public void remover(Usuario usuario);
    public void alterar(Usuario usuario);
	public List<Usuario> listarUsuarios();

}
