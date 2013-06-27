package br.com.concessionaria.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean
public class BaseBean {	

	
	
	protected void postMessage(String msg){		
		FacesContext context = FacesContext.getCurrentInstance();		
		context.addMessage(null, new FacesMessage(msg));
	}
}
