<jsp:include page="templates/header.jsp" />

    <div class="container">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Filme</th>
                    <th scope="col">Nota</th>
                    <th scope="col">Data</th>
                    <th scope="col">Excluir</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="atributo">
                    <tr>
                        <th scope="row">${atributo.id}</th>
                        <td>${atributo.nomeFilme}</td>
                        <td>${atributo.nota}</td>
                        <td>${atributo.data}</td>
                        <td><a href="/trabalho_a4/excluirClassificacao/${atributo.id}" class="btn btn-danger">EXCLUIR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<jsp:include page="templates/footer.jsp" />