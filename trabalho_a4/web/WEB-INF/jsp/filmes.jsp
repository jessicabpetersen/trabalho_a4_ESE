<jsp:include page="templates/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">

    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">G�nero</th>
                <th scope="col">Dura��o</th>
                <th scope="col">Classifica��o</th>
                <th scope="col">Visualizar</th>
                <th scope="col">Assistir</th>
                <th scope="col">Classificar</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${lista}" var="atributo">
                <tr>
                    <th scope="row">${atributo.id}</th>
                    <td>${atributo.nome}</td>
                    <td>${atributo.genero}</td>
                    <td>${atributo.duracao}</td>
                    <td>${atributo.classificacao}</td>
                    <td><a href="/trabalho_a4/filmes/${atributo.nome}" class="btn btn-danger">Informações</a></td>
                    <td><a href="/trabalho_a4/assistir/${atributo.id}" class="btn btn-danger">Assitir</a></td>
                    <td><form method="post" action="">
                        <input ${nota} id="nota" name="nota" type="number" maxlength="2" min="0" max="10" size="10" required>
                        <button type="submit" class="btn btn-danger">Enviar</button>
                        </form></a></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>

<jsp:include page="templates/footer.jsp" />