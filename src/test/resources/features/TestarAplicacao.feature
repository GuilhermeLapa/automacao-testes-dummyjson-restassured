# language: pt
#encoding iso-8859-1

@Testar
Funcionalidade: GET - Testar Status Aplicação

Cenário: Validar Teste de Aplicação Sucesso
	Quando consulto o status da aplicação
	Então verifico status code 200
	E verifico no body "$" que há o campo "status"
	E verifico que o valor do campo "status" é "ok"
	E verifico no body "$" que há o campo "method"
	E verifico que o valor do campo "method" é "GET"
