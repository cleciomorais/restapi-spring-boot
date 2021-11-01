package br.com.restapi.model.vo.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","nome", "descricao_endereco", "cidade", "bairro", "cep"})
public class EnderecoVO implements Serializable {

	private static final long serialVersionUID = -2547093446943785800L;

	private Long id;

	@JsonProperty("descricao_endereco")
	private String logradouro;
	
	private String cidade;
	
	private String bairro;
	
	private String cep;
	
	@JsonIgnoreProperties({"enderecos"})
	private PessoaV3VO pessoa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public PessoaV3VO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaV3VO pessoa) {
		this.pessoa = pessoa;
	}

}
