package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import tests.CriarProdutoTest;
import tests.CriarTokenTest;
import tests.TestarAplicacaoTest;
import util.Utils;

public class CriarProdutoSteps {
	@Quando("crio um novo produto")
	public static void crioUmNovoProduto() {
		CriarProdutoTest.criarProduto();
	}
	
	@E("verifico que o valor do campo {string}")
	public static void verificoQueOValorDoCampo(String nomeCampo) {
		TestarAplicacaoTest.verificarValorCampoString(nomeCampo, CriarProdutoTest.obterBodyRequest().get(nomeCampo).toString());
	}
	
	@Dado("que possuo valor para o campo {string}")
	public static void quePossuoValorParaCampoTitulo(String nomeCampo) {
		Object valor= null;
		
		switch (nomeCampo) {
		case "title":
			valor= Utils.gerarTituloProduto();
			break;
		case "description":
			valor= Utils.gerarDescricaoProduto();
			break;
		case "price":
			valor= Utils.gerarPrecoProduto();
			break;
		case "discountPercentage":
			valor= Utils.gerarPorcentagemDescontoProduto();
			break;
		case "rating":
			valor= Utils.gerarAvaliacaoProduto();
			break;
		case "stock":
			valor= Utils.gerarEstoqueProduto();
			break;
		case "brand":
			valor= Utils.gerarMarcaProduto();
			break;
		case "category":
			valor= Utils.gerarCategoriaProduto();
			break;
		case "thumbnail":
			valor= Utils.gerarMiniaturaProduto();
			break;
		default:
			break;
		}
		
		CriarTokenTest.inicializarRequestBodyValor(valor, nomeCampo);
	}
}
