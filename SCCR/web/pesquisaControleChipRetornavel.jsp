
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
      <title>Manter emprestimo</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <table class="table table-bordered">    
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
                    <td><a href ="ManterControleChipRetornavelController?acao=prepararEditar&id=<c:out value="${controleChipRetornavel.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td><a href ="ManterControleChipRetornavelController?acao=prepararExcluir&id=<c:out value="${controleChipRetornavel.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterControleChipRetornavelController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
