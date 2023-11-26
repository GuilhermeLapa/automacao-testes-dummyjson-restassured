package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import tests.ConsultarListaUsuariosTest;

public class ConsultarListaUsuariosSteps {
	@Quando("consulto a lista de usuários")
	public static void consultoAListaDeUsuarios() {
		ConsultarListaUsuariosTest.consultarListaUsuarios();
	}
	
	@E("verifico que o valor do campo {string} é {float}")
	public static void verificoQueOValorDoCampoE(String jsonPathCampo, float valorEsperado) {
		ConsultarListaUsuariosTest.verificarValorCampoFloat(jsonPathCampo, valorEsperado);
	}
	
	@E("verifico que há uma lista no body {string}")
	public static void verificoQueHaUmaListaNoBody(String jsonPath) {
		ConsultarListaUsuariosTest.verificarQueHaListaNoBody(jsonPath);
	}
}
