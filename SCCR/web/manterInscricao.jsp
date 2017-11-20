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
                        <td>Codigo do kit:</td> 
                        <td><input type="text" name="txtKit_id" value="${inscricao.kit_id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Codigo do controle de chip retornavel:</td> 
                        <td><input type="text" name="txtControleChipRetornavel_id" value="${inscricao.controleChipRetornavel_id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td>Codigo da prova:</td> 
                        <td><input type="text" name="txtProva_id" value="${inscricao.prova_id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td>Codigo do percurso:</td> 
                        <td><input type="text" name="txtPercurso_id" value="${inscricao.percurso_id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Codigo do atleta:</td> 
                        <td><input type="text" name="txtAtleta_id" value="${inscricao.atleta_id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
             <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
