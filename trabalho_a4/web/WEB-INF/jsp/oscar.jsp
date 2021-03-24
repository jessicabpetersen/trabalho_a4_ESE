<%-- 
    Document   : oscar
    Created on : 08/03/2021, 17:45:25
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <h2>Filmes com Oscares</h2>
        <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Gênero</th>
                        <th scope="col">Duração</th>
                        <th scope="col">Oscares</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="atributo">
                        <tr>
                            <th scope="row">${atributo.id}</th>
                            <td>${atributo.nome}</td>
                            <td>${atributo.genero}</td>
                            <td>${atributo.duracao}</td>
                            <td>${atributo.oscares}</td>
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
