package inema.desafio.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inema.desafio.domains.Pessoa;
import inema.desafio.domains.dtos.PessoaCreateDTO;
import inema.desafio.repositories.PessoaRepository;
import inema.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * Método responsável por realizar a pesquisa de todas pessoas cadastradas 
	 * @return List (List<Pessoa>)
	 */
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	/**
	 * Método responsável por realizar o cadastro de pessoa
	 * @param obj (PessoaCreateDTO)
	 * @return Pessoa
	 */
	@Transactional
	public Pessoa insert(PessoaCreateDTO objPessoaDTO) {
		Pessoa obj = new Pessoa(
				null,
				objPessoaDTO.getNome().trim(),
				objPessoaDTO.getCpf().trim(),				
				(objPessoaDTO.getEmail()!=null && !objPessoaDTO.getEmail().trim().isEmpty()) ? objPessoaDTO.getEmail().trim() : null,
				enderecoService.insert(objPessoaDTO.getEndereco()),
				false
		);
		
		//Salvando a entidade Pessoa
		pessoaRepository.save(obj);
		return obj;
	}
		
	/**
	 * Método responsável por realizar a busca de uma pessoa através do Id 
	 * @param ID (Integer)
	 * @return Pessoa
	 */
	public Pessoa findById(Integer id) {
		
		if (id == null) {
			throw new IllegalArgumentException("Campo ID é de preenchimento obrigatório!");
		}
		
		Pessoa obj = pessoaRepository.findById(id).orElse(null); 
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName());
		}
		return obj;
	}
	
	/**
	 * Método responsável por deletar logicamente uma pessoa e seu endereço através do Id da pessoa
	 * @param ID (Integer)
	 */
	@Transactional
	public void delete(Integer id) {
		
		if (id == null) {
			throw new IllegalArgumentException("Campo ID é de preenchimento obrigatório!");
		}
		
		Pessoa obj = findById(id);
		
		obj.setExcluido(true);
		obj.getEndereco().setExcluido(true);
		
		//Salvando a entidade Pessoa
		pessoaRepository.save(obj);
	}

	/**
	 * Método responsável por realizar a atualização de pessoa
	 * @param ID (Integer), obj (PessoaCreateDTO)
	 * @return Pessoa
	 */
	@Transactional
	public Pessoa update(Integer id, PessoaCreateDTO objPessoaDTO) {
		
		if (id == null) {
			throw new IllegalArgumentException("Campo ID é de preenchimento obrigatório!");
		}
		
		//Buscando entidade de Pessoa
		Pessoa obj = findById(id);
		
		//Populando a entidade de Pessoa com os novos valores
		obj.setNome(objPessoaDTO.getNome());
		obj.setCpf(objPessoaDTO.getCpf());
		obj.setEmail(objPessoaDTO.getEmail());
		obj.setEndereco(enderecoService.update(obj.getEndereco(), objPessoaDTO.getEndereco()));
		obj.setExcluido(false);
		
		//Salvando a entidade Pessoa
		pessoaRepository.save(obj);
		
		return obj;
	}
}
