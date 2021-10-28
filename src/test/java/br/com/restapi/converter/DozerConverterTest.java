package br.com.restapi.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.restapi.converter.mocks.MockPessoa;
import br.com.restapi.model.Pessoa;
import br.com.restapi.model.vo.PessoaVO;

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
    public void parserVOListToEntityListTest() {
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
    
}
