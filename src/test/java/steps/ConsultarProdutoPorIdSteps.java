package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import tests.ConsultarProdutoPorIdTest;

public class ConsultarProdutoPorIdSteps {
	@Dado("que possuo o id do produto {}")
	public static void quePossuoOIdDoProduto(Object idProduto) {
		ConsultarProdutoPorIdTest.inicializarIdProduto(idProduto);
	}
	
	@Dado("que possuo o id invalido do produto {}")
	public static void quePossuoOIdInvalidoDoProduto(Object idProduto) {
		ConsultarProdutoPorIdTest.inicializarIdProduto(idProduto);
		ConsultarProdutoPorIdTest.inicializarMensagemEsperada();
	}
	
	@Quando("consulto o produto por id")
	public static void consultoOProdutoPorId() {
		ConsultarProdutoPorIdTest.consultarProdutoPorId();
	}
	
	@E("verifico a mensagem")
	public static void verificoAMensagem() {
		ConsultarProdutoPorIdTest.verificarMensagemEsperada();
	}
}
