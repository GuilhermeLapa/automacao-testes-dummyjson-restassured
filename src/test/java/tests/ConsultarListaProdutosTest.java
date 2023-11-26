package tests;

import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class ConsultarListaProdutosTest extends Requisicoes {
	public static void consultarProdutos() {
		ConsultarListaProdutosTest.url= Utils.obterUrl(ConsultarListaProdutosTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarListaProdutosTest.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		
		ConsultarListaProdutosTest.response= request.get();
	}
}
