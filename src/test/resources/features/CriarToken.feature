# language: pt
#encoding iso-8859-1

@Testar
Funcionalidade: POST - Criação de token para Autenticação

Cenário: Validar Criar Token Sucesso
	Dado que possuo valor <username> para campo "username"
	E que possuo valor <password> para campo "password"
	Quando crio o token de autenticação
	Então verifico status code 200
	E verifico no body "$" que há o campo "id"
	E verifico que o valor do campo "id" é 15
	E verifico no body "$" que há o campo "username"
	E verifico que o valor do campo "username" é "kminchelle"
	E verifico no body "$" que há o campo "email"
	E verifico que o valor do campo "email" é "kminchelle@qq.com"
	E verifico no body "$" que há o campo "firstName"
	E verifico que o valor do campo "firstName" é "Jeanne"
	E verifico no body "$" que há o campo "lastName"
	E verifico que o valor do campo "lastName" é "Halvorson"
	E verifico no body "$" que há o campo "gender"
	E verifico que o valor do campo "gender" é "female"
	E verifico no body "$" que há o campo "image"
	E verifico que o valor do campo "image" é "https://robohash.org/autquiaut.png"
	E verifico no body "$" que há o campo "token"
	Exemplos:
	| username   | password |
	| kminchelle | 0lelplR  |

Cenário: Validar Obrigatoriedade Campo Username
	Dado que possuo valor "" para campo "username"
	E que possuo valor <password> para campo "password"
	Quando crio o token de autenticação
	Então verifico status code 400
	E verifico no body "$" que há o campo "message"
	E verifico que o valor do campo "message" é "Invalid credentials"
	Exemplos:
	| password |
	| 0lelplR  |

Cenário: Validar Obrigatoriedade Campo Password
	Dado que possuo valor <username> para campo "username"
	E que possuo valor "" para campo "password"
	Quando crio o token de autenticação
	Então verifico status code 400
	E verifico no body "$" que há o campo "message"
	E verifico que o valor do campo "message" é "Invalid credentials"
	Exemplos:
	| username   |
	| kminchelle |

Cenário: Validar Valores de Domínio Campo Username
	Dado que possuo valor <username> para campo "username"
	E que possuo valor <password> para campo "password"
	Quando crio o token de autenticação
	Então verifico status code 400
	E verifico no body "$" que há o campo "message"
	E verifico que o valor do campo "message" é "Invalid credentials"
	Exemplos:
	| username    | password |
	| naoExiste   | 0lelplR  |
	| !\@$%&()_=- | 0lelplR  |

Cenário: Validar Valores de Domínio Campo Password
	Dado que possuo valor <username> para campo "username"
	E que possuo valor <password> para campo "password"
	Quando crio o token de autenticação
	Então verifico status code 400
	E verifico no body "$" que há o campo "message"
	E verifico que o valor do campo "message" é "Invalid credentials"
	Exemplos:
	| username    | password    |
	| kminchelle  | naoExiste   |
	| kminchelle  | !\@$%&()_=- |
