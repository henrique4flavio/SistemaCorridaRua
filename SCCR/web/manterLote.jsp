
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Lote</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form action="ManterLoteController?acao=confirmar${operacao}" method="post" name="frmManterLote">
            <table>
                <tr>
                    <td>Código do Lote:</td> 
                    <td><input type="text" name="txtIdLote" value="${lote.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Identificacao:</td> 
                        <td><input type="text" name="txtIdentificacaoLote" value="${lote.identificacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data Inicio</td> 
                        <td><input type="text" name="txtDataInicioLote" value="${lote.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data Fim</td> 
                        <td><input type="text" name="txtDataFimLote" value="${lote.dataFim}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
<<<<<<< HEAD
                    
                    <tr>
                        <td>Desconto</td> 
                        <td><input type="text" name="txtDesconto" value="${lote.desconto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        
                        <td> Prova:</td> 
                        <td>
                            <select name="optProva" <c:if test="${operacao =='Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${lote.prova_id == null}"> selected</c:if>> </option>  
=======
                       <tr>
                    <td> Prova:</td> 
                     <td>
                         <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${percurso.prova_id == null}"> selected</c:if>> </option>  
>>>>>>> c7b6c94bb4b5cd47cd2e8e2db175e1398b75402d
                            <c:forEach items="${prova}" var="prova">
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
