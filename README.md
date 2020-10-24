# DESAFIO SURITTEC FRONT-END

Desafio para seleção de Desenvolvedor Junior na SURITTEC, o projeto foi desenvolvido com Java usando FrameWork SpringBoot e no Frontend com Angular e PrimeNG.

Nas próximas seções serão apresentados os requisitos e o procedimento para realizar o setup da aplicação.

## Requisitos

Para subir o ambiente é necessário:

* Java 8
* Angular
* Maven
* Git
* NodeJS

## Configuração do Backend

Este projeto foi desenvolvido utilizando a arquitetura de REST.

### Importando Dependências

Para importar as dependencias basta ir no pacote principal e rodar o comando abaixo:

    mvn clean install -U
	

### API

Aplicação onde se encontra todos os seviços do CRUD de cliente, ela se encontra na rota:

    http://localhost:8080

Para iniciar o a api fora da IDE, basta executar o comando abaixo dentro da raiz do projeto:
 
    mvn spring-boot:run	
	
	
## Configurações dos projetos nas IDEs

Este projeto é um projeto Maven. Com isso, o processo de configuração dele é o padrão de qualquer projeto maven.

Basta importar um novo projeto maven apontando para o pom localizado na raíz do projeto.

Os demais detalhes de configurações fica a critério de cada IDE utilizada.	

## Swagger

O projeto possui uma documentação para os Endpoints basta acessar a url abaixo

    http://localhost:8080/swagger-ui.html#/

## Configuração do Frontend

O frontend foi feito usando Angular, após subir api é a hora de iniciar o frontend.

Para acessar o projeto é necessário ter instalado o node mais recente, link para instalação do nodeJS está logo abaixo : 

	https://nodejs.org/en/

### Importando Dependências

Para importar as dependencias do node basta ir no pacote principal e rodar o comando abaixo:

    npm i

Após instalar as dependencias é hora de iniciar o projeto, ainda no pacote principal do projeto rode o comando abaixo:

	npm start

O sistema vai subir na porta 4200, a url dele está logo abaixo:

	http://localhost:4200

	


