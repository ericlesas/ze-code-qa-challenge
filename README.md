## QA Challenge

### Sobre o desenvolvimento
Para o desenvolvimento dos testes foi utilizado o **Maven** para gerenciar as dependências do projeto,
a linguagem de programação **java** versão 1.8 para codificação, 
**JUnit** para execução de métodos, e o **Selenium** para fazer conexão com a web.
### Instruções para análise do desafio

##### 1. Inserir as seguintes depêndencias no arquivo pom.xml 
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.3.0</version>
        </dependency>
        
##### 2. A execução dos testes deverá ser feita nas seguintes classes:

* [Ui Automation](https://github.com/ericlesas/ze-code-qa-challenge/blob/master/src/test/java/ui_automation/suites/BuyBeer.java)
* [Api Automation](https://github.com/ericlesas/ze-code-qa-challenge/blob/master/src/test/java/api_automation/suites/GetWeather.java)

#### Cenários críticos:
 * [critical-flows](https://github.com/ericlesas/ze-code-qa-challenge/blob/master/critical-flows.md)
 
 Obs: O fluxo validado no teste de interface foi **Finalizar Compra** 