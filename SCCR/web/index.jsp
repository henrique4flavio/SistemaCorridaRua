<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>SCCR</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>

    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <div class="container corpo">

            <div class="col-md-6">
                <div class="panel panel-success">
                    <div class="panel-heading">Área do Atleta</div>
                    <div class="panel-body">


                        <c:if test="${msgErro1 != null}">
                            <div class="alert alert-danger">
                                ${msgErro1} 
                            </div>
                        </c:if>


                        <form action="LoginController?acao=logarAtleta" method="post" name="frmManterAtleta">
                            <div class="form-group">
                                <label for="email">Login:</label>
                                <input  class="form-control" id="login" name="login" data-dismiss="alert" aria-label="close">
                            </div>

                            <div class="form-group">
                                <label for="senha">Senha:</label>
                                <input type="password" class="form-control" id="senha" name="senha">
                            </div>




                            <br>                                <br>

                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <button type="submit" class="btn btn-secondary btn-lg btn-block">Acessar</button>

                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-success">
                    <div class="panel-heading">Área Administrativa</div>

                    <div class="panel-body">
                        <c:if test="${msgErro2 != null}">
                            <div class="alert alert-danger">
                                ${msgErro2} 
                            </div>
                        </c:if>

                        <form action="LoginController?acao=logarAdministrativo" method="post" name="frmManterAtleta">
                            <div class="form-group">
                                <label for="email">Login:</label>
                                <input  class="form-control" id="login" name="login" data-dismiss="alert" aria-label="close">
                            </div>

                            <div class="form-group">
                                <label for="senha">Senha:</label>
                                <input type="password" class="form-control" id="senha" name="senha">
                            </div>

                            <div class="form-group"  align="center">

                                <div class="radio-inline">
                                    <label><input type="radio" name="optUsuario" value="organizador" >Organizador</label>
                                </div>

                                <div class="radio-inline">
                                    <label><input type="radio" name="optUsuario" value="administrador">Administrador</label>
                                </div>
                            </div>




                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <button type="submit" class="btn btn-secondary btn-lg btn-block">Acessar</button>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jspf"/>

    </body>

</html>
