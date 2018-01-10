

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
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="${tipo}Home.jsp">Sistema de Corrida de Rua</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
        
  
        
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        
          <li class="nav-item">
          <a class="nav-link" href="${tipo}Home.jsp">
              <i class="fa fa-user-o"></i>
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> </a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>

<div class="container">
        <c:if test="${operacao == 'Incluir'}"> <h3><span class="glyphicon glyphicon-check"></span> Cadastrar Oganizador</h3><br></c:if>
        <c:if test="${operacao == 'Editar'}"> <h3><span class="glyphicon glyphicon-edit"></span> Alterar dados</h3><br></c:if>
        <c:if test="${operacao == 'Excluir'}"> <h3><span class="glyphicon glyphicon-floppy-remove"></span> Excluir Organizador </h3><br></c:if>

            
                <div class="col-md-6">
                    
                    
                <c:if test="${tipo == 'organizador'}"><form action="ManterOrganizadorController?acao=confirmar${operacao}" method="post" name="frmManterOrganizador"></c:if>
                <c:if test="${tipo == 'administrador'}"><form action="ManterOrganizadorController?acao=confirmar${operacao}B" method="post" name="frmManterOrganizador"></c:if>

                    
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
                    <a href="${tipo}Home.jsp" class="btn btn-default">Cancelar</a>

                </form>                   
            </div> 
</div><br> <br>
<jsp:include page="footer.jspf"/>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Deseja realmente sair?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Selecione "Logout" se quiser encerrar a sessão.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="LoginController?acao=logout">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>


    </body>

</html>

