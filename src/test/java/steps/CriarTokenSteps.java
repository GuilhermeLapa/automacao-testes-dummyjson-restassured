package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import tests.CriarTokenTest;

public class CriarTokenSteps {
	@Dado("que possuo valor {} para campo {string}")
	public static void quePossuoValorParaCampo(Object valor, String nomeCampo) {
		CriarTokenTest.inicializarRequestBodyValor(valor, nomeCampo);
	}
	
	@Quando("crio o token de autenticação")
	public static void crioOTokenDeAutenticacao() {
		CriarTokenTest.criarToken();
	}
}
