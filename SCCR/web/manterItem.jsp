
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Item</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        

   
<center><h3>${operacao} Item</h3></center>
    <div class="col-md-6">
            <form action="ManterItemController?acao=confirmar${operacao}" method="post" name="frmManterItem">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Item:</label>
                    <input type="text" name="txtIdItem" class="form-control" value="${item.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome:</label>
                        <input type="text" name="txtNomeItem" class="form-control" value="${item.nomeItem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    
                

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaItemController" class="btn btn-default">Cancelar</a>

            </form>                   
        </div> 	
    
    <jsp:include page="footer.jspf"/>

</body>