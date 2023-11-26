# language: pt
#encoding iso-8859-1

@Testar
Funcionalidade: GET - Buscar apenas um produto por id

Cenário: Validar Consultar Produto Por Id Sucesso
	Dado que possuo o id do produto <id>
	Quando consulto o produto por id
	Então verifico status code 200
	E verifico no body "$" que há o campo "id"
	E verifico que o valor do campo "id" é 1
	E verifico no body "$" que há o campo "title"
	E verifico que o valor do campo "title" é "iPhone 9"
	E verifico no body "$" que há o campo "description"
	E verifico que o valor do campo "description" é "An apple mobile which is nothing like apple"
	E verifico no body "$" que há o campo "price"
	E verifico que o valor do campo "price" é 549
	E verifico no body "$" que há o campo "discountPercentage"
	E verifico que o valor do campo "discountPercentage" é 12,96
	E verifico no body "$" que há o campo "rating"
	E verifico que o valor do campo "rating" é 4,69
	E verifico no body "$" que há o campo "stock"
	E verifico que o valor do campo "stock" é 94
	E verifico no body "$" que há o campo "brand"
	E verifico que o valor do campo "brand" é "Apple"
	E verifico no body "$" que há o campo "category"
	E verifico que o valor do campo "category" é "smartphones"
	E verifico no body "$" que há o campo "thumbnail"
	E verifico que o valor do campo "thumbnail" é "https://i.dummyjson.com/data/products/1/thumbnail.jpg"
	E verifico no body "$" que há o campo "images"
	E verifico que há uma lista no body "images"
	E verifico que o valor do campo "images[0]" é "https://i.dummyjson.com/data/products/1/1.jpg"
	Exemplos:
	| id |
	| 1  |

Cenário: Validar Produto Inexistente
	Dado que possuo o id invalido do produto <id>
	Quando consulto o produto por id
	Então verifico status code 404
	E verifico no body "$" que há o campo "message"
	E verifico a mensagem
	Exemplos:
	| id       |
	| abc      |
	| -3       |
	| a!$&_=-  |
