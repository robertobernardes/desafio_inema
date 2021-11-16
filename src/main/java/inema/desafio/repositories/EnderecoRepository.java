package inema.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import inema.desafio.domains.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
