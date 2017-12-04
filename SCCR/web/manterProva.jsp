
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
                        <td>Local da Retirada do Kit:</td> 
                        <td><input type="text" name="txtLocalRetiradaKit" value="${prova.localRetiradaKit}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                        <td><input type="text" name="txtMaxParticipantes" value="${prova.maxParticipantes}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                        <td>Organizador:</td> 
                        <td>
                            <select name="optOrganizador" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${prova.organizador_id == null}"> selected</c:if>></option>  
                            <c:forEach items="${organizador}" var="organizador">
                                <option value="${organizador.id}" <c:if test="${organizador.id == prova.organizador_id }"> selected</c:if>>${organizador.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>    
                </tr>
                <tr>
                    <td>Ranking:</td> 
                    <td>
                        <select name="optRanking" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${prova.ranking_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${ranking}" var="ranking">
                                <option value="${ranking.id}" <c:if test="${ranking.id == prova.ranking_id}"> selected</c:if>>${ranking.nome}</option>  
                            </c:forEach>
                        </select>


                    </td>

                </tr>
                <tr>


                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
