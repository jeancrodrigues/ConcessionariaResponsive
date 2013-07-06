package br.com.concessionaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.concessionaria.model.Cliente;

@Stateless
public class ClienteDao implements IClienteDao {
	
	@PersistenceContext(name="Cadastro")
	EntityManager em;

	@Override
	public Cliente save(Cliente cliente) {			
		em.persist(cliente);		
		return null;
	}

	@Override
	public Cliente get(int primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cliente cliente) {
		em.merge(cliente);		
	}

	@Override
	public void delete(Cliente object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
