package com.jree.rentstore.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jree.rentstore.dao.IClienteDao;
import com.jree.rentstore.model.Cliente;


@ViewScoped
@ManagedBean
public class ClienteController extends BaseBean {
		
	private Cliente cliente;
	
	@EJB
	IClienteDao dao;	

	@PostConstruct
	private void init(){
		this.cliente = new Cliente();
		postMessage("novo cliente");
	}	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public String gravarCliente(){
		
//		if(cliente==null){
//			postMessage("objeto cliente nao pode ser nulo");
//		}else if(!cliente.getNome().equals("")&&
//		   !cliente.getCpf().equals("")&&
//		   !cliente.getTelefone().equals("")){
//			
//			dao.save(cliente);	
//			
//			return "index";
//		}		
		return "";		
	}
}
