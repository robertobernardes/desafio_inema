package inema.desafio.domains.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PessoaCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Campo Nome é de preenchimento obrigatório!")
	@Size(max = 150, message = "Tamanho máximo do Campo Nome são 150 caracteres")	
	private String nome;
	
	@NotBlank(message = "Campo CPF é de preenchimento obrigatório!")
	@Size(max = 11, message = "Tamanho máximo do Campo CPF são 11 caracteres")
	private String cpf;
	
	@Size(max = 50, message = "Tamanho máximo do Campo E-mail são 50 caracteres")
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
