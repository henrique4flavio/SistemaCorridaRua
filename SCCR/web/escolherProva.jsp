<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/grid.css" />


        <jsp:include page="bootstrap.jspf"/>

    <body>
        <jsp:include page="barra_superior.jspf"/> 
        <div class="container">

            <c:forEach items="${provas}" var="prova">

                <div id="products" class="row list-group">
                    <div class="item  col-md-3">
                        <div class="thumbnail">
                            <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                            <div class="caption">
                                <h4 class="group inner list-group-item-heading">
                                    <c:out value = "${prova.nomeProva}" /></h4>
                                <p class="group inner list-group-item-text">
                                    Data: <c:out value = "${prova.dataProva}" /> <br> Horário: <c:out value = "${prova.horarioLargada}" /> </p>
                                <div class="row">
                                    <div class="col-md-5">
                                        <p class="lead">
                                        </p>
                                    </div>
                                    <div class="col-md-5">
                                        <a class="btn btn-success" href="PesquisaProvaController?acao=visualizarProva&id=${prova.id}" >Mais informações</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                </c:forEach>
            </div>
        </div>
        <jsp:include page="footer.jspf"/>
    </body>

</head>


</html>


