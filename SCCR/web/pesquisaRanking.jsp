
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Rankings</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>Rankings</h3>
        <table class="table table-bordered">    
            <tr>

                <th>Código do ranking</th>
                <th>Ranking</th>

            </tr>    

            <c:forEach items="${rankings}" var="ranking">
                <tr>

                    <td><c:out value = "${ranking.id}" /></td>
                    <td><c:out value = "${ranking.nome}" /></td>
                    <td> <a href="ManterRankingController?acao=prepararEditar&id=<c:out value="${ranking.id}"/>"> <button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterRankingController?acao=prepararExcluir&id=<c:out value="${ranking.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterRankingController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
