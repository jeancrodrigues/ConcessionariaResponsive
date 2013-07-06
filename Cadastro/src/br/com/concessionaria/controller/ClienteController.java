package br.com.concessionaria.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.concessionaria.dao.IClienteDao;
import br.com.concessionaria.model.Cliente;


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
		
		if(cliente==null){
			postMessage("objeto cliente nao pode ser nulo");
		}else if(!cliente.getNome().equals("")&&
		   !cliente.getCpf().equals("")&&
		   !cliente.getTelefone().equals("")){
			
			dao.save(cliente);	
			
			return "index";
		}		
		return "";		
	}
}
