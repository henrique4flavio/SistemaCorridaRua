
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter provas</title>
    </head>
    <body>
        <h1>Manter provas - ${operacao}</h1>

        <form action="ManterCursoController?acao=confirmar${operacao}" method="post" name="frmManterCurso">
            <table>
                <tr>
                    <td>Código da prova:</td> 
                    <td><input type="text" name="txtIdProva" value="${prova.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
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
                        <td><input type="text" name="txtDataDaProva" value="${prova.dataDaProva}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Maximo de participantes:</td> 
                        <td><input type="text" name="txtCpf" value="${prova.maxParticipantes}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Faixa etaria:</td> 
                        <td><input type="text" name="txtFaixaEtaria" value="${prova.faixaEtaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    
                    <tr>
                    <td>Código do organizador:</td> 
                    <td><input type="text" name="txtIdOrganizador" value="${prova.organizador_id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                    <td>Código do ranking:</td> 
                    <td><input type="text" name="txtIdRanking" value="${prova.ranking_id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                    <td>Código dos resultados das provas:</td> 
                    <td><input type="text" name="txtIdresultado_prova" value="${prova.resultado_prova_id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
