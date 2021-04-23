package br.com.treino.filme.controller;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.treino.filmes.controller.FilmeController;
import br.com.treino.filmes.model.Filme;
import br.com.treino.filmes.service.FilmeService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class FilmeControllerTest {

	
	
	@Autowired
	private FilmeController filmeController;
	
	@MockBean
	private FilmeService filmeService;
	
	
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.filmeController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarFilme() {
		
		when(this.filmeService.obterFilme(1L))
		.thenReturn(new Filme());
		
		given()
		    .accept(ContentType.JSON)
		.when()
		    .get("/filmes/{codigo}", 1L)
		.then()
		     .statusCode(HttpStatus.OK.value());
		
		
		
	}
	
	@Test
	public void deveRetornarNaoencontrado_QuandoBuscarFilme() {
		
		when(this.filmeService.obterFilme(5L))
		.thenReturn(null);
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/filmes/{codigo}", 5L)
		.then().statusCode(HttpStatus.NOT_FOUND.value());
		
		
	}
	
	@Test
	public void deveRetornarBadRequest_QuandoBuscarFilme() {
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/filmes/{codigo}", -1L)
		.then()
		.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.filmeService, never()).obterFilme(-1L);
		
	}
	
	
}