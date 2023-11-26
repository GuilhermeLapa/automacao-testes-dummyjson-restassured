package tests;

import org.junit.Assert;
import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class ConsultarListaUsuariosTest extends Requisicoes {
	public static void consultarListaUsuarios() {
		ConsultarListaUsuariosTest.url= Utils.obterUrl(ConsultarListaUsuariosTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarListaUsuariosTest.url);
		ConsultarListaUsuariosTest.response= request.get();
	}
	
	public static void verificarValorCampoFloat(String jsonPathCampo, float valorEsperado) {
		float valorResponse= ConsultarListaUsuariosTest.response.getBody().jsonPath().getFloat(jsonPathCampo);
		Assert.assertTrue(valorEsperado == valorResponse);
	}
	
	public static void verificarQueHaListaNoBody(String jsonPath) {
		Assert.assertTrue(ConsultarListaUsuariosTest.response.getBody().jsonPath().getList(jsonPath).size() > 1);
	}
}
