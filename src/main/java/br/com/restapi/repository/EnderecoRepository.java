package br.com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restapi.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
