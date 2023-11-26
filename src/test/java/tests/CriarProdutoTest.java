package tests;

import core.Requisicoes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class CriarProdutoTest extends Requisicoes {
	public static void criarProduto() {
		CriarProdutoTest.url= Utils.obterUrl(CriarProdutoTest.class.getSimpleName());
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(CriarProdutoTest.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.body(CriarProdutoTest.bodyRequest.toJSONString());
		
		CriarProdutoTest.response= request.post();
	}
}
