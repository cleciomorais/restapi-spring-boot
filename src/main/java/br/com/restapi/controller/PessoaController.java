package br.com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restapi.converter.DozerConverter;
import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;
import br.com.restapi.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController { 

	@Autowired
	PessoaService pessoaService;
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/{id}")
	public PessoaVO findById(@PathVariable("id") Long id) {
		Pessoa pes = pessoaService.findById(id); 
		return DozerConverter.parseObject(pes, PessoaVO.class);
	}

//	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/all")
	public List<PessoaVO> findAll() {
		return DozerConverter.parseListObjects(pessoaService.findAll() , PessoaVO.class);
	}
	
//	@RequestMapping(value = "/add", method = RequestMethod.POST, 
//					produces = MediaType.APPLICATION_JSON_VALUE, 
//					consumes = MediaType.APPLICATION_JSON_VALUE )
	@PostMapping("/add")
	public PessoaVO add(@RequestBody PessoaVO pessoa) {
		Pessoa pes = DozerConverter.parseObject(pessoa, Pessoa.class);
		return DozerConverter.parseObject( pessoaService.add(pes), PessoaVO.class);
	}
	
//	@RequestMapping(value = "/update", method = RequestMethod.PUT, 
//			produces = MediaType.APPLICATION_JSON_VALUE, 
//			consumes = MediaType.APPLICATION_JSON_VALUE )
	@PutMapping("/update")
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		Pessoa pes = DozerConverter.parseObject(pessoa, Pessoa.class);
		return DozerConverter.parseObject( pessoaService.update(pes), PessoaVO.class);
	}
	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pessoaService.delete(id); 
//		return ResponseEntity.ok().build();
		return new  ResponseEntity<String>("Registro excluido. ID: " + id , HttpStatus.OK);
	}
	
}
