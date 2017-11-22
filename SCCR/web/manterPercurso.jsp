
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="bootstrap.jspf"/>
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
                       <td>Prova:</td>
                    <td>
                        <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${percurso.prova_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${provas}" var="prova">
                                <option value="${prova.id}" <c:if test="${prova.id == percurso.prova_id}"> selected</c:if>>${prova.nomeProva}</option>  
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
