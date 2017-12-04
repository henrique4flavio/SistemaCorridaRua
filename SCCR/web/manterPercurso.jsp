
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
       
   <center><h3>${operacao} Percurso</h3></center>
    <div class="col-md-6">
            <form action="ManterPercursoController?acao=confirmar${operacao}" method="post" name="frmManterPercurso">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Percurso:</label>
                    <input type="text" name="txtIdPercurso" class="form-control" value="${percurso.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome:</label>
                        <input type="text" name="txtNomePercurso" class="form-control" value="${percurso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                     <div class="form-group">
                        <label for="exampleInputPassword1">Distância:</label>
                        <input type="text" name="txtDistancia" class="form-control" value="${percurso.distancia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                     <div class="form-group">
                        <label for="exampleInputPassword1">Faixa Etaria:</label>
                        <input type="text" name="txtfaixaEtaria" class="form-control" value="${percurso.faixaEtaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                    <select name="optProva" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${percurso.prova_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${prova}" var="prova">
                                <option value="${prova.id}" <c:if test="${prova.id == percurso.prova_id}"> selected</c:if>>${prova.nomeProva}</option>  
                            </c:forEach>
                        </select>
                    </div>
                

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaPercursoController" class="btn btn-default">Cancelar</a>

            </form>                   
        </div> 	
    
    <jsp:include page="footer.jspf"/>

</body>