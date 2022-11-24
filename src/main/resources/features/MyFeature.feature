#language: pt
Funcionalidade: Teste com API Rest



  @teste
  Cenario: Testar requisição API Rest
    Dado que monto um body para a minha requisição
    Quando realizo o request para o endpoint
    Entao o status do retorno deve ser 200
