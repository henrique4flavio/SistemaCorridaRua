

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
           
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Controle de chip retornavel</title>
    </head>
    <body>
        <h1>Manter Controle de chip retornavel - ${operacao}</h1>

        <form action="ManterControleChipRetornavelController?acao=confirmar${operacao}" method="post" name="frmManterControleChipRetornavel">
            <table>
                <tr>
                        <td>Código controle de chip:</td> 
                    <td><input type="text" name="txtIdControleChipRetornavel" value="${controleChipRetornavel.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Identificador atleta:</td> 
                        <td><input type="text" name="txtIdentificadorAtleta" value="${controleChipRetornavel.identificadorAtleta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Prova:</td> 
                        <td><input type="text" name="txtProva" value="${controleChipRetornavel.prova_id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>               
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
