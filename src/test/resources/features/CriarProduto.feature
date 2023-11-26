# language: pt
#encoding iso-8859-1

@Testar
Funcionalidade:  POST - Criação de produto

Cenário: Validar Criar Produto Sucesso
	Dado que possuo valor para o campo "title"
	E que possuo valor para o campo "description"
	E que possuo valor para o campo "price"
	E que possuo valor para o campo "discountPercentage"
	E que possuo valor para o campo "rating"
	E que possuo valor para o campo "stock"
	E que possuo valor para o campo "brand"
	E que possuo valor para o campo "category"
	E que possuo valor para o campo "thumbnail"
	Quando crio um novo produto
	Então verifico status code 200
	E verifico no body "$" que há o campo "id"
	E verifico que o valor do campo "id" é 101
	E verifico no body "$" que há o campo "title"
	E verifico que o valor do campo "title"
	E verifico no body "$" que há o campo "price"
	E verifico que o valor do campo "price"
	E verifico no body "$" que há o campo "stock"
	E verifico que o valor do campo "stock"
	E verifico no body "$" que há o campo "rating"
	E verifico que o valor do campo "rating"
	E verifico no body "$" que há o campo "thumbnail"
	E verifico que o valor do campo "thumbnail"
	E verifico no body "$" que há o campo "description"
	E verifico que o valor do campo "description"
	E verifico no body "$" que há o campo "brand"
	E verifico que o valor do campo "brand"
	E verifico no body "$" que há o campo "category"
	E verifico que o valor do campo "category"
