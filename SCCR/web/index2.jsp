<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SCCR</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="PesquisaProvaController?acao=gridProvas">Sistema de Corrida de Rua</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Rankings</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="resultadoProvas.jsp"> <span class="glyphicon glyphicon-user"></span> Resultado Provas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="registro.jsp"> <span class="glyphicon glyphicon-user"></span> Registrar-se</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.jsp"> <span class="glyphicon glyphicon-user"></span> Entrar</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
        <h1 class="display-3">Bem Vindo!</h1>
        <p class="lead">Sistema de Controle de Corrida de Rua desenvolvido para obtenção de nota na disciplina de Laboratório de Programação II.</p>
        <a href="registro.jsp" class="btn btn-primary btn-lg">Registrar</a>
      </header>

      <!-- Page Features -->
      <div class="row text-center">

           <c:forEach items="${provas}" var="prova">
        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
            <div class="card-body">
              <h4 class="card-title"><c:out value = "${prova.nomeProva}" /></h4>
              <p class="card-text">Data: <c:out value = "${prova.dataProva}" /> <br> Horário: <c:out value = "${prova.horarioLargada}" /> </p>
            </div>
            <div class="card-footer">
              <a class="btn btn-success" href="PesquisaProvaController?acao=visualizarProva&id=${prova.id}" >Mais informações</a>
          </div>
        </div>
          
        </div>
          </c:forEach>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Sccr 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>


