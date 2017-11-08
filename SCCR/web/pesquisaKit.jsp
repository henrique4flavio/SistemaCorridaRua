
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kits</title>
    </head>
    <body>
        <h1>Pesquisa de Kits</h1>
        <table border='1'>    
            <tr>

                <th>Código do Kit</th>
                <th>Nome do Kit</th>
                <th>Itens</th>
                
            </tr>    

            <c:forEach items="${kits}" var="kit">
                <tr>

                    <td><c:out value = "${kit.id}" /></td>
                    <td><c:out value = "${kit.nomeKit}" /></td>
                    
                   <td> <a href="ManterKitController?acao=prepararEditar&Editar&ID_kit = <c:out value="${kit.id}"/>"> Editar </a></td>
                    <td> <a href="ManterKitController?acao=prepararExcluir&ID_kit = <c:out value="${kit.id}"/>">Excluir </a><td>
               
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterKitController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

