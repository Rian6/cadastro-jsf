<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README</title>
</head>

<body>

    <h1>README</h1>

    <p>Este repositório contém duas aplicações: <code>consulta-cnpj</code> e <code>integracao-cnpj</code>. Ambas as aplicações podem ser executadas individualmente. Além disso, há um arquivo Docker Compose para facilitar a execução do sistema como um todo.</p>

    <h2>Executando com Docker Compose</h2>

    <p>Certifique-se de ter o Docker e o Docker Compose instalados em seu sistema. Em seguida, execute o seguinte comando na raiz do projeto:</p>

    <pre><code>docker-compose up</code></pre>

    <p>Este comando iniciará ambas as aplicações e configurará os contêineres necessários.</p>

    <h2>Executando <code>consulta-cnpj</code> individualmente</h2>

    <ol>
        <li>Navegue até o diretório <code>./consulta-cnpj</code>:</li>
        <pre><code>cd consulta-cnpj</code></pre>

        <li>Compile o projeto usando Maven:</li>
        <pre><code>mvn clean package</code></pre>

        <li>Em seguida, execute a aplicação Spring Boot:</li>
        <pre><code>mvn spring-boot:run</code></pre>
    </ol>

    <p>Certifique-se de configurar as conexões com o banco de dados e ajustar as configurações no arquivo <code>application.properties</code>. As configurações relacionadas ao banco de dados são as seguintes:</p>

    <pre><code>
spring.datasource.url=${JDBC_URL}
spring.datasource.username=${JDBC_USER}
spring.datasource.password=${JDBC_PASS}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8081
    </code></pre>

    <p>Substitua <code>${JDBC_URL}</code>, <code>${JDBC_USER}</code>, e <code>${JDBC_PASS}</code> pelos valores apropriados.</p>

    <h2>Executando <code>integracao-cnpj</code> individualmente</h2>

    <ol>
        <li>Navegue até o diretório <code>./integracao-cnpj</code>:</li>
        <pre><code>cd integracao-cnpj</code></pre>

        <li>Compile o projeto usando Maven:</li>
        <pre><code>mvn clean package</code></pre>

        <li>Em seguida, execute o Wildfly para iniciar a aplicação:</li>
        <pre><code>mvn wildfly:run</code></pre>
    </ol>

    <p>Lembre-se de configurar as conexões com o banco de dados conforme necessário.</p>

    <p>Com essas instruções, você deve ser capaz de executar as aplicações individualmente ou usando o Docker Compose. Certifique-se de ajustar as configurações de banco de dados conforme necessário para o ambiente em que as aplicações estão sendo executadas.</p>

</body>

</html>
