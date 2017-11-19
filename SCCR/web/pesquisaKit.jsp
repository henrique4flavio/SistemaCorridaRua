
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter kits</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <table class="table table-bordered">    
            <tr>

                <th>Código do Kit</th>
                <th>Nome do Kit</th>
                <th>Itens</th>
                
            </tr>    

            <c:forEach items="${kits}" var="kit">
                <tr>

                    <td><c:out value = "${kit.id}" /></td>
                    <td><c:out value = "${kit.nomeKit}" /></td>
                    
                   <td> <a href="ManterKitController?acao=prepararEditar&id=<c:out value="${kit.id}"/>"> <button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterKitController?acao=prepararExcluir&id=<c:out value="${kit.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>
               
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterKitController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

