package inema.desafio.domains.dtos;

import java.io.Serializable;

public class PessoaCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String email;
	
	private EnderecoCreateDTO endereco;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoCreateDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCreateDTO endereco) {
		this.endereco = endereco;
	}
}
