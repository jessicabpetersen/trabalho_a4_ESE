<%-- 
    Document   : filmes
    Created on : 02/12/2020, 18:54:05
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h2>Filmes</h2>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Gênero</th>
                        <th scope="col">Duração</th>
                        <th scope="col">Classificação</th>
                    </tr>
                </thead>

                <tbody>
                <p>Nome do filme: <input type="text" id="nomeFilme" size="60"/></p>
                    <c:forEach items="${lista}" var="atributo">
                        <tr>
                            <th scope="row">${atributo.id}</th>
                            <td>${atributo.nome}</td>
                            <td>${atributo.genero}</td>
                            <td>${atributo.duracao}</td>
                            <td>${atributo.classificacao}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <footer>
        <div class="container">
            <p>Acadêmicos:</p>
            <p>Alexander Felipe Chiudini Ristow</p>
            <p>Jéssica Bernardi Petersen</p>
            <p>Rafael de Miranda</p>
        </div>
    </footer>
    </body>
</html>
