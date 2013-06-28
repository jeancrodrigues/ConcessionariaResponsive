package br.com.concessionaria.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.concessionaria.dao.IFuncionarioDao;
import br.com.concessionaria.model.Funcionario;

@ViewScoped
@ManagedBean
public class FuncionarioBean implements Serializable{
	
	private static final long serialVersionUID = -5686037523430224116L;
	
	@EJB
	private IFuncionarioDao funcionarioDao;	
	
	private String msg;	
	
	@ManagedProperty(value = "#{manterFuncionariosBean.funcionario}")
	private Funcionario funcionario;
	
	@PostConstruct
	private void init(){
		if(funcionario==null){
			this.setFuncionario(new Funcionario());
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String,Object> map = context.getViewRoot().getViewMap();
		
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key).toString());			
		}
		
	}
			
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String salvarFuncionario(){		
		if((!funcionario.getCpf().isEmpty())&&(!funcionario.getNome().isEmpty())){		
			funcionarioDao.save(funcionario);
			return "funcionariosCadastrados";
		}
		setMsg("Falha ao salvar.");
		return "";		
	}	
}
