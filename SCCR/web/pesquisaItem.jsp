<%-- 
    Document   : pesquisaItem
    Created on : 12/10/2017, 15:03:24
    Author     : Laís Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item</title>
    </head>
    <body>
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
                    <td><a href ="ManterAdministradorController?acao=prepararEditar&ID_administrador <c:out value="${administrador.id}"/>">Editar</a></td>
                    <td><a href ="ManterAdministradorController?acao=prepararEditar&ID_administrador <c:out value="${administrador.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterAdministradorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    

    </body>
</html>
