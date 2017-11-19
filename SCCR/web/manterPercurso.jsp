
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter percurso</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form action="ManterPercursoController?acao=confirmar${operacao}" method="post" name="frmManterPercurso">
            <table>
                <tr>
                    <td>Código do percurso:</td> 
                    <td><input type="text" name="txtIdPercurso" value="${percurso.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do percurso:</td> 
                        <td><input type="text" name="txtNomePercurso" value="${percurso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Distancia:</td> 
                        <td><input type="text" name="txtDistancia" value="${percurso.distancia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Faixa etaria:</td> 
                        <td><input type="text" name="txtfaixaEtaria" value="${percurso.faixaEtaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    
                    <tr>
                  
                   <tr>
                        <td>Codigo Prova </td> 
                        <td><input type="text" name="txtProva" value="${percurso.prova_id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                </tr>
                                                     
                   
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
