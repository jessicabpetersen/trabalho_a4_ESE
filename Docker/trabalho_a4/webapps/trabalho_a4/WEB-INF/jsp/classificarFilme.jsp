<%-- 
    Document   : classificarFilme
    Created on : 09/04/2021, 15:48:34
    Author     : Gabriel Petersen
--%>
<jsp:include page="templates/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nota</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="atributo">
                    <tr>
                        <th scope="row">${atributo.id}</th>
                        <td>${atributo.nota}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>


<jsp:include page="templates/footer.jsp" />
