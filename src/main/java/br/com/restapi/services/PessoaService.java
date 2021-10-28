package br.com.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restapi.exception.RegistroNaoEncontradoException;
import br.com.restapi.model.Pessoa;
import br.com.restapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepo;

	public Pessoa findById(Long id) {
		return pessoaRepo.findById( id ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!")) ;
	}
	
	public List<Pessoa> findAll() {
		return pessoaRepo.findAll();
	}
	
	public Pessoa add(Pessoa pessoa) {
		return pessoaRepo.save(pessoa);
	}
	
	public Pessoa update(Pessoa pessoa) {
		Pessoa p = pessoaRepo.findById( pessoa.getId() ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!")) ;
		
		p.setNome(pessoa.getNome());
		p.setSobreNome(pessoa.getSobreNome());
		p.setEndereco(pessoa.getEndereco());
		p.setGenero(pessoa.getGenero());
		
		return pessoaRepo.save(p);
	}
	
	public void delete(Long id) {
		Pessoa p = pessoaRepo.findById( id ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!")) ;
		pessoaRepo.delete( p ) ;
	}
	
}
