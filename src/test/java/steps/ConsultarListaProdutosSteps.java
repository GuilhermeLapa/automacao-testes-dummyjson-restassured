package steps;

import io.cucumber.java.pt.Quando;
import tests.ConsultarListaProdutosTest;

public class ConsultarListaProdutosSteps {
	@Quando("consulto a lista de produtos")
	public static void consultoAListaDeProdutos() {
		ConsultarListaProdutosTest.consultarProdutos();
	}
}
