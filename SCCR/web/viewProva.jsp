<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter provas</title>
        <script>
        function idAtleta() {
    
    var id = prompt("Digite o id do Atleta:", "id");
    if (id == null || id == "") {
        txt = "User cancelled the prompt.";
    } else {
        location.href='ManterInscricaoController';
    }
    
}
</script>
        
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <div class="container">

            <strong><h2> ${prova.nomeProva} </h2>  </strong>                 
                            
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
            <button onclick="idAtleta()" class="btn btn-success btn-lg" role="button"> Inscrever-se</a></button>
        </div>
                       
                        
                     
        </div>
            
                        <br> <br>
                        </body>
                        </html>
