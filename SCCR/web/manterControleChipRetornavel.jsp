
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
      <title>Manter Chip</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>Manter Controle de chip retornavel - ${operacao}</h3>

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
                        <td>Prova</td>
                        <td>
                            <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${percurso.prova.id== null}"> selected</c:if>>Selecione uma prova</option>  
                            <c:forEach items="${prova}" var="prova">
                                <option value="${prova.id}" <c:if test="${percurso.prova_id == prova.id}"> selected</c:if>>${prova.nomeProva}</option>  
                            </c:forEach>
                        </select>
                    </td>                                       
                </tr>            
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
