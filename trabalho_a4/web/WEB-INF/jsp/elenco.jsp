<%-- 
    Document   : elenco
    Created on : 24/03/2021, 16:08:20
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Elenco</title>
    </head>
    <body>
        <div class="container">
            <h2>Elenco</h2>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                    </tr>
                </thead>

                <tbody>
                <form method="GET" action="">
                <div class="form-group">Código do filme: <input type="number" name="codigo" id="codigo" size="60" required/></div>
                <div class="form-group"><input type="submit" id="submit" class="btn btn-primary" value="Pesquisar"/></div>
                </form>
                    <c:forEach items="${lista}" var="atributo">
                        <tr>
                            <th scope="row">${atributo.id}</th>
                            <td>${atributo.nome}</td>
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
