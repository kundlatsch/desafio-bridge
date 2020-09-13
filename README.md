# Desafio | Dev. Full Stack

O projeto neste repositório consiste em um aplicativo web onde o usuário pode calcular o fatorial de um número inserido, dentro do limite de capacidade de cálculo do servidor. O projeto é dividido entre o frontend desenvolvido utilizando React.js e o backend desenvolvido utilizando Spring Boot.

## Backend

O backend foi construído em Java, com Spring. Além do framework, outras ferramentas e técnicas foram utilizadas:

* Gradle, para gerenciamento de pacotes.
* Docker, para virtualização.
* Arquitetura MVC, para organização do código.
* JUnit, para realização dos testes de unidade.
* Banco de Dados SQLite, para persistência de dados.

Para rodar o backend localmente, após clonar o repositório, pode ser utilizado o Gradle:

```
cd backend
gradle bootRun
```

Para poder ser executado pelo Docker, é necessário primeiro gerar um JAR através do Gradle:

```
cd backend
gradle build
docker build --build-arg JAR_FILE=build/libs/*.jar -t springio/gs-spring-boot-docker .
docker run -p 8080:8080 springio/gs-spring-boot-docker
```

O backend utiliza a porta 8080, que pode ser acessada localmente através de `localhost:8080/`.

#### Endpoints

O servidor criado usa o padrão REST, e possui as seguintes rotas:

* `POST /factorial`: Rota que realiza o cálculo do fatorial de um número. O número deve ser passado no corpo da requisição, utilizando o parâmetro `number`. Essa requisição retorna um objeto Json com o próprio número e o `numberFactorial` que foi calculado.

Exemplo de corpo da requisição:

```
{
	"number": 11
}
```

Exemplo de resposta:

```
{
  "number": 11,
  "numberFactorial": 39916800
}
```

* `GET /history/{numberOfFacs}`: Rota que retorna os últimos N cálculos de fatorial realizados pelo servidor, sendo N a *path variable* `numberOfFacs`.

Exemplo de resposta para a requisição `/history/3`:

```
[
  {
    "number": 3,
    "numberFactorial": 6
  },
  {
    "number": 11,
    "numberFactorial": 39916800
  },
  {
    "number": 12,
    "numberFactorial": 479001600
  }
]
```

### Testes

Foram criados testes para os cálculos de fatoriais. Eles podem ser executados com o Gradle:

```
cd backend
gradle test
```

## Frontend

O frontend foi construído em Node.js, com o React.js. Não foram utilizadas bibliotecas de CSS. Os pacotes utilizados no aplicativo foram:

* Axios, para configuração das requisições ao backend.
* React-router-DOM, para o roteamento das telas do app.
* React-icons, para o ícone de retornar a tela principal após acessar o histórico.

Para rodar o frontend, basta utilizar o `npm`:

```
cd frontend
npm install
npm start
```

O backend utiliza a porta 3333, que pode ser acessada localmente através de `localhost:3333/`.

## Imagens das Telas

![Tela de Cálculo](/images/calc.png)

![Tela de Histórico](/images/history.png)