package inema.desafio.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inema.desafio.domains.Endereco;
import inema.desafio.domains.dtos.EnderecoCreateDTO;
import inema.desafio.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
		
	/**
	 * Método responsável por realizar o cadastro do Endereço 
	 * @return Endereco
	 */
	@Transactional
	public Endereco insert(EnderecoCreateDTO objEnderecoDTO) {
		
		Endereco obj = new Endereco(
				null,
				objEnderecoDTO.getLogradouro(),
				objEnderecoDTO.getNumero(),
				objEnderecoDTO.getBairro(),
				objEnderecoDTO.getCep(),
				objEnderecoDTO.getComplemento(),
				false
		);
		
		//Salvando a entidade Endereco
		enderecoRepository.save(obj);
		
		return obj;	
	}
	
	/**
	 * Método responsável por realizar a atualização do Endereço 
	 * @return Endereco
	 */
	@Transactional
	public Endereco update(Endereco objEndereco, EnderecoCreateDTO objEnderecoDTO) {
		
		//Populando a entidade de Endereco com os novos valores
		objEndereco.setLogradouro(objEnderecoDTO.getLogradouro());
		objEndereco.setNumero(objEnderecoDTO.getNumero());
		objEndereco.setBairro(objEnderecoDTO.getBairro());
		objEndereco.setCep(objEnderecoDTO.getCep());
		objEndereco.setComplemento(objEnderecoDTO.getComplemento());
		objEndereco.setExcluido(false);
		
		//Salvando a entidade Endereco
		enderecoRepository.save(objEndereco);
		
		return objEndereco;	
	}

}
