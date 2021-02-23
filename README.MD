# Checkpoint
### Resumo
Solução para o desafio da Ília.

#### Tecnologias utilizadas
Para esse projeto, foram utilizadas as seguintes tecnologias:
* Java 11: Linguagem utilizada no projeto;
* Spring: Inicialização da API e injeção de dependências;
* Gradle: Automação do build e gestão de dependências;
* Swagger: Documentação interativa da API;
* MongoDB: Banco de dados não relacional para a persistência dos dados;
* Docker: Administração de containers

#### Requerimentos
Para executar o sistema, é necessário ter Java 11 e Docker na máquina.

#### Inicialização do sistema
Para rodar o sistema, os contêineres do Docker devem estar em execução,
pois, o MongoDB será executado no Docker. Para isso, executar o comando abaixo no terminal
docker-compose up -d
Ao fim da execução do comando acima, o sistema deverá ser executado em uma IDE, ou rodando os comandos abaixo no terminal:

./gradlew build

java -jar ./build/libs/checkpoint-1.0.jar

**Importante** Os comandos descritos nesse documento devem ser executados num terminal aberto na pasta raiz do projeto.

#### Iniciando os testes
####URL do Swagger
* [Swagger](http://127.0.0.1:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)


#### Administração do MongoDB
O banco poderá ser administrado através do [Mongo Express](http://localhost:8081/db/checkpoint_db/Employee).

#### Versionamento

O projeto foi versionado pela URL no modelo path, por ter o visual mais limpo e ser mais amigável ao desenvolvedor.


