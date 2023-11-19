package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import tests.TestarAplicacaoTest;

public class TestarAplicacaoSteps {
	@Quando("consulto o status da aplicação")
	public static void consultoOStatusDaAplicacao() {
		TestarAplicacaoTest.consultarStatusAplicacao();
	}
	
	@Então("verifico status code {int}")
	public static void verificoStatusCode(int statusCodeEsperado) {
		TestarAplicacaoTest.verificarStatusCode(statusCodeEsperado);
	}
	
	@E("verifico no body {string} que há o campo {string}")
	public static void verificoNoBodyQueHaOCampo(String jsonPath, String nomeCampo) {
		TestarAplicacaoTest.verificarExisteCampo(jsonPath, nomeCampo);
	}
	
	@E("verifico que o valor do campo {string} é {string}")
	public static void verificoQueOValorDoCampoE(String jsonPathCampo, String valorEsperado) {
		TestarAplicacaoTest.verificarValorCampoString(jsonPathCampo, valorEsperado);
	}
}
