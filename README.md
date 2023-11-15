<h1 align="center">   🐶🐾 Gerenciador de Adoção de Animais 🐾🐱 </h1> 
 
<p align="center"> Este projeto é uma API Java que visa facilitar o gerenciamento de adoção de animais. Com esta API, é possível realizar diversas operações essenciais no contexto de adoção de animais, incluindo o cadastro de novos animais, a listagem detalhada ou filtrada, a atualização de informações e a exclusão de registros. Além disso, a API oferece a funcionalidade de adicionar comentários aos perfis dos animais, enriquecendo a interação e fornecendo uma plataforma aberta para expressar pensamentos e informações relevantes.  </p>
<br>

#  Tecnologias Utilizadas 
 🛠️  `Java 11`<br>
🛠️ `Spring Boot`<br>
🛠️  `Spring Data JPA`<br>
🛠️  `PostgreSQL`<br>
🛠️  `Lombok`<br>
🛠️  `Swagger (documentação da API) `<br>
<br>

#  Estrutura do Projeto 
##  Pacotes
📚 __controller:__ Contém os controladores responsáveis por lidar com as requisições HTTP. <br>
📚 __exception:__ Tratamento de exceções personalizado.<br>
📚 __model:__ Definição das entidades do banco de dados.<br>
📚 __repository:__ Interfaces para acesso aos dados no banco.<br>
📚 __service:__ Lógica de negócios e manipulação dos dados.<br>

## Funcionalidades 
**Cadastro de Animal** <br>
📋  __Endpoint:__ /animais<br>
📋  __Método:__ POST<br>
📋  __Descrição:__ Cadastra um novo animal para adoção.<br>
📋  __Parâmetros:__ JSON contendo informações do animal.<br>

**Listagem de Animais** <br>
📋  __Endpoint:__ /animais<br>
📋  __Método:__ GET<br>
📋  __Descrição:__ Lista todos os animais ou filtra por nome ou tamanho.<br>
📋  __Parâmetros:__ Nome (nome), Tamanho (tamanho), Página (page), e Tamanho da Página (size).<br>

**Busca por ID** <br>
📋  __Endpoint:__ /animais/{id}<br>
📋  __Método:__ GET<br>
📋  __Descrição:__ Busca um animal pelo ID.<br>

**Atualização de Informações do Animal** <br>
📋  __Endpoint:__ /animais/{id}<br>
📋  __Método:__ PATCH<br>
📋  __Descrição:__ Atualiza as informações de um animal pelo ID.<br>
📋  __Parâmetros:__ ID do animal (id), e JSON contendo as informações atualizadas.<br>

**Exclusão de Animal** <br>
📋  __Endpoint:__ /animais/{id}<br>
📋  __Método:__ DELETE<br>
📋  __Descrição:__ Deleta um animal pelo ID.<br>

**Adição de Comentário a um Animal** <br>
📋  __Endpoint:__ /animais/{id}/comentarios<br>
📋  __Método:__ POST<br>
📋  __Descrição:__ Adiciona um comentário a um animal pelo ID.<br>
📋  __Parâmetros:__ ID do animal (id), e JSON contendo o texto do comentário.<br>

**Listagem de Comentários de um Animal** <br>
📋  __Endpoint:__ /animais/{id}/comentarios<br>
📋  __Método:__ GET<br>
📋  __Descrição:__ Lista todos os comentários de um animal pelo ID.<br>
<br>

#   Documentação da API 
📖 A documentação da API pode ser acessada através do Swagger. Após a execução do projeto, acesse http://localhost:8080/swagger-ui.html para explorar os endpoints e testar as operações.
<br><br>

#  Como Executar o Projeto 
▶️ Certifique-se de ter o Java 11 e o PostgreSQL instalados.<br>
▶️ Clone o repositório.<br>
▶️ Configure as propriedades do banco de dados no arquivo application.properties.<br>
▶️ Execute o projeto utilizando sua IDE favorita ou através do Maven: ./mvnw spring-boot:run.<br>
▶️ Pronto! O projeto estará rodando em http://localhost:8080.
<br><br>

# Contato  
🤝  [Linkedin](https://www.linkedin.com/in/thaisbbreder/)

Feito com ❤️ por Thaís Braga Breder
<br>
<br><br>
 
![final pro](https://user-images.githubusercontent.com/99916975/216993087-532d4919-3b6b-4939-9333-b220a97b59bb.png)
