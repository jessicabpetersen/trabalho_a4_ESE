<jsp:include page="templates/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">

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
        <form method="GET" action="">
            <div class="form-group">Nome do filme: <input type="text" name="nomeFilme" id="nomeFilme" size="60" required/></div>
            <div class="form-group"><input type="submit" id="submit" class="btn btn-primary" value="Pesquisar"/></div>
        </form>            
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

<jsp:include page="templates/footer.jsp" />
