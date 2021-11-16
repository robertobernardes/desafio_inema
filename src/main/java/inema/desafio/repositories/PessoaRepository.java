package inema.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import inema.desafio.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
