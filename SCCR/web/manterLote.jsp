
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Lote</title>
    </head>
    <body>
        <h1>Manter Lote - ${operacao}</h1>

        <form action="ManterLoteController?acao=confirmar${operacao}" method="post" name="frmManterLote">
            <table>
                <tr>
                    <td>Código do Lote:</td> 
                    <td><input type="text" name="txtIdLote" value="${lote.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Valor:</td> 
                        <td><input type="text" name="txtValorLote" value="${lote.valor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                       <tr>
                    <td>Código da Prova:</td> 
                    <td><input type="text" name="txtIdProva" value="${lote.prova_id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>               
               <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
