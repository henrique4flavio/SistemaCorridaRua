

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter organizador</title>

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


                            <li><a href="administradorHome.jsp" ><span class="glyphicon glyphicon-user"></span> 
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> 

                            </a> </li>

                        </li>
                    </ul>
                </div>
            </div>
        </nav>

<div class="container">
        <c:if test="${operacao == 'Incluir'}"> <h3><span class="glyphicon glyphicon-check"></span> Cadastrar Oganizador</h3><br></c:if>
        <c:if test="${operacao == 'Editar'}"> <h3><span class="glyphicon glyphicon-edit"></span> Alterar dados</h3><br></c:if>
        <c:if test="${operacao == 'Excluir'}"> <h3><span class="glyphicon glyphicon-floppy-remove"></span> Excluir Organizador </h3><br></c:if>

            
                <div class="col-md-6">
                    <form action="ManterOrganizadorController?acao=confirmar${operacao}" method="post" name="frmManterOrganizador">
                    <div class="form-group">

                        <label for="exampleInputEmail1">Código do organizador:</label>
                        <input type="text" name="txtIdOrganizador" class="form-control" value="${organizador.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Nome:</label>
                            <input type="text" name="txtNomeOrganizador" class="form-control" value="${organizador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Email:</label>
                            <input type="text" name="txtEmail" class="form-control" value="${organizador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Login:</label>
                            <input type="text" name="txtLogin" class="form-control" value="${organizador.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>


                        <div class="form-group">
                            <label>Administrador:</label>
                            <select class="form-control" name="optAdministrador"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${organizador.administrador_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${administrador}" var="administrador">
                                <option value="${administrador.id}" <c:if test="${administrador.id == organizador.administrador_id}"> selected</c:if>>${administrador.nome}</option>  
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Senha:</label>
                        <input type="password" id="senha" name="txtSenha" class="form-control" value="${organizador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Confirmar Senha:</label>
                            <input type="password" name="txtValidadaSenha" class="form-control" oninput="validaSenha(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>

                    <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                    <a href="PesquisaOrganizadorController" class="btn btn-default">Cancelar</a>

                </form>                   
            </div> 
</div><br> <br>
<jsp:include page="footer.jspf"/>

    </body>

</html>

