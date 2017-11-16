
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Inscrição</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>Inscrição</h3> 
        <table class="table table-bordered"> 
            <tr>

                <th>Código da inscrição</th>
                <th>Data da inscricao</th>
                <th>Numero de inscricao</th>
                <th>Forma de pagamento</th>
                <th>Código do kit</th>
                <th>Código do chip retornavel</th>
                <th>Código da prova</th>
                <th>Código do percurso</th>
                <th>Código do atleta</th>



            </tr>   
            <c:forEach items="${inscricoes}" var="inscricao">
                <tr> 
                    <td> <c:out value="${inscricao.id}"/> </td>
                    <td> <c:out value= "${inscricao.dataInscricao}"/></td>
                    <td> <c:out value= "${inscricao.numeroInscricao}"/></td>
                    <td> <c:out value="${inscricao.formaPagamento}"/> </td>
                    <td> <c:out value="${inscricao.kit_id}"/> </td>
                    <td> <c:out value="${inscricao.controleChipRetornavel_id}"/> </td>
                    <td> <c:out value= "${inscricao.prova_id}"/></td>
                    <td> <c:out value= "${inscricao.percurso_id}"/></td>
                    <td> <c:out value="${inscricao.atleta_id}"/> </td>
                    
                    <td><a href ="ManterInscricaoController?acao=prepararEditar&id=<c:out value="${inscricao.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td><a href ="ManterInscricaoController?acao=prepararExcluir&id=<c:out value="${inscricao.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterInscricaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
