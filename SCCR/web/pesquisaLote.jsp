
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter lotes</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <table class="table table-bordered">    
            <tr>

                <th>Código do Lote</th>
                <th>Identificação</th>
                <th>Prova</th>
                <th>Data de Inicio</th>
                <th>Data do Fim</th>
                <th>Valor</th>

            </tr>    

            <c:forEach items="${lotes}" var="lote">
                <tr>

                    <td><c:out value = "${lote.id}" /></td>
                    <td><c:out value = "${lote.identificacao}" /></td>
                    
                    <td><c:forEach items="${provas}" var ="prova">
                            ${prova.nomeProva} <c:if test="${prova.id ==Lote.prova_id}"></c:if>
                               
                       </td>
                        </c:forEach>
                    <td><c:out value = "${lote.dataInicio}" /></td>
                    <td><c:out value = "${lote.dataFim}" /></td>
                    <td><c:out value = "${lote.valor}" /></td>


                    <td> <a href="ManterLoteController?acao=prepararEditar&id=<c:out value="${lote.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterLoteController?acao=prepararExcluir&id=<c:out value="${lote.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterLoteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>


