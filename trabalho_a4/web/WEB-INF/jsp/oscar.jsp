<jsp:include page="templates/header.jsp" />

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
<jsp:include page="templates/footer.jsp" />