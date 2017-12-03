

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Minha Conta</title>

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
    
        
            <div class="panel-title">
                <h3><span class="glyphicon glyphicon-user"></span> <strong>Bem Vindo Organizador(a)</strong> </h3>
                
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10">
                          <a href="#" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Minhas Provas</a>
                          <a href="#" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Alterar dados Pessoais</a>
                          <a href="#" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> <br/>Cadastrar Rankings</a> 
                          
                          <a href="#" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-floppy-remove"></span> <br/>Excluir Conta</a>
                        </div>
                       
                    </div>
                    
                </div>
            </div>
        </div>
        
        
        <jsp:include page="footer.jspf"/>
    

    </body>
</html>