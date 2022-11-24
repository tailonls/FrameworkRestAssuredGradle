# FrameworkRestAssuredGradle

Framework Selenium para automação de testes (Java + Gradle + Cucumber + RestAssured)


## Requisitos para rodar testes em uma máquina

- Java JDK (De preferência versão mais atualizada).
- Variáveis de ambiente JAVA_HOME e PATH configuradas.
- Alguma IDE (Eclipse, IntelliJ, etc) que facilite nos testes.

## Para rodar um teste:

1 - Após ter instalado os programas e configurado as variáveis de ambiente;
2 - Baixe o projeto e vá até a pasta */test/* e verifique as classes de Teste;
3 - Essas são as classes que iniciam os testes, para saber qual teste ela irá rodar verifique a propriedade **tags** 	  
> Ex.: tags = "@teste"

4 - Busque dentre os arquivos de feature na pasta */resources/features/* qual delas tem essa tag;
5 - Rode a classe de teste com o botão direito do mouse -> Run As -> JUnit Test;
6 - Após terminado o teste vá até a pasta *Reports/* e abra o arquivo .html no navegador, esse relatório tem o passo a passo do que aconteceu no teste.
