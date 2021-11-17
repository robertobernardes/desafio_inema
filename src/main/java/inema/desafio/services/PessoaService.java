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
		
	/**
	 * Método responsável por realizar a busca de uma pessoa através do Id 
	 * @return Pessoa
	 */
	public Pessoa findById(Integer id) {
		Pessoa obj = pessoaRepository.findById(id).orElse(null); 
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName());
		}
		return obj;
	}
	
	/**
	 * Método responsável por deletar logicamente uma pessoa e seu endereço através do Id da pessoa	 
	 */
	@Transactional
	public void delete(Integer id) {
		Pessoa obj = findById(id);
		
		obj.setExcluido(true);
		obj.getEndereco().setExcluido(true);
		
		//Salvando a entidade Pessoa
		pessoaRepository.save(obj);
	}

	@Transactional
	public Pessoa update(Integer id, PessoaCreateDTO objPessoaDTO) {
		
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
