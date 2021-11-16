package inema.desafio.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inema.desafio.domains.Pessoa;
import inema.desafio.domains.dtos.PessoaCreateDTO;
import inema.desafio.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * Método responsável por realizar a pesquisa de todas pessoas cadastradas 
	 * @return List<Pessoa>
	 */
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	/**
	 * Método responsável por realizar o cadastro de pessoa 
	 * @return Pessoa
	 */
	@Transactional
	public Pessoa insert(PessoaCreateDTO objPessoaDTO) {
		//Integer id, String nome, String cpf, String email, Endereco endereco, boolean excluido
		Pessoa obj = new Pessoa(
				null,
				objPessoaDTO.getNome(),
				objPessoaDTO.getCpf(),
				objPessoaDTO.getEmail(),				
				enderecoService.insert(objPessoaDTO.getEndereco()),
				false
		);
		
		//Salvando a entidade Pessoa
		pessoaRepository.save(obj);
		return obj;
	}

}
