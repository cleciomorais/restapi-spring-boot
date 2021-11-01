package br.com.restapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restapi.converter.DozerConverter;
import br.com.restapi.exception.RegistroNaoEncontradoException;
import br.com.restapi.model.Endereco;
import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;
import br.com.restapi.model.vo.v2.PessoaV2VO;
import br.com.restapi.model.vo.v3.PessoaV3VO;
import br.com.restapi.repository.EnderecoRepository;
import br.com.restapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepo;
	
	@Autowired
	EnderecoRepository enderecoRepo;

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
	
	
	/* PESSOA V3 METHODS */
	
	public List<PessoaV3VO> findAllV3() {
		return DozerConverter.parseListObjects(pessoaRepo.findAll() , PessoaV3VO.class);
	}
	
	public PessoaV3VO findV3ById(Long id) {
		Pessoa pes = pessoaRepo.findById( id ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!"));
		return DozerConverter.parseObject(pes, PessoaV3VO.class);
	}
	
	public PessoaV3VO addV3(PessoaV3VO pessoa) {
		Pessoa pes = DozerConverter.parseObject(pessoa, Pessoa.class);
		
		List<Endereco> enderecos = pes.getEnderecos(); 
		pes.setEnderecos( new ArrayList<Endereco>());
		
		for (Endereco endereco : enderecos) {
			endereco.setPessoa(pes);
			pes.getEnderecos().add(endereco);
		}
		
		return DozerConverter.parseObject(pessoaRepo.save(pes), PessoaV3VO.class);
	}
	
	public PessoaV3VO updateV3(PessoaV3VO pessoa) {
		Pessoa entidade = pessoaRepo.findById( pessoa.getId() ).orElseThrow(() -> new  RegistroNaoEncontradoException("Registro não encontrado!")) ;
		
		entidade.setNome(pessoa.getNome());
		entidade.setSobreNome(pessoa.getSobreNome());
		entidade.setGenero(pessoa.getGenero());
		entidade.setDtNascimento(pessoa.getDtNascimento());
		
		return DozerConverter.parseObject(pessoaRepo.save(entidade), PessoaV3VO.class);
	}
	
}
