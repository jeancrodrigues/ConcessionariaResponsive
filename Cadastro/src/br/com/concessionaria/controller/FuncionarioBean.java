package br.com.concessionaria.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.concessionaria.dao.IFuncionarioDao;
import br.com.concessionaria.model.Funcionario;

@ViewScoped
@ManagedBean
public class FuncionarioBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = -5686037523430224116L;
	
	@EJB
	private IFuncionarioDao funcionarioDao;	
	
	private String msg;	
		
	private Funcionario funcionario;
	
	@PostConstruct
	private void init(){		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
		
		Map<String,String> params = context.getRequestParameterMap();
		
		if(params.containsKey("func_id")){
			int id = Integer.valueOf(params.get("func_id"));
			postMessage("editando o funcionario " + id);
			funcionario = funcionarioDao.get(id);
			
		}else{
			this.setFuncionario(new Funcionario());
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
		System.out.println("setado funcionario " + funcionario.getNome());
		this.funcionario = funcionario;
	}
	
	public String salvarFuncionario(){		
		if((!funcionario.getCpf().isEmpty())&&(!funcionario.getNome().isEmpty())){		
			funcionarioDao.save(funcionario);
			return "funcionariosCadastrados?faces-redirect=true";
		}
		setMsg("Falha ao salvar.");
		return "";		
	}	
}
