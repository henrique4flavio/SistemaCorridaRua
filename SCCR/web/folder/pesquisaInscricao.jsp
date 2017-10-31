
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrição</title>
    </head>
    <body>
        <h1>Inscrição</h1> 
        <table border='1'>    
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
            <c:forEach items="${Inscricao}" var="Inscricao">
                <tr> 
                    <td> <c:out value="${Inscricao.id}"/> </td>
                    <td> <c:out value= "${Inscricao.dataInscricao}"/></td>
                    <td> <c:out value= "${Inscricao.numeroInscricao}"/></td>
                    <td> <c:out value="${Inscricao.formaPagamento}"/> </td>
                    <td> <c:out value="${Inscricao.kit_id}"/> </td>
                    <td> <c:out value="${Inscricao.controle_chip_retornavel_id}"/> </td>
                    <td> <c:out value= "${Inscricao.prova_id}"/></td>
                    <td> <c:out value= "${Inscricao.percurso_id}"/></td>
                    <td> <c:out value="${Inscricao.atleta_id}"/> </td>
                    <td><a href ="ManterInscricaoController?acao=prepararEditar&ID_Item" <c:out value="${Inscricao.id}"/>">Editar</a></td>
                    <td><a href ="ManterInscricaoController?acao=prepararEditar&ID_Item" <c:out value="${Inscricao.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterInscricao?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    




    </body>
</html>
