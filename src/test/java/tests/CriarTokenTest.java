package tests;

import org.json.simple.JSONObject;
import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class CriarTokenTest extends Requisicoes {
	public static void inicializarRequestBodyValor(Object valor, String nomeCampo) {
		if(CriarTokenTest.bodyRequest == null) {
			CriarTokenTest.bodyRequest= new JSONObject();
		}
		
		if (valor instanceof String) {
			CriarTokenTest.bodyRequest.put(nomeCampo, (String) valor);
		}
		else if (valor instanceof Integer) {
			CriarTokenTest.bodyRequest.put(nomeCampo, (Integer) valor);
		}
		else if(valor instanceof Boolean) {
			CriarTokenTest.bodyRequest.put(nomeCampo, (Boolean) valor);
		}
	}
	
	public static void criarToken() {
		CriarTokenTest.url= Utils.obterUrl(CriarTokenTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(CriarTokenTest.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.body(CriarTokenTest.bodyRequest.toJSONString());
		
		
		CriarTokenTest.response= request.post();
	}
}
