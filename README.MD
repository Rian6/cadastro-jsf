  README

README
======

Este repositório contém duas aplicações: `consulta-cnpj` e `integracao-cnpj`. Ambas as aplicações podem ser executadas individualmente. Além disso, há um arquivo Docker Compose para facilitar a execução do sistema como um todo.

Executando com Docker Compose
-----------------------------

Certifique-se de ter o Docker e o Docker Compose instalados em seu sistema. Em seguida, execute o seguinte comando na raiz do projeto:

    docker-compose up

Este comando iniciará ambas as aplicações e configurará os contêineres necessários.

Executando `consulta-cnpj` individualmente
------------------------------------------

1.  Navegue até o diretório `./consulta-cnpj`:

    cd consulta-cnpj

3.  Compile o projeto usando Maven:

    mvn clean package

5.  Em seguida, execute a aplicação Spring Boot:

    mvn spring-boot:run

Certifique-se de configurar as conexões com o banco de dados e ajustar as configurações no arquivo `application.properties`. As configurações relacionadas ao banco de dados são as seguintes:

    
    spring.datasource.url=${JDBC_URL}
    spring.datasource.username=${JDBC_USER}
    spring.datasource.password=${JDBC_PASS}
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    server.port=8081
        

Substitua `${JDBC_URL}`, `${JDBC_USER}`, e `${JDBC_PASS}` pelos valores apropriados.

Executando `integracao-cnpj` individualmente
--------------------------------------------

1.  Navegue até o diretório `./integracao-cnpj`:

    cd integracao-cnpj

3.  Compile o projeto usando Maven:

    mvn clean package

5.  Em seguida, execute o Wildfly para iniciar a aplicação:

    mvn wildfly:run

Lembre-se de configurar as conexões com o banco de dados conforme necessário.

Com essas instruções, você deve ser capaz de executar as aplicações individualmente ou usando o Docker Compose. Certifique-se de ajustar as configurações de banco de dados conforme necessário para o ambiente em que as aplicações estão sendo executadas.
