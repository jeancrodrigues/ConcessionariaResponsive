package com.jree.rentstore.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jree.rentstore.model.Funcionario;

@Stateless
public class FuncionarioDaoImpl implements IFuncionarioDao {

	@PersistenceContext(unitName="Cadastro")
	private EntityManager em;
	
	@Override
	public Funcionario save(Funcionario funcionario) {
		return em.merge(funcionario);
	}

	@Override
	public Funcionario get(int primaryKey) {
		return em.find(Funcionario.class, primaryKey);
	}

	@Override
	public void update(Funcionario funcionario) {
		em.merge(funcionario);
	}

	@Override
	public void delete(Funcionario funcionario) {
		em.remove(em.getReference(Funcionario.class, funcionario.getIdfuncionario()));
	}

	@Override
	public List<Funcionario> listAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteria = cb.createQuery(Funcionario.class);
        Root<Funcionario> func = criteria.from(Funcionario.class);
        criteria.select(func).orderBy(cb.asc(func.get("nome")));
        return em.createQuery(criteria).getResultList();
	}

	@Override
	public Funcionario buscarPorCPF(String cpf) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteria = cb.createQuery(Funcionario.class);
        Root<Funcionario> func = criteria.from(Funcionario.class);
        criteria.select(func).where(cb.equal(func.get("cpf"), cpf));
        return em.createQuery(criteria).getSingleResult();
	}

}
