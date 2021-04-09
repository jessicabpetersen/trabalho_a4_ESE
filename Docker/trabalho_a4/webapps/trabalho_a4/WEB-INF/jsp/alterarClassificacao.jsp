<jsp:include page="templates/header.jsp" />

<form method="POST" action="">
    <div class="container">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Filme</th>
                    <th scope="col">Nota</th>
                    <th scope="col">Data</th>
                    <th scope="col">Alterar Classificação</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="atributo">
                    <tr>
                        <th scope="row">${atributo.id}</th>
                        <td>${atributo.nomeFilme}</td>
                        <td>${atributo.nota}</td>
                        <td>${atributo.data}</td>
                        <td><a href="/trabalho_a4/alterarClassificacao/${atributo.id}${nota}" class="btn btn-danger">ALTERAR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="container">
            <div class="row">
                <div class="field-wrapper input">
                    <span>Nota:&nbsp;</span><input ${nota} id="nota" name="nota" type="number" maxlength="2" min="0" max="10" size="10" required>
                </div>
            </div>
        </div>
    </div>
</form>

<jsp:include page="templates/footer.jsp" />