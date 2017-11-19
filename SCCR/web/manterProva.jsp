
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter provas</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form action="ManterProvaController?acao=confirmar${operacao}" method="post" name="frmManterProva">
            <table>
                <tr>
                    <td>Código da prova:</td> 
                    <td><input type="text" name="txtId" value="${prova.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome da prova:</td> 
                        <td><input type="text" name="txtNomeProva" value="${prova.nomeProva}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Local da largada:</td> 
                        <td><input type="text" name="txtLocalLargada" value="${prova.localLargada}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Horario da largada:</td> 
                        <td><input type="text" name="txtHorarioLargada" value="${prova.horarioLargada}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data da prova:</td> 
                        <td><input type="text" name="txtDataProva" value="${prova.dataProva}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Maximo de participantes:</td> 
                        <td><input type="text" name="txtmaxParticipantes" value="${prova.maxParticipantes}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Inicio das incrições:</td> 
                        <td><input type="text" name="txtInicioInscricao" value="${prova.inicioInscricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Fim das incrições:</td> 
                        <td><input type="text" name="txtFimInscricao" value="${prova.fimInscricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>                                
                    <tr>
                        <td>Faixa etaria:</td> 
                        <td><input type="text" name="txtFaixaEtaria" value="${prova.faixaEtaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    
                    <tr>
                    <td>Código do organizador:</td> 
                    <td><input type="text" name="txtOrganizador_id" value="${prova.organizador_id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                    <td>Código do ranking:</td> 
                    <td><input type="text" name="txtRanking_id" value="${prova.ranking_id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
