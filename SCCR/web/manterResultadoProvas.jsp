

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Importar Resultados Provas</title>


    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li> <c:if test="${tipo != null}"> <a href="${tipo}Home.jsp">Sistema de Corrida de Rua</a></c:if> 
                            <c:if test="${tipo == null}"> <a href="index.jsp">Sistema de Corrida de Rua</a></c:if>
                            </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="PesquisaProvaController?acao=gridProvas" ><span class=" glyphicon glyphicon-th"></span>  Provas</a> </li>

                            <li><a href="PesquisaResultadoRanking?acao=visualizarRanking"><span class="glyphicon glyphicon-list-alt"></span> Ranking</a> </li>
                            <li><a href="PesquisaResultadoProvasController?acao=visualizarProvas" ><span class="
                                                                                                         glyphicon glyphicon-expand"></span> Resultado Provas</a> </li>


                            <li><a href="${tipo}Home.jsp"><span class="glyphicon glyphicon-user"></span> 
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> 

                            </a> </li>


                    </ul>
                </div>
            </div>
        </nav>
    <center><h3>Incluir Resultados Provas</h3></center>
    <div class="container">
        <div class="col-md-6">
            <form action="PesquisaResultadoProvasController" method="post" name="frmManterProva">
                <div class="form-group">

                    <label for="exampleInputEmail1">Id Resultado Prova:</label>
                    <input type="text" name="txtId" class="form-control">

                </div>

                <div class="form-group">

                    <label for="exampleInputEmail1">Nome do Atleta:</label>
                    <input type="text" name="txtNomeAtleta" class="form-control">

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Número de Peito do Atleta:</label>
                    <input type="text" name="txtNumeroPeito" class="form-control">
                </div>
                <div class="form-group">
                    <label>Categoria do Atleta:</label>
                    <select name="txtCategoria" class="form-control">
                        <option value="Feminino">Infantil</option>
                        <option value="Masculino">Adolescente</option>
                        <option value="Masculino">Adulto</option>
                        <option value="Masculino">Idoso</option>
                    </select>
                      </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Classificação:</label>
                    <input type="text" name="txtClassificacao"class="form-control">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Tempo:</label>
                    <input type="text" name="txtTempo"class="form-control"> <h4>h/min </h4>
                </div>

                <div class="form-group">
                    <label>Sexo:</label>
                    <select name="txtSexo" class="form-control">
                        <option value="Feminino">Feminino</option>
                        <option value="Masculino">Masculino</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Nome da Prova:</label>
                    <input type="text" name="txtProva"class="form-control">
                </div>


                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="organizadorHome.jsp" class="btn btn-default">Cancelar</a> <br><br><br><br><br><br>

            </form>                   
        </div> 	
    </div>

    <jsp:include page="footer.jspf"/>

</body>

</html>




