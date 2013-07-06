package com.jree.rentstore.dao;

import com.jree.rentstore.model.Funcionario;

public interface IFuncionarioDao extends IConcessionariaBaseDAO<Funcionario> {	
	public Funcionario buscarPorCPF(String cpf);		
}
