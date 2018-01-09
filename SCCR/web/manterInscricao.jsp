<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Inscrição</title>

        <!-- If you're using Stripe for payments -->
        <script>
          function atualizaPrecoKit(kit){
           var valorKit=   document.getElementById('kit'+kit).value;
             document.getElementById('mostraKit').innerHTML=valorKit;
             var valorProva= document.getElementById('mostraProva').innerHTML;
              document.getElementById('mostraTotal').innerHTML=parseInt(valorProva)+parseInt(valorKit);
               document.getElementById('txtTotal').value=parseInt(valorProva)+parseInt(valorKit);
             
             
           
          }  
    </script>
        <script>
            function mostrar_abas(obj) {

                document.getElementById('div_aba1').style.display = "none";
                document.getElementById('div_aba2').style.display = "none";

                switch (obj.id) {
                    case 'mostra_aba1':
                        document.getElementById('div_aba1').style.display = "block";
                        break
                    case 'mostra_aba2':
                        document.getElementById('div_aba2').style.display = "block";
                        break
                }
            }
            
        </script>
        <script>
            function mostrar_itens(obj) {

                document.getElementById('div_aba3').style.display = "none";

                switch (obj.id) {
                    case 'mostra_aba3':
                        document.getElementById('div_aba3').style.display = "block";
                        break

                }
            }

        </script>

        
    </head>

    <body>
        




        <div class="container">
            <h3> ${prova_id.nomeProva} - Inscrição </h3>
            <br>

            <div>
                <form action="ManterInscricaoController?acao=confirmar${operacao}" method="post" name="frmManterInscricao">

                    <div class="col-xs-8">
                        <div class="form-group">
                            <label >Código da Inscrição:</label>
                            <input type="text" name="txtid" class="form-control" value="${inscricao.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </div>
                            <INPUT TYPE="hidden" NAME="optAtleta" value="${usuario.id}">
                                 <div class="form-group">
                                     <label> Escolha a Categoria:  </label><br>
                                     <label>   <input type="radio" name="optCategoria"  id="mostra_aba1" value="infantil"  /> Infantil</label> <br>
                          <label>  <input type="radio"  name="optCategoria" id="mostra_aba2" value="Adulto" />Adulto</label><br>
                        <label>   <input type="radio"  name="optCategoria" id="mostra_aba2" value="Idoso" />Idoso</label><br>
                         <label>   <input type="radio"  name="optCategoria" id="mostra_aba2" value="Adolescente" />Adolescente</label><br>

                        </div>



                        <div class="form-group">
                            <label>Selecione o Kit:</label>
                            <select name="optKit"onChange="atualizaPrecoKit(this.value)" class="form-control selectpicker" id="mostra_aba3" onchange="mostrar_itens(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" id="mostra_itens" <c:if test="${inscricao.kit_id == null}" > selected</c:if>></option>                    
                                <c:forEach items="${kit}" var="kit"> 
                                    <option value="${kit.id}"  <c:if test="${kit.id == inscricao.kit_id}"> selected</c:if>>${kit.nomeKit}-${kit.valor}</option>  
                              
                                </c:forEach>
                                                                </select>

                            <c:forEach items="${kit}" var="kit"> 
                                    <input type="hidden" value ="${kit.valor}" id="kit${kit.id}"/>
                              
                                </c:forEach>

                            <div class="well" style="display:none;" id="div_aba3">

                                <ul class="nav ">
                                    <li class="nav-header"><strong>Itens do Kit:</strong></li>

                                    </li>
                                    <li class="nav-header"><c:forEach items="${item}" var="item">
                                            ${item.nomeItem}<br>
                                    </c:forEach></li>


                                </ul>
                            </div>

                            <!--/.well -->
                        </div>
                        <!--/sidebar-nav-fixed -->




                        <div class="form-group">
                            <label>Selecione o Percurso:</label>
                            <select name="optPercurso" class="form-control selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${inscricao.percurso_id == null}"> selected</c:if>> </option>  
                                <c:forEach items="${percurso}" var="percurso">
                                    <option value="${percurso.id}" <c:if test="${percurso.id == inscricao.percurso_id}"> selected</c:if>>${percurso.nome}</option>  
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label> Escolha a Forma de Pagamento:  </label>
                            <label> <input type="radio"  name="optFormaPagamento" id="mostra_aba1" value="1" onchange="mostrar_abas(this)" /> Cartão de credito </label>
                            <label> <input type="radio"  name="optFormaPagamento" id="mostra_aba2" value="0"onchange="mostrar_abas(this)" /> Boleto Bancario </label>

                        </div>

                        <div id="div_aba2" style="display:none;">
                            <div class="col-md-3 form-group">
                                <label >CPF:</label>
                                <input type="text" id="cpf" onkeyPress =""onKeyPress="MascaraCPF(this)"onBlur="ValidarCPF(this)"class="form-control" value="${inscricao.numeroPeito}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                </div>
                                <div class="col-md-9 form-group">
                                    <label >Nome:</label>
                                    <input type="text" name="" class="form-control" value="${inscricao.numeroPeito}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                </div>
                            </div>
  <div id="div_aba1" style="display:none;">
                                
                                <!-- CREDIT CARD FORM STARTS HERE -->

                                    <h3 class="panel-title display-td" >Dados do Cartão</h3>

                                    <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">



                                    <div class="panel-body">
                                        <form role="form" id="payment-form" method="POST" action="javascript:void(0);">
                                            <div class="row">
                                                <div class="col-md-9">
                                                    <div class="form-group">
                                                        <label for="cardNumber">Número do Cartão</label>
                                                        <div class="input-group">
                                                            <input 
                                                                type="tel"
                                                                class="form-control"
                                                                name="cardNumber"
                                                                placeholder="Numero do cartão"
                                                                autocomplete="cc-number"

                                                               
                                                            <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                                        </div>
                                                    </div>                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="cardExpiry"><span class="hidden-xs">Data de Validade</span><span class="visible-xs-inline">EXP</span> </label>
                                                        <input 
                                                            type="tel" 
                                                            class="form-control" 
                                                            name="cardExpiry"
                                                            placeholder="MM/AA"
                                                            autocomplete="cc-exp"

                                                          
                                                    </div>
                                                </div>
                                                <div class="col-md-7">
                                                    <div class="form-group">
                                                        <label for="cardCVC">Codigo de Segurança</label>
                                                        <input 
                                                            type="tel" 
                                                            class="form-control"
                                                            name="cardCVC"
                                                            placeholder="CVC"
                                                            autocomplete="cc-csc"

                                                            />
                                                    </div>
                                                </div>
                                            </div>
                                            
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label for="couponCode">Nome como no cartão</label>
                                                        <input type="text" class="form-control" name="couponCode" />
                                                    </div>
                                                </div>                        
                                          
                                            
                                                <div class="col-md-7">
             <a class="nav-link btn btn-success btn-block" data-toggle="modal" data-target="#exampleModal" href="login.html">Pagar com Cartão</a>



                                                </div>

                                            </div>
                                            <div class="row" style="display:none;">
                                                <div class="col-xs-12">
                                                    <p class="payment-errors"></p>
                                                </div>
                                            </div>
                                       
                                    </div>
                                </div>
                            </div>
                            <INPUT TYPE="hidden" NAME="prova_id" value="${prova_id.id}">
   
                        <div class="form-group">
                           
                            <input type="hidden" id="txtTotal" name="txtTotal" class="form-control" value="${inscricao.total}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                                <br>
                                
                                <br>
                                <button type="submit" name="btnConfirmar" class="btn btn-success" value="Confirmar">Finalizar</button>
                        </div>

                        
                                <a href="PesquisaAdministradorController" class="btn btn-default">Cancelar</a>
                            
                            </form>                     
                            </div>
                       
					   </form>
                        <br> <br>
                <div class="col-md-3">
                    <span class="border-0">
                        <div class="well">
                            <ul class="nav ">
                                <li class="nav-header"><h4>Resumo do pedido:</li>

                                </li>
                                <li class="nav-header">${prova_id.nomeProva}</li>
        <li>: R$ <span id="mostraProva">${prova_id.valorTotal}</span>
                            </li>
                            <li> Kit: 
                                <span id="mostraKit"> </span>
                            </li>
                            <li><h4>Total:<span id="mostraTotal"></span>  </h4>
                            </li>
                        </ul>
                    </div>
                            <br> <br
                                <br> <br
                    <!--/.well -->
                </span></div>
                <!--/sidebar-nav-fixed -->
        </div>
		 </form>
              <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Pagamento Efetuado com Sucesso!</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Pressione "Finalizar" logo abaixo para concluir sua inscrição.</div>
          <div class="modal-footer">
            <button class="btn btn-success" type="button" data-dismiss="modal">Fechar</button>
           
          </div>
        </div>
      </div>
    </div>               
                            
    
    
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
