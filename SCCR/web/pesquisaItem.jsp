
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Item</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>Itens</h3>
        <table class="table table-bordered">    
            <tr>

                <th>Código do item</th>
                <th>Nome do item</th>

            </tr>    

            <c:forEach items="${itens}" var="item">
                <tr>
                    
                    <td><c:out value = "${item.id}" /></td>
                    <td><c:out value = "${item.nomeItem}" /></td>
                    <td> <a href="ManterItemController?acao=prepararEditar&id=<c:out value="${item.id}"/>"> <button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterItemController?acao=prepararExcluir&id=<c:out value="${item.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterItemController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>
