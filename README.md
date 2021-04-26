# trabalho_a4
 trabalho a4 da materia Engenharia de Software Orientada a Serviço

**Acadêmicos:**  
Alexander Felipe Chiudini Ristow  
Jéssica Bernardi Petersen  
Rafael de Miranda  

  
**Banco de dados:**
![Screenshot](mer.png)

**Funcionalidades:**
1. Serviço para se autenticar na aplicação
2. Serviço para retornar uma lista dos filmes que contém em seu nome uma string informada
3. Serviço (incluir, alterar e excluir) para classificar um filme como gostou ou não gostou informando o código do filme
4. Serviço para retornar uma lista dos filmes que tiveram oscares
5. Serviço para retornar que vai começar a assitir um filme, informando seu código
6. Serviço para informar que vai começar a assitir um filme, informando seu código
7. Registrar os serviços usando os itens (03 - incluir, 03 - alterar, 03 - excluir, 06)
  
URI | Método | Formato | Efeito
---|----|---|---
/filme | GET | Coleção de Filme| Busca a lista de filme
/filmes/{nome} | GET | Filme| Busca um Filme
/filmes/string/{string} | GET | Filme | Retorna todos os filmes que possuem aquela string
/oscar| GET| Oscar| Busca filmes que tiveram algum Oscar
/login | GET | Usuario | Se autentica na aplicacao
/filmes/{id} | POST | Filme | Marca o FIlme como assistido
/classificar/add/{id} | POST | Classificacao | Adiciona ou altera uma classificacao, de acordo com o id do filme informado
/classificar/excluir/{id} | POST | Classificacao | Remove a classificacao do filme informado pelo id
/assistir/{id} | POST | Filme | Insere o filme do id correspondente na tabela de filmes assistidos
/elenco | GET | Filme | Traz todos os filmes com todos seus atores
/elenco/{id} | GET | Ator | Traz os atores que fazem parte do elenco do filme do id informado
