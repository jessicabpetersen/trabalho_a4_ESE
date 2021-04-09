<jsp:include page="templates/header.jsp" />

    <div class="container">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Gênero</th>
                    <th scope="col">Duração</th>
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
                        <td><a href="/trabalho_a4/incluirClassificacao/${atributo.id}${nota}" class="btn btn-danger">INCLUIR</a></td>
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

<jsp:include page="templates/footer.jsp" />