
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
        <jsp:include page="barra_superior.jspf"/>



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
                    
                </table>


                </body>
                </html>
