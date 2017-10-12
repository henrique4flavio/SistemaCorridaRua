<%-- 
    Document   : pesquisaItem
    Created on : 12/10/2017, 15:03:24
    Author     : Laís Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item</title>
    </head>
    <body border='1'>
        <h1>Itens</h1>
        <table>    
            <tr>

                <th>Código do Item</th>
                <th>Nome</th>

            </tr>    

            <c:forEach items="${Item}" var="Item">
                <tr>

                    <td><c:out value = "${Item.id}" /></td>
                    <td><c:out value = "${Item.nomeItem}" /></td>
                    <td> <a href="ManterItemController ?acao=prepararEditar&Editar&id = <c:out value="${Item.id}"/>"> Editar </a></td>
                    <td> <a href="ManterItemController?acao=prepararExcluir&id = <c:out value="${Item.id}"/>">Excluir </a><td>


                </tr>                                                                  
            </c:forEach>
        </table>
        <br><br>
        <form action ="ManterItemController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    

    </body>
</html>
