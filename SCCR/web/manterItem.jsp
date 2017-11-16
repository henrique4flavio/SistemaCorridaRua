
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Item</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h1>Manter Item - ${operacao}</h1>

        <form action="ManterItemController?acao=confirmar${operacao}" method="post" name="frmManterItem">
            <table>
                <tr>
                    <td>Id do Item</td> 
                    <td><input type="text" name="txtIdItem" value="${item.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do item:</td> 
                        <td><input type="text" name="txtNomeItem" value="${item.nomeItem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                 <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>   
            </table>
        </form>

    </body>
</html>
