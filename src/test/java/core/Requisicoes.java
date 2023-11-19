package core;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import io.restassured.response.Response;

public class Requisicoes {
	protected static String url;
	protected static Response response;
	protected static JSONObject bodyRequest;
	protected static JSONObject bodyResponse;
	protected static ArrayList<String> mensagensEsperadas;
	
	public static String getToken() {
		if(response != null) {
			return response.getBody().jsonPath().getString("token");
		}
		else {
			return null;
		}
	}
	
	public static JSONObject obterBodyRequest() {
		return Requisicoes.bodyRequest;
	}
	
	public static JSONObject obterBodyResponse() {
		return Requisicoes.bodyResponse;
	}
}
