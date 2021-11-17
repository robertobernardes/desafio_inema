package inema.desafio.domains.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EnderecoCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@NotBlank(message = "Campo Logradouro é de preenchimento obrigatório!")
	@Size(max = 250, message = "Tamanho máximo do Campo Logradouro são 250 caracteres")
	private String logradouro;
	
	private Integer numero;
		
	@NotBlank(message = "Campo Bairro é de preenchimento obrigatório!")
	@Size(max = 100, message = "Tamanho máximo do Campo Bairro são 100 caracteres")
	private String bairro;
		
	@NotBlank(message = "Campo CEP é de preenchimento obrigatório!")
	@Size(max = 9, message = "Tamanho máximo do Campo CEP são 9 caracteres")
	private String cep;
	
	@Size(max = 500, message = "Tamanho máximo do Campo Complemento são 500 caracteres")
	private String complemento;
	
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
