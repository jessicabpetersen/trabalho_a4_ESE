<jsp:include page="templates/header.jsp" />

<div class="container">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">G�nero</th>
                <th scope="col">Dura��o</th>
                <th scope="col">Classifica��o</th>
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

<jsp:include page="templates/footer.jsp" />
