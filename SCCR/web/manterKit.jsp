
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Kit</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
      

    <center><h3>${operacao} Kit</h3></center>
    <div class="col-md-6">
            <form action="ManterKitController?acao=confirmar${operacao}" method="post" name="frmManterKit">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Kit:</label>
                    <input type="text" name="txtIdKit" class="form-control" value="${kit.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome:</label>
                        <input type="text" name="txtNomeKit" class="form-control" value="${kit.nomeKit}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Valor:</label>
                        <input type="text" name="txtNomeKit" class="form-control" value="${kit.valor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    
                

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaKitController" class="btn btn-default">Cancelar</a>

            </form>                   
        </div> 	
    
    <jsp:include page="footer.jspf"/>

</body>
