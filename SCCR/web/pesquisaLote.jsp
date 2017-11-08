
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lotes</title>
    </head>
    <body>
        <h1>Lotes de Inscrição</h1>
        <table border='1'>    
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
                    <td><c:out value = "${lote.prova_id}" /></td>
                    <td><c:out value = "${lote.dataInicio}" /></td>
                    <td><c:out value = "${lote.dataFim}" /></td>
                    <td><c:out value = "${lote.valor}" /></td>


                    <td> <a href="ManterLoteController?acao=prepararEditar&Editar&ID_lote = <c:out value="${lote.id}"/>">Editar</a></td>
                    <td> <a href="ManterLoteController?acao=prepararExcluir&ID_lote = <c:out value="${lote.id}"/>">Excluir </a><td>
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterLoteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>


