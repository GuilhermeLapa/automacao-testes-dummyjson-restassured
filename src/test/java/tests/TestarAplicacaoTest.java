package tests;

import org.junit.Assert;
import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class TestarAplicacaoTest extends Requisicoes {
	public static void consultarStatusAplicacao() {
		TestarAplicacaoTest.url= Utils.obterUrl(TestarAplicacaoTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(TestarAplicacaoTest.url);
		TestarAplicacaoTest.response= request.get();
	}
	
	public static void verificarStatusCode(int statusCodeEsperado) {
		Assert.assertTrue(statusCodeEsperado == TestarAplicacaoTest.response.getStatusCode());
	}
	
	public static void verificarExisteCampo(String jsonPath, String nomeCampo) {
		Assert.assertTrue(TestarAplicacaoTest.response.getBody().jsonPath().get(jsonPath).toString().contains(nomeCampo));
	}
	
	public static void verificarValorCampoString(String jsonPathCampo, String valorEsperado) {
		String valorResponse= TestarAplicacaoTest.response.getBody().jsonPath().getString(jsonPathCampo);
		Assert.assertEquals(valorEsperado, valorResponse);
	}
}
