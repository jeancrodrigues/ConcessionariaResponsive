package br.com.concessionaria.dao;

import br.com.concessionaria.model.Funcionario;

public interface IFuncionarioDao extends IConcessionariaBaseDAO<Funcionario> {	
	public Funcionario buscarPorCPF(String cpf);		
}
