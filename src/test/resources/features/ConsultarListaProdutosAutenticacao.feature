# language: pt
#encoding iso-8859-1

@Testar
Funcionalidade: GET - Buscar produtos com autenticação

Cenário: Validar Consultar Lista de Produtos com Autenticação Sucesso
	Dado que estou autenticado com sucesso <username> <password>
	Quando consulto a lista de produtos com autenticação
	Então verifico status code 200
	E verifico que há uma lista no body "products"
	E verifico no body "$" que há o campo "products"
	E verifico no body "products[0]" que há o campo "id"
	E verifico que o valor do campo "products[0].id" é 1
	E verifico no body "products[0]" que há o campo "title"
	E verifico que o valor do campo "products[0].title" é "iPhone 9"
	E verifico no body "products[0]" que há o campo "description"
	E verifico que o valor do campo "products[0].description" é "An apple mobile which is nothing like apple"
	E verifico no body "products[0]" que há o campo "price"
	E verifico que o valor do campo "products[0].price" é 549
	E verifico no body "products[0]" que há o campo "discountPercentage"
	E verifico que o valor do campo "products[0].discountPercentage" é 12,96
	E verifico no body "products[0]" que há o campo "rating"
	E verifico que o valor do campo "products[0].rating" é 4,69
	E verifico no body "products[0]" que há o campo "stock"
	E verifico que o valor do campo "products[0].stock" é 94
	E verifico no body "products[0]" que há o campo "brand"
	E verifico que o valor do campo "products[0].brand" é "Apple"
	E verifico no body "products[0]" que há o campo "category"
	E verifico que o valor do campo "products[0].category" é "smartphones"
	E verifico no body "products[0]" que há o campo "thumbnail"
	E verifico que o valor do campo "products[0].thumbnail" é "https://i.dummyjson.com/data/products/1/thumbnail.jpg"
	E verifico no body "products[0]" que há o campo "images"
	E verifico que há uma lista no body "products.images"
	E verifico que o valor do campo "products[0].images[0]" é "https://i.dummyjson.com/data/products/1/1.jpg"
	Exemplos:
	| username   | password |
	| kminchelle | 0lelplR  |

Cenário: Validar Problema na Autenticação Status 403
	Quando consulto a lista de produtos sem autenticação
	Então verifico status code 403
	E verifico no body "$" que há o campo "message"
	E verifico que o valor do campo "message" é "Authentication Problem"

Cenário: Validar Problema na Autenticação Status 401
	Quando consulto a lista de produtos com token expirado "<username>" "<password>"
	Então  verifico status code 401
	E verifico no body "$" que há o campo "name"
	E verifico que o valor do campo "name" é "JsonWebTokenError"
	E verifico no body "$" que há o campo "message"
	E verifico que o valor do campo "message" é "Invalid/Expired Token!"
	Exemplos:
	| username   | password |
	| kminchelle | 0lelplR  |
