<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Inscrição</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
           
        
         <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Codigo da Prova</th>
                                <th>Nome da Prova</th>
                               
                                <th class="actions">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${prova}" var="prova">
                            <tr>
                                
                                    <td><c:out value = "${prova.id}" /></td>
                                    <td><c:out value = "${prova.nomeProva}" /></td>
                                        ${prova.id} = id;
                                    
                                 
                                    <td class="actions">
                                        ManterAtletaController?acao=prepararEditar&id=' +id;
                                        <a class="btn-success" href="ManterInscricaoController?acao=prepararIncluir&prova_id=" +id  <c:out value="${administrador.id}"/>">Inscrever-se</a>
                 
                                    </td>
                                </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>

                </div> <!-- /#list -->

        
           
                      


                    
                    
            
           
    </body>
</html>