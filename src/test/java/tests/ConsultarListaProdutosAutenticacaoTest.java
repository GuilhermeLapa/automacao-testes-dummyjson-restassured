package tests;

import java.util.ArrayList;
import java.util.List;
import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class ConsultarListaProdutosAutenticacaoTest extends Requisicoes {
	public static void consultarListaDeProdutosComAutenticacao() {
		String token= ConsultarListaProdutosAutenticacaoTest.getToken();
		ConsultarListaProdutosAutenticacaoTest.url= Utils.obterUrl(ConsultarListaProdutosAutenticacaoTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarListaProdutosAutenticacaoTest.url);
		List<Header> headerLista= new ArrayList<Header>();
		headerLista.add(new Header("Content-Type", "application/json"));
		headerLista.add(new Header("Authorization", "Bearer "+token));
		Headers headers= new Headers(headerLista);
		request.headers(headers);
		
		ConsultarListaProdutosAutenticacaoTest.response= request.get();
	}
	
	public static void consultarListaDeProdutosSemAutenticacao() {
		ConsultarListaProdutosAutenticacaoTest.url= Utils.obterUrl(ConsultarListaProdutosAutenticacaoTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarListaProdutosAutenticacaoTest.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		
		ConsultarListaProdutosAutenticacaoTest.response= request.get();
	}
	
	public static void consultarListaDeProdutosComTokenExpirado(String tokenExpirado) {
		ConsultarListaProdutosAutenticacaoTest.url= Utils.obterUrl(ConsultarListaProdutosAutenticacaoTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarListaProdutosAutenticacaoTest.url);
		List<Header> headerLista= new ArrayList<Header>();
		headerLista.add(new Header("Content-Type", "application/json"));
		headerLista.add(new Header("Authorization", "Bearer "+tokenExpirado));
		Headers headers= new Headers(headerLista);
		request.headers(headers);
		
		ConsultarListaProdutosAutenticacaoTest.response= request.get();
	}
}
