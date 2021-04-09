<jsp:include page="templates/header.jsp" />

<form method="POST" action="">
    <div class="container">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Filme</th>
                    <th scope="col">Nota</th>
                    <th scope="col"></th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="atributo">
                    <tr>
                        <th scope="row">${atributo.id}</th>
                        <td>${atributo.filme}</td>
                        <td>${atributo.nota}</td>
                        <th scope="row">${atributo.excluir}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</form>

<jsp:include page="templates/footer.jsp" />