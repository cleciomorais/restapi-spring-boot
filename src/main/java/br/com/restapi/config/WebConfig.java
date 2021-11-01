package br.com.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/*
	 * CONFIGURAÇÃO PARA PASSAR A EXTENÇÃO DESEJADA NA URL. EX:
	 * http://localhost:8080/pessoa/v4/all.xml ou /all.json
	 */
//  @Override
//  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    configurer.favorParameter(false)
//	  			.ignoreAcceptHeader(false)
//	  			.defaultContentType(MediaType.APPLICATION_JSON)
//	  			.mediaType("xml", MediaType.APPLICATION_XML)
//	  			.mediaType("json", MediaType.APPLICATION_JSON);
//  }

	/*
	 * CONFIGURAÇÃO PARA PASSAR A EXTENÇÃO DESEJADA VIA PARAMETRO NA URL. EX:
	 * http://localhost:8080/pessoa/v4/all?media_type=json ou /all?media_type=xml
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
			.favorPathExtension(false)
			.favorParameter(true)
			.parameterName("media_type")
			.ignoreAcceptHeader(true)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	
//	/*
//	 * CONFIGURAÇÃO PARA PASSAR A EXTENÇÃO DESEJADA VIA PARAMETRO DO HEADER DA MENSAGEM HTML:
//	 * EX: http://localhost:8080/pessoa/v4/all
//	 * KEY   = Accept
//	 * VALUE = application/json ou application/xml 
//	 * 
//	 */
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer
//			.favorPathExtension(false)
//			.favorParameter(false)
//			.ignoreAcceptHeader(false)
//			.defaultContentType(MediaType.APPLICATION_JSON)
//			.mediaType("xml", MediaType.APPLICATION_XML)
//			.mediaType("json", MediaType.APPLICATION_JSON);
//	}
	
}