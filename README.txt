Instru��es sobre o sistema Candidato
application.properties -> est� configurado para o Oracle
Configura��es para MySQL
Maven Depend�ncia
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

configura��o do application.properties
# usu�rio e senha de conex�o com o banco de dados
spring.datasource.username=root
spring.datasource.password=root
# url de conex�o do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&rewriteBatchedStatements=true&useSSL=false&useUnicode=yes&characterEncoding=UTF-8&useLegacyDatetimeCode=true&createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
# apontamos para o JPA e Hibernate qual � o Dialeto do banco de dados
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
# deixamos o hibernate respons�vel por ler nossas entidades e criar as tabelas do nosso banco de dados automaticamente
spring.jpa.hibernate.ddl-auto=create
# configura��o do Hibernate para reconhecer o nome de tabelas em caixa alta
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
# configura��es de log
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true

Chamadas Rest da -> CandidatoCartaoController
Get ->http://localhost:8081/api/v1/candidatos/ ou http://localhost:8081/api/v1/candidatos/{documento}

Get ->http://localhost:8081/api/v1/cartoes/ ou http://localhost:8081/api/v1/cartoes/{numero}

Post ->http://localhost:8081/api/v1/candidatos/
{
   
   "nome": "Marta",
   "vaga": "Desenvolvedor5",
   "endereco": "Rua Jose Saldanha",
   "telefone": "11960653610",
   "documento": 181767120
}

Post ->http://localhost:8081/api/v1/cartoes/
{
  
   "nomePortador": "Carla",
   "numero": 508900027175,
   "dataVenc": "02-05-21",
   "codValidade": "466"  
}


PUT ->http://localhost:8081/api/v1/candidatos/{id}
{
   
   "nome": "Marta",
   "vaga": "Desenvolvedor5",
   "endereco": "Rua Jose Saldanha",
   "telefone": "11960653610",
   "documento": 181767120
}

Post ->http://localhost:8081/api/v1/cartoes/{id}
{
  
   "nomePortador": "Carla",
   "numero": 508900027175,
   "dataVenc": "02-05-21",
   "codValidade": "466"  
}
DELETE ->http://localhost:8081/api/v1/candidatos/{id}

DELETE->http://localhost:8081/api/v1/cartoes/{id}
