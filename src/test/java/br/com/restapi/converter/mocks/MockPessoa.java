package br.com.restapi.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.restapi.model.Endereco;
import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;
import br.com.restapi.model.vo.v3.EnderecoVO;
import br.com.restapi.model.vo.v3.PessoaV3VO;

public class MockPessoa {

	public Pessoa mockEntidade() {
    	return mockEntidade(0);
    }
    
    public PessoaVO mockVO() {
    	return mockVO(Integer.valueOf("0"));
    }
    
	public List<Pessoa> mockListaEntidade() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntidade(i));
        }
        return persons;
    }
 
	public List<PessoaVO> mockVOList() {
        List<PessoaVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
	
	private Pessoa mockEntidade(Integer number) {
		Pessoa entidade = new Pessoa();
		entidade.setId(number.longValue());
		entidade.setNome("MOCK_PESSOA" + number);
		entidade.setSobreNome("MOCK_SOBRENOME" + number);
		entidade.setEndereco("MOCK_ENDERECO" + number);
		entidade.setGenero( (number % 2) ==0 ? "M": "F" );
		return entidade;
	}
	
	private PessoaVO mockVO(Integer number) {
		PessoaVO vo = new PessoaVO();
		vo.setId(number.longValue());
		vo.setNome("MOCK_PESSOA" + number);
		vo.setSobreNome("MOCK_SOBRENOME" + number);
		vo.setEndereco("MOCK_ENDERECO" + number);
		vo.setGenero( (number % 2) ==0 ? "M": "F" );
		return vo;
	}
	
	/* MOCK PESSOA E VO V3 */
	
	
	public Pessoa mockEntidadeV3() {
	   	return mockEntidadeV3(0);
    }
    
    public PessoaV3VO mockV3VO() {
    	return mockV3VO(Integer.valueOf("0"));
    }
	 
    public List<Pessoa> mockListaEntidadeV3() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntidadeV3(i));
        }
        return persons;
    }
 
	public List<PessoaV3VO> mockV3VOList() {
        List<PessoaV3VO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockV3VO(i));
        }
        return persons;
    }
	
	private Pessoa mockEntidadeV3(Integer number) {
		Pessoa entidade = new Pessoa();
		entidade.setId(number.longValue());
		entidade.setNome("MOCK_PESSOA" + number);
		entidade.setSobreNome("MOCK_SOBRENOME" + number);
		entidade.setGenero( (number % 2) ==0 ? "M": "F" );
		
		Endereco ender = new Endereco();
		ender.setId(number.longValue());
		ender.setLogradouro("MOCK_LOGRADOURO" + number);
		ender.setCidade("MOCK_CIDADE" + number);
		ender.setBairro("MOCK_BAIRRO" + number);
		ender.setCep("MOCK_CEP");
		ender.setPessoa(entidade);
		
		List<Endereco> lista = new ArrayList<Endereco>();
		lista.add(ender);
		
		entidade.setEnderecos(lista);
		
		return entidade;
	}
	
	private PessoaV3VO mockV3VO(Integer number) {
		PessoaV3VO vo = new PessoaV3VO();
		vo.setId(number.longValue());
		vo.setNome("MOCK_PESSOA" + number);
		vo.setSobreNome("MOCK_SOBRENOME" + number);
		vo.setGenero( (number % 2) ==0 ? "M": "F" );
		
		EnderecoVO endVo = new EnderecoVO();
		endVo.setId(number.longValue());
		endVo.setLogradouro("MOCK_LOGRADOURO" + number);
		endVo.setBairro("MOCK_BAIRRO" + number);
		endVo.setCidade("MOCK_CIDADE" + number);
		endVo.setCep("MOCK_CEP");
		endVo.setPessoa(vo);
		
		List<EnderecoVO> lista = new ArrayList<EnderecoVO>();
		lista.add(endVo);
		
		vo.setEnderecos(lista);
		return vo;
	}
	
}
