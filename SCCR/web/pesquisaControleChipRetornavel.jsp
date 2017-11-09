
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chip Retornavel</title>
    </head>
    <body border='1'>
        <h1>Emprestimos chip</h1>
        <table border='1'>    
            <tr>

                <th>Código do chip retornavel</th>
                <th>Identificação do atleta </th>
                <th>Código da prova</th>
            </tr>    
            <c:forEach items="${controleChipRetornaveis}" var="controleChipRetornavel">
                <tr>

                    <td><c:out value = "${controleChipRetornavel.id}" /></td>
                    <td><c:out value = "${controleChipRetornavel.identificadorAtleta}" /></td>
                    <td><c:out value = "${controleChipRetornavel.prova_id}" /></td>
                    <td><a href ="ManterControleChipRetornavel?acao=prepararEditar&ID_controleChipRetornavel" <c:out value="${controleChipRetornavel.id}"/>">Editar</a></td>
                    <td><a href ="ManterControleChipRetornavel?acao=prepararEditar&ID_controleChipRetornavel" <c:out value="${controleChipRetornavel.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterControleChipRetornavelController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
