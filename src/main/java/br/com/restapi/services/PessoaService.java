package br.com.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restapi.converter.DozerConverter;
import br.com.restapi.exception.RegistroNaoEncontradoException;
import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;
import br.com.restapi.model.vo.v2.PessoaV2VO;
import br.com.restapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepo;

	public PessoaVO findById(Long id) {
		Pessoa pes = pessoaRepo.findById( id ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!"));
		return DozerConverter.parseObject(pes, PessoaVO.class);
	}
	
	public List<PessoaVO> findAll() {
		return DozerConverter.parseListObjects(pessoaRepo.findAll() , PessoaVO.class);
	}
	
	public PessoaVO add(PessoaVO pessoa) {
		Pessoa pes = DozerConverter.parseObject(pessoa, Pessoa.class);
		return DozerConverter.parseObject(pessoaRepo.save(pes), PessoaVO.class);
	}
	
	public PessoaV2VO addV2(PessoaV2VO pessoa) {
		Pessoa pes = DozerConverter.parseObject(pessoa, Pessoa.class);
		return DozerConverter.parseObject(pessoaRepo.save(pes), PessoaV2VO.class);
	}
	
	public PessoaVO update(PessoaVO pessoa) {
		Pessoa p = pessoaRepo.findById( pessoa.getId() ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!")) ;
		
		p.setNome(pessoa.getNome());
		p.setSobreNome(pessoa.getSobreNome());
		p.setEndereco(pessoa.getEndereco());
		p.setGenero(pessoa.getGenero());
		
		return DozerConverter.parseObject(pessoaRepo.save(p), PessoaVO.class);
	}
	
	public void delete(Long id) {
		Pessoa p = pessoaRepo.findById( id ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!")) ;
		pessoaRepo.delete( p ) ;
	}
	
}
