
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Kit</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h1>Manter Kit - ${operacao}</h1>

        <form action="ManterKitController?acao=confirmar${operacao}" method="post" name="frmManterKit">
            <table>
                <tr>
                    <td>Id do Kit</td> 
                    <td><input type="text" name="txtIdKit" value="${kit.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do kit:</td> 
                        <td><input type="text" name="txtNomeKit" value="${kit.nomeKit}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>    
            </table>
        </form>

    </body>
</html>
