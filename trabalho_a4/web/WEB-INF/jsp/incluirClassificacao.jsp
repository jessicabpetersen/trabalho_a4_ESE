<jsp:include page="templates/header.jsp" />

<form method="POST" action="">
    <div class="container">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Gênero</th>
                    <th scope="col">Duração</th>
                    <th scope="col"></th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="atributo">
                    <tr>
                        <th scope="row">${atributo.id}</th>
                        <td>${atributo.nome}</td>
                        <td>${atributo.genero}</td>
                        <td>${atributo.duracao}</td>
                        <td>${atributo.incluir}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container">
        <div class="row">
            <div class="field-wrapper input">
                <span>Nota:&nbsp;</span><input type="number" maxlength="2" min="0" max="10" size="10" required>
            </div>
        </div>
    </div>
    <div class="d-sm-flex justify-content-between">
        <div class="field-wrapper">
            <button type="submit" class="btn btn-primary" value="">Classificar</button>
        </div>
    </div>
</form>

<jsp:include page="templates/footer.jsp" />