<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter provas</title>
       
        
    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="PesquisaProvaController?acao=gridProvas">Sistema de Corrida de Rua</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="PesquisaProvaController?acao=gridProvas">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Rankings</a>
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
                                
        <div class="container">

            <strong> <h2> ${prova.nomeProva} </h2>  </strong>                 
                            
        <div class="col-md-9 col-sm-10 no-padding-xs">
            <div class="row">  
                <div class="col-md-12">

                    <div class="description">
                        <h3><span class="glyphicon glyphicon-info-sign"></span> Sobre a prova</h3>
                        
                        
                        
                        <div class="board">
                            <div class="line">
                                
                                <div class="title">Data</div>
                                <div class="content">
                                    <p>${prova.dataProva}</p>
                                </div>
                            </div> 
                            <div class="line">
                                <div class="icon icon-map-marker"></div>
                                <div class="title">Local</div>
                                <div class="content">
                                    <p>${prova.localLargada}</p>
                                </div>
                            </div>
                            <div class="line">
                                <div class="icon icon-cronometro"></div>
                                <div class="title">Largada</div>
                                <div class="content">
                                    <p>${prova.horarioLargada}</p>
                                </div>
                            </div>
                            <div class="line botnone">
                                <div class="icon icon-ticket"></div>
                                <div class="title">Retirada de kit</div>
                                <div class="content">
                                    <p>${prova.localRetiradaKit}</p>
                                </div>
                            </div>
                                <div class="line botnone">
                                <div class="icon icon-ticket"></div>
                                <div class="title">Faixa etária</div>
                                <div class="content">
                                    <p>${prova.faixaEtaria}</p>
                                </div>
                            </div>
                                <div class="line botnone">
                                <div class="icon icon-ticket"></div>
                                <div class="title">Numero maximo de participantes</div>
                                <div class="content">
                                    <p>${prova.maxParticipantes}</p>
                                </div>
                            </div>
                                <div class="line botnone">
                                <div class="icon icon-ticket"></div>
                                <div class="title">Ranking</div>
                                <div class="content">
                                    <p><c:forEach items="${ranking}" var="ranking">
                               <c:if test="${ranking.id == prova.ranking_id}"> ${ranking.nome} </c:if> 
                            </c:forEach></p>
                                </div>
                            </div>
                        </div>



                        <h4>Período de inscrições</h4>
                        <p> De ${prova.inicioInscricao} à ${prova.fimInscricao}</p>


                        <div>
                            <h2>Dados do organizador do evento</h2>
                            <h4>Nome</h4>
                            <p><c:forEach items="${organizador}" var="organizador">
                               <c:if test="${organizador.id == prova.organizador_id}"> ${organizador.nome}</c:if> 
                            </c:forEach></p>
                            <h4>Contato</h4>
                            <p><c:forEach items="${organizador}" var="organizador">
                               <c:if test="${organizador.id == prova.organizador_id}"> ${organizador.email}</c:if> 
                            </c:forEach></p>

                        </div>
                    </div>
                </div>
                
            </div>
     <c:if test="${usuario.id == null}"> <a href="login.jsp" class="btn btn-success btn-lg" role="button"> Inscrever-se</a>  </c:if> 
     <c:if test="${usuario.id != null}"> <a href="ManterInscricaoController?acao=prepararIncluir&prova_id=${prova.id}" class="btn btn-success btn-lg" role="button"> Inscrever-se</a>  </c:if>   
            
            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAL1SURBVGhD7dlZyExhHMfxsS8XyL5lT5GtlJAtkSUlXHlTXLkSZb9wqSy5EVFKolyQG3vInpIUCldSliwpZN/C9/dOTz09/c/M0JxnzmF+9akz03k7/+fMeZbzvIV66vk3MxAH8RY/cBtLkKsMw2v8MmxDbnINViOcsch8+sAq3rcdmc8YWMX7DiPz6Y6fsBrgbEHN0hrNiodlcwpWA0QjmAaD6GmDHfiOT7gCjTwL0AtWeuMhwkbol1qB6BmBewgL8j3FEazCKLh0wmbcgRp1FJMRNU2gO/cZVvFJdMcPYRBqnm4o9YxX4is2oGaZiRcIC9OdVr+YiK14gPAcSwOiZyWsYfM5ZiCM+s91hOf71HeipgU0IoWFnEBXWBmMLwj/xncAUdMUr+AKUCdfDnX6pJyDX7RlGqJHQ6PmiGMYri9KZCGswn1XobRH8+JhtqLCnsEq3jcVykbMLx5mK5rlrcJ9l6FoUnyHC42fMpTR0FrJKt43Bcom6LNGw6H6IgvRgHADYdGh81C64D3c9/uhGxEaCa3nomUp/IKTTIDSGdaQbtEkHO0XewKrCN9Z+NkD6zzLLqSeHrAuHhoPP1o8foN1bmgdUk87WMsX32Po5SvMPFzEzQRa5mj91gpRchpWA3yaBDsic9GMvLh4WOiLSvrJfejcTGU19G4xrvFT8W7vQ7nHTDO//7ZY0wzAB6gwbXvOhYveS+4ibIBPM/p0pJoOmAStTpNYq1vtR7k+0BLr8RHheY5GLDfLVz1zoLtlXbicW1AD/PTDcVjnS2qbcY9gXbAczdKlZl+tcK3BQH2q6tGL0p/ujDjLUC47Ef5davtYWryFFytnN0q9LbpYu/Cp7WVpBl0LPdfq0EnOYC9moZJoO9WNco6Gaa0KcpUh8Bsh2jbKXRYhbEj07aBqRBt4YUNqutv4t9F7edgQzVm5ika0Nwgb0hO5Sn+EjXiJ3EVvgmFDTiJ30aN1Ca4Rmj9mI5dpizXQMiX6f6bqqef/TaHwG14j8o3n++h2AAAAAElFTkSuQmCC">
        </div>
                       
                        
                     
        </div><br><br>
            
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