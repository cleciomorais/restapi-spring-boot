package br.com.restapi.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.restapi.converter.mocks.MockPessoa;
import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;
import br.com.restapi.model.vo.v3.PessoaV3VO;

public class DozerConverterTest {

	MockPessoa inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPessoa();
    }

    @Test
    public void parseEntityToVOTest() {
        PessoaVO output = DozerConverter.parseObject(inputObject.mockEntidade(), PessoaVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("MOCK_PESSOA0", output.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", output.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO0", output.getEndereco());
        Assert.assertEquals("M", output.getGenero());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PessoaVO> outputList = DozerConverter.parseListObjects(inputObject.mockListaEntidade(), PessoaVO.class);
        PessoaVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("MOCK_PESSOA0", outputZero.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", outputZero.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO0", outputZero.getEndereco());
        Assert.assertEquals("M", outputZero.getGenero());
        
        PessoaVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("MOCK_PESSOA7", outputSeven.getNome());
        Assert.assertEquals("MOCK_SOBRENOME7", outputSeven.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO7", outputSeven.getEndereco());
        Assert.assertEquals("F", outputSeven.getGenero());
        
        PessoaVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("MOCK_PESSOA12", outputTwelve.getNome());
        Assert.assertEquals("MOCK_SOBRENOME12", outputTwelve.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO12", outputTwelve.getEndereco());
        Assert.assertEquals("M", outputTwelve.getGenero());
    }

    @Test
    public void parseVOToEntityTest() {
    	Pessoa output = DozerConverter.parseObject(inputObject.mockVO(), Pessoa.class);
    	 Assert.assertEquals(Long.valueOf(0L), output.getId());
         Assert.assertEquals("MOCK_PESSOA0", output.getNome());
         Assert.assertEquals("MOCK_SOBRENOME0", output.getSobreNome());
         Assert.assertEquals("MOCK_ENDERECO0", output.getEndereco());
         Assert.assertEquals("M", output.getGenero());
    }

    @Test
    public void parseVOListToEntityListTest() {
        List<Pessoa> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Pessoa.class);
        Pessoa outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("MOCK_PESSOA0", outputZero.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", outputZero.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO0", outputZero.getEndereco());
        Assert.assertEquals("M", outputZero.getGenero());
        
        Pessoa outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("MOCK_PESSOA7", outputSeven.getNome());
        Assert.assertEquals("MOCK_SOBRENOME7", outputSeven.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO7", outputSeven.getEndereco());
        Assert.assertEquals("F", outputSeven.getGenero());
        
        
        Pessoa outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("MOCK_PESSOA12", outputTwelve.getNome());
        Assert.assertEquals("MOCK_SOBRENOME12", outputTwelve.getSobreNome());
        Assert.assertEquals("MOCK_ENDERECO12", outputTwelve.getEndereco());
        Assert.assertEquals("M", outputTwelve.getGenero());
    }
    
    /* PESSOA V3 CONVERTER*/
    
    @Test
    public void parseEntityToV3VoTest() {
    	Pessoa entidade = inputObject.mockEntidadeV3();
        PessoaV3VO output = DozerConverter.parseObject(entidade, PessoaV3VO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("MOCK_PESSOA0", output.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", output.getSobreNome());
        Assert.assertEquals(entidade.getEnderecos().size(), output.getEnderecos().size());
        Assert.assertEquals(entidade.getEnderecos().get(0).getId(), output.getEnderecos().get(0).getId());
        Assert.assertEquals(entidade.getEnderecos().get(0).getPessoa().getId(), output.getEnderecos().get(0).getPessoa().getId());
        
        Assert.assertEquals("M", output.getGenero());
    }
    
    @Test
    public void parseV3VOToEntityTest() {
    	PessoaV3VO pesV3Vo = inputObject.mockV3VO();
    	Pessoa output = DozerConverter.parseObject(pesV3Vo, Pessoa.class);
    	Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("MOCK_PESSOA0", output.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", output.getSobreNome());
        Assert.assertEquals("M", output.getGenero());
        Assert.assertEquals(pesV3Vo.getEnderecos().size(), output.getEnderecos().size());
        Assert.assertEquals(pesV3Vo.getEnderecos().get(0).getId(), output.getEnderecos().get(0).getId());
        Assert.assertEquals(pesV3Vo.getEnderecos().get(0).getPessoa().getId(), output.getEnderecos().get(0).getPessoa().getId());
    }
    
    @Test
    public void parseEntityListToVOV3ListTest() {
    	List<Pessoa> entidadeList = inputObject.mockListaEntidadeV3();
        List<PessoaV3VO> outputList = DozerConverter.parseListObjects(entidadeList, PessoaV3VO.class);
        
        PessoaV3VO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("MOCK_PESSOA0", outputZero.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", outputZero.getSobreNome());
        Assert.assertEquals("M", outputZero.getGenero());
        Assert.assertEquals(entidadeList.get(0).getEnderecos().size(), outputZero.getEnderecos().size());
        Assert.assertEquals(entidadeList.get(0).getEnderecos().get(0).getId(), outputZero.getEnderecos().get(0).getId());
        Assert.assertEquals(entidadeList.get(0).getEnderecos().get(0).getPessoa().getId(), outputZero.getEnderecos().get(0).getPessoa().getId());
        
        
        PessoaV3VO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("MOCK_PESSOA7", outputSeven.getNome());
        Assert.assertEquals("MOCK_SOBRENOME7", outputSeven.getSobreNome());
        Assert.assertEquals("F", outputSeven.getGenero());
        Assert.assertEquals(entidadeList.get(7).getEnderecos().size(), outputSeven.getEnderecos().size());
        Assert.assertEquals(entidadeList.get(7).getEnderecos().get(0).getId(), outputSeven.getEnderecos().get(0).getId());
        Assert.assertEquals(entidadeList.get(7).getEnderecos().get(0).getPessoa().getId(), outputSeven.getEnderecos().get(0).getPessoa().getId());
        
        
        PessoaV3VO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("MOCK_PESSOA12", outputTwelve.getNome());
        Assert.assertEquals("MOCK_SOBRENOME12", outputTwelve.getSobreNome());
        Assert.assertEquals("M", outputTwelve.getGenero());
        Assert.assertEquals(entidadeList.get(12).getEnderecos().size(), outputTwelve.getEnderecos().size());
        Assert.assertEquals(entidadeList.get(12).getEnderecos().get(0).getId(), outputTwelve.getEnderecos().get(0).getId());
        Assert.assertEquals(entidadeList.get(12).getEnderecos().get(0).getPessoa().getId(), outputTwelve.getEnderecos().get(0).getPessoa().getId());
        
    }
    
    @Test
    public void parseV3VOListToEntityListTest() {
    	List<PessoaV3VO> voV3List = inputObject.mockV3VOList();
        List<Pessoa> outputList = DozerConverter.parseListObjects(voV3List, Pessoa.class);
        
        Pessoa outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("MOCK_PESSOA0", outputZero.getNome());
        Assert.assertEquals("MOCK_SOBRENOME0", outputZero.getSobreNome());
        Assert.assertEquals("M", outputZero.getGenero());
        Assert.assertEquals(voV3List.get(0).getEnderecos().size(), outputZero.getEnderecos().size());
        Assert.assertEquals(voV3List.get(0).getEnderecos().get(0).getId(), outputZero.getEnderecos().get(0).getId());
        Assert.assertEquals(voV3List.get(0).getEnderecos().get(0).getPessoa().getId(), outputZero.getEnderecos().get(0).getPessoa().getId());
        
        
        Pessoa outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("MOCK_PESSOA7", outputSeven.getNome());
        Assert.assertEquals("MOCK_SOBRENOME7", outputSeven.getSobreNome());
        Assert.assertEquals("F", outputSeven.getGenero());
        Assert.assertEquals(voV3List.get(7).getEnderecos().size(), outputSeven.getEnderecos().size());
        Assert.assertEquals(voV3List.get(7).getEnderecos().get(0).getId(), outputSeven.getEnderecos().get(0).getId());
        Assert.assertEquals(voV3List.get(7).getEnderecos().get(0).getPessoa().getId(), outputSeven.getEnderecos().get(0).getPessoa().getId());
        
        
        Pessoa outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("MOCK_PESSOA12", outputTwelve.getNome());
        Assert.assertEquals("MOCK_SOBRENOME12", outputTwelve.getSobreNome());
        Assert.assertEquals("M", outputTwelve.getGenero());
        Assert.assertEquals(voV3List.get(12).getEnderecos().size(), outputTwelve.getEnderecos().size());
        Assert.assertEquals(voV3List.get(12).getEnderecos().get(0).getId(), outputTwelve.getEnderecos().get(0).getId());
        Assert.assertEquals(voV3List.get(12).getEnderecos().get(0).getPessoa().getId(), outputTwelve.getEnderecos().get(0).getPessoa().getId());
    }
    
}
