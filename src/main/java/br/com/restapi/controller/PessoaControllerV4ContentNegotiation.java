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

import br.com.restapi.model.vo.PessoaVO;
import br.com.restapi.services.PessoaService;

@RestController
@RequestMapping("/pessoa/v4")
public class PessoaControllerV4ContentNegotiation { 

	@Autowired
	PessoaService pessoaService;
	
	@GetMapping(value = "get/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO findById(@PathVariable("id") Long id) {
		return pessoaService.findById(id);  
	}

	@GetMapping(value = "/all", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PessoaVO> findAll() {
		return pessoaService.findAll();
	}
	
	@PostMapping(value = "/add", produces = {"application/json", "application/xml", "application/x-yaml"}
							   , consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO add(@RequestBody PessoaVO pessoa) {
		return pessoaService.add(pessoa);
	}

	@PutMapping(value = "/update", produces = {"application/json", "application/xml", "application/x-yaml"}
	   							 , consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		return pessoaService.update(pessoa);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pessoaService.delete(id); 
		return new  ResponseEntity<String>("Registro excluido. ID: " + id , HttpStatus.OK);
	}
	
}
