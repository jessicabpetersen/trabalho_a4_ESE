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
                    <th scope="col"></th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="atributo">
                    <tr>
                        <th scope="row">${atributo.id}</th>
                        <td>${atributo.nomeFilme}</td>
                        <td>${atributo.nota}</td>
                        <td>${atributo.data}</td>
                        <th scope="row">${atributo.elemento}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="container">
            <div class="row">
                <div class="field-wrapper input">
                    <span>Nota:&nbsp;</span><input type="number" maxlength="2" min="0" max="10" size="10" required>
                </div>
            </div>
        </div>
        <div class="d-sm-flex justify-content-between">
            <div class="field-wrapper">
                <button type="submit" class="btn btn-primary" value="">Alterar</button>
            </div>
        </div>
    </div>
</form>

<jsp:include page="templates/footer.jsp" />