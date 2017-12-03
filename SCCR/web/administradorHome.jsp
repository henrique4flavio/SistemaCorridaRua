

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Administrador</title>

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
                <h3><span class="glyphicon glyphicon-user"></span> <strong>Painel Administrativo</strong> </h3>
                
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10">
                          <a href="PesquisaAtletaController" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Listar Atletas</a>
                          <a href="PesquisaOrganizadorController" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Gerenciar Organizadores</a>
                          <a href="PesquisaAdministradorController" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Gerenciar Administradores</a>
                        </div>
                       
                    </div>
                    
                </div>
            </div>
        </div>
        
        
        <jsp:include page="footer.jspf"/>
    

    </body>
</html>