package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import tests.ConsultarListaProdutosAutenticacaoTest;
import tests.CriarTokenTest;

public class ConsultarListaProdutosAutenticacaoSteps {
	@Dado("que estou autenticado com sucesso {} {}")
	public static void queEstouAutenticadoComSucesso(Object userName, Object password) {
		CriarTokenTest.inicializarRequestBodyValor(userName, "username");
		CriarTokenTest.inicializarRequestBodyValor(password, "password");
		CriarTokenTest.criarToken();
	}
	
	@Quando("consulto a lista de produtos com autenticação")
	public static void consultoAListaDeProdutosComAutenticacao() {
		ConsultarListaProdutosAutenticacaoTest.consultarListaDeProdutosComAutenticacao();
	}
	
	@Quando("consulto a lista de produtos sem autenticação")
	public static void consultoAListaDeProdutosSemAutenticacao() {
		ConsultarListaProdutosAutenticacaoTest.consultarListaDeProdutosSemAutenticacao();
	}
	
	@Quando("consulto a lista de produtos com token expirado {string} {string}")
	public static void consultoAListaDeProdutosComTokenExpirado(String userName, String password) {
		String tokenExpirado= null;
		
		ConsultarListaProdutosAutenticacaoTest.consultarListaDeProdutosComTokenExpirado(tokenExpirado);
	}
}
