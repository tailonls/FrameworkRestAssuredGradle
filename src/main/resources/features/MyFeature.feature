#language: pt
Funcionalidade: Teste com API Rest



  @teste
  Cenario: Testar requisição API Rest
    Dado que monto um body para a minha requisição
    Quando realizo o request para o endpoint
    E o status do retorno deve ser 201
