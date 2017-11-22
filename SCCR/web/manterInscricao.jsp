<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Inscrição</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form action="ManterInscricaoController?acao=confirmar${operacao}" method="post" name="frmManterInscricao">
            <table>
                <tr>
                    <td>Codigo da Inscrição:</td> 
                    <td><input type="text" name="txtId" value="${inscricao.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
            
                <tr>
                    <td>Data da Inscrição:</td> 
                    <td><input type="text" name="txtDataInscricao" value="${inscricao.dataInscricao}" <c:if test="${operacao != 'Incluir'}"></c:if>></td>
                    </tr>

                    <tr>
                        <td>Numero da Inscrição:</td> 
                        <td><input type="text" name="txtNumeroInscricao" value="${inscricao.numeroInscricao}" <c:if test="${operacao != 'Incluir'}"> </c:if>></td>
                    </tr>

                    <tr> 
                        <td>Forma de Pagamento:</td> 
                        <td>
                            <select name="optFormaPagamento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Cartao" <c:if test="${inscricao.formaPagamento == 'cartão'}"> selected</c:if>>Cartão de Credito</option>
                            <option value="Boleto" <c:if test="${inscricao.formaPagamento == 'boleto'}"> selected</c:if>>Boleto Bancario</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Kit:</td> 
                        <td>
                         <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${inscricao.kit_id == null}"> selected</c:if>></option>  
                            <c:forEach items="${kit}" var="kit">
                                <option value="${kit.id}" <c:if test="${kit.id == inscricao.kit_id}"> selected</c:if>>${kit.nomeKit}</option>  
                            </c:forEach>
                        </select>
                    </td>
                         </tr>

           
                    <tr>
                        <td>Prova:</td> 
                        <td>
                         <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${inscricao.prova_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${prova}" var="prova">
                                <option value="${prova.id}" <c:if test="${prova.id == inscricao.prova_id}"> selected</c:if>>${prova.nomeProva}</option>  
                            </c:forEach>
                        </select>
                    </td>
                       </tr>


                    <tr>
                        <td>Percurso:</td> 
                        <td>
                         <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${inscricao.percurso_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${percurso}" var="percurso">
                                <option value="${percurso.id}" <c:if test="${percurso.id == inscricao.percurso_id}"> selected</c:if>>${percurso.nome}</option>  
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
