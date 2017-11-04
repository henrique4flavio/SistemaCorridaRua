
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item</title>
    </head>
    <body>
        <h1>Itens</h1>
        <table border='1'>    
            <tr>

                <th>Código do item</th>
                <th>Nome do item</th>

            </tr>    

            <c:forEach items="${Item}" var="item">
                <tr>
                    
                    <td><c:out value = "${item.id}" /></td>
                    <td><c:out value = "${item.nomeItem}" /></td>
                    <td> <a href="ManterItemController ?acao=prepararEditar&Editar&id = <c:out value="${item.id}"/>"> Editar </a></td>
                    <td> <a href="ManterItemController?acao=prepararExcluir&id = <c:out value="${item.id}"/>">Excluir </a><td>

                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterItemController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
