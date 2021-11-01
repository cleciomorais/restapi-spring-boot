package br.com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restapi.model.vo.v3.PessoaV3VO;
import br.com.restapi.services.PessoaService;

@RestController
@RequestMapping("/pessoa/v3")
public class PessoaControllerV3 { 

	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public PessoaV3VO findById(@PathVariable("id") Long id) {
		return pessoaService.findV3ById(id);  
	}

	@GetMapping("/all")
	public List<PessoaV3VO> findAll() {
		return pessoaService.findAllV3();
	}
	
	@PostMapping("/add")
	public PessoaV3VO add(@RequestBody PessoaV3VO pessoa) {
		return pessoaService.addV3(pessoa);
	}

//	
//	@PutMapping("/update")
//	public PessoaVO update(@RequestBody PessoaVO pessoa) {
//		return pessoaService.update(pessoa);
//	}
//	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pessoaService.delete(id); 
		return new  ResponseEntity<String>("Registro excluido. ID: " + id , HttpStatus.OK);
	}
	
}
