package br.com.restapi.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;

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
}
