

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Administrador</title>

        <script> function validaSenha(input) {
                if (input.value != document.getElementById('senha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>


    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/> 

<div class="container">
    
        
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-primary">
                        Menu do Atleta</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10">
                          <a href="#" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Minhas Inscrições</a>
                          <a href="#" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Alterar dados Pessoais</a>
                          <a href="#" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> <br/>Consultar Resultados</a> 
                          <a href="#" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Rankings</a>
                          <a href="#" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-floppy-remove"></span> <br/>Excluir Conta</a>
                        </div>
                       
                    </div>
                    
                </div>
            </div>
        </div>
    

    </body>
</html>