package br.com.concessionaria.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique=true, nullable=false)
	private int idfuncionario;

	@Column(nullable=false, length=11)
	private String cpf;

	@Column(nullable=false, length=60)
	private String nome;

	public Funcionario() {
	}

	public int getIdfuncionario() {
		return this.idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}