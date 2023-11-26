package tests;

import java.util.ArrayList;
import org.junit.Assert;
import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class ConsultarProdutoPorIdTest extends Requisicoes {
	protected static Object id;
	protected static String mensagemEsperada;
	
	public static void inicializarIdProduto(Object idProduto) {
		if(idProduto instanceof String) {
			ConsultarProdutoPorIdTest.id= (String) idProduto;
		}
		else if(idProduto instanceof Integer) {
			ConsultarProdutoPorIdTest.id= (int) idProduto;
		}
	}
	
	public static void consultarProdutoPorId() {
		ConsultarProdutoPorIdTest.url= Utils.obterUrl(ConsultarProdutoPorIdTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarProdutoPorIdTest.url + ConsultarProdutoPorIdTest.id);
		Header header= new Header("Content-Type", "application/json");
		//request.pathParam("id", ConsultarProdutoPorIdPage.id);
		request.header(header);
		
		ConsultarProdutoPorIdTest.response= request.get();
	}
	
	
	public static void verificarMensagemEsperada() {
		String mensagemResponse= ConsultarProdutoPorIdTest.response.getBody().jsonPath().get("message");
		boolean igual= false;
		
		for(String mensagem: ConsultarProdutoPorIdTest.mensagensEsperadas) {
			if(mensagemResponse.equals(mensagem)) {
				igual= true;
				break;
			}
		}
		
		Assert.assertTrue(igual);
	}
	
	public static void inicializarMensagemEsperada() {
		String mensagemEsperada= "Product with id '" + (String) ConsultarProdutoPorIdTest.id + "' not found";
		
		if(ConsultarProdutoPorIdTest.mensagensEsperadas == null) {
			ConsultarProdutoPorIdTest.mensagensEsperadas= new ArrayList<String>();
		}
		
		ConsultarProdutoPorIdTest.mensagensEsperadas.add(mensagemEsperada);
	}
}
