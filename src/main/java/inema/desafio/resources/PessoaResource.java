package inema.desafio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import inema.desafio.domains.Pessoa;
import inema.desafio.domains.dtos.PessoaCreateDTO;
import inema.desafio.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> listPessoas = pessoaService.findAll();
		return ResponseEntity.ok().body(listPessoas);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PessoaCreateDTO objDto) {
		Pessoa obj = pessoaService.insert(objDto);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> find(@PathVariable Integer id) {		
		Pessoa obj = pessoaService.findById(id);
		return ResponseEntity.ok().body(obj);				
	}
	
}
