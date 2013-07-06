package com.jree.rentstore.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jree.rentstore.dao.IFuncionarioDao;
import com.jree.rentstore.model.Funcionario;

@ViewScoped
@ManagedBean
public class ManterFuncionariosBean implements Serializable{
	
	private static final long serialVersionUID = -3609527376087844387L;

	@EJB
	private IFuncionarioDao funcionarioDao;
	
	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ManterFuncionariosBean() {	
		System.out.println("novo manterfuncionariobean");
	}
	
	public List<Funcionario> getFuncionarios(){
		return funcionarioDao.listAll();
	}
	
	public void excluirFuncionario(Funcionario func){
		try {
			funcionarioDao.delete(func);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
	}
	
	public String cadastroFuncionario(){
		return "cadastroFuncionario";
	}
}
