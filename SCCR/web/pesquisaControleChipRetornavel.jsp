<%-- 
    Document   : pesquisaControleChipRetornavel
    Created on : 12/10/2017, 12:40:34
    Author     : Laís Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chip Retornavel</title>
    </head>
    <body border='1'>
        <h1> Emprestimos do Chip Retornavel</h1>
        <table>    
            <tr>

                <th>Código administrador</th>
                <th> Atleta Identificador </th>
                <th>Id da Prova</th>
            </tr>    
            <c:forEach items="${ControleChipRetornavel}" var="ControleChipRetornavel">
                <tr>

                 <td><c:out value = "${ControleChipRetornavel.id}" /></td>
                <td><c:out value = "${ControleChipRetornavel.identificadorAtleta}" /></td>
                <td><c:out value = "${ControleChipRetornavel.prova_id}" /></td>
                <td><a href ="ManterControleChipRetornavel?acao=prepararEditar&ID_administrador" <c:out value="${ControleChipRetornavel.id}"/>">Editar</a></td>
                <td><a href ="ManterControleChipRetornavel?acao=prepararEditar&ID_administrador" <c:out value="${ControleChipRetornavel.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterControleChipRetornavel?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    


    </body>
</html>
