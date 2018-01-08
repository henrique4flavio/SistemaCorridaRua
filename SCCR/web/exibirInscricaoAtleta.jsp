
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Inscricoes do Atleta</title>
        <meta charset="UTF-8">
        <script src="./resources/bootstrap/js/jquery-3.2.1.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#idTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
        <script>
            function pesquisa(input) {

                var pesquisa = document.getElementById('search');
                location.href = 'PesquisaInscricaoController?acao=pesquisa&numero=' + pesquisa.value;
            }
        </script>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="${tipo}Home.jsp">Sistema de Corrida de Rua</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
       

        
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


        <div class="col-sm-3">
            <h2>Inscrições</h2>
        </div>
        <div class="col-sm-6">
            <input class="form-control" id="myInput" type="text" placeholder="Search..">


        </div> <!-- /#top -->
       
        <div id="list" class="row">
            <div class="table-responsive col-md-12">
                <table class="table table-striped" cellspacing="0" cellpadding="0" >
                    <thead>
                        <tr>

                            <th>Número da inscrição</th>
                            <th> Corridas </th>

                           

                        </tr>   
                        </thread>
                  <tbody id="idTable">
                        <c:forEach items="${inscricaoAtleta}" var="inscricaoAtleta">
                            <tr> 
                                <td> <c:out value="${inscricaoAtleta.numeroPeito}"/> </td>
                                <td>
                                    <c:forEach items="${provas}" var="provas">

                                        <c:if test="${provas.id == inscricaoAtleta.idProva}">${provas.nomeProva} </c:if>
                                    </c:forEach> 



                                </td>
                                   </tr>
                        </c:forEach>
                  </tbody>
                </table>


                </body>
                </html>
