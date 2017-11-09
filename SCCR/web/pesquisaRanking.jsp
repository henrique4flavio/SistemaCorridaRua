
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rankings</title>
    </head>
    <body>
        <h1>Rankings</h1>
        <table border='1'>    
            <tr>

                <th>Código do ranking</th>
                <th>Ranking</th>

            </tr>    

            <c:forEach items="${rankings}" var="ranking">
                <tr>

                    <td><c:out value = "${ranking.id}" /></td>
                    <td><c:out value = "${ranking.nome}" /></td>
                    <td> <a href="ManterRankingController?acao=prepararEditar&id=<c:out value="${ranking.id}"/>"> Editar </a></td>
                    <td> <a href="ManterRankingController?acao=prepararExcluir&id=<c:out value="${ranking.id}"/>">Excluir </a><td>

                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterRankingController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
