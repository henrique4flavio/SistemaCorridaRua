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
        <jsp:include page="barra_superior.jspf"/>




        <div class="container">
            <h3> ${prova_id.nomeProva} - Inscrição </h3>
            <br>

            <div>
                <form action="ManterInscricaoController?acao=confirmar${operacao}" method="post" name="frmManterInscricao">

                    <div class="col-xs-8">
                        <div class="form-group">
                            <label >Código da Inscrição:</label>
                            <input type="text" name="txtnumeroPeito" class="form-control" value="${inscricao.numeroPeito}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </div>
                            <div class="form-group">
                                <label>Atleta:</label>
                                <select name="optAtleta" class="form-control selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${inscricao.atleta_id == null}"> selected</c:if>> </option>  
                                <c:forEach items="${atleta}" var="atleta">
                                    <option value="${atleta.id}" <c:if test="${atleta.id == inscricao.atleta_id}"> selected</c:if>>${atleta.nome}</option>  

                                </c:forEach>
                            </select>

                        </div>


                        <div class="form-group">
                            <label>Selecione o Kit:</label>
                            <select name="optKit" class="form-control selectpicker" id="mostra_aba3" onchange="mostrar_itens(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" id="mostra_itens" <c:if test="${inscricao.kit_id == null}" > selected</c:if>></option>                    
                                <c:forEach items="${kit}" var="kit"> 
                                    <option value="${kit.id}"  <c:if test="${kit.id == inscricao.kit_id}"> selected</c:if>>${kit.nomeKit}</option>  
                                </c:forEach>
                            </select>

                            <div class="well" style="display:none;" id="div_aba3">

                                <ul class="nav ">
                                    <li class="nav-header"><strong>Itens do Kit:</strong></li>

                                    </li>
                                    <li class="nav-header"><c:forEach items="${item}" var="item">
                                            ${item.nomeItem}
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
                            <input type="radio" name="optFormaPagamento"  id="mostra_aba1" value="Cartão de Credito" onchange="mostrar_abas(this)" /> Cartão de credito 
                            <input type="radio"  name="optFormaPagamento" id="mostra_aba2" value="Boleto Bancário"onchange="mostrar_abas(this)" /> Boleto Bancario 

                        </div>

                        <div id="div_aba2" style="display:none;">
                            <div class="col-md-3 form-group">
                                <label >CPF:</label>
                                <input type="text" name="" class="form-control" value="${inscricao.numeroPeito}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                </div>
                                <div class="col-md-9 form-group">
                                    <label >Nome:</label>
                                    <input type="text" name="" class="form-control" value="${inscricao.numeroPeito}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                </div>
                            </div>

                            <div id="div_aba1" style="display:none;">


                                <div class="row">




                                    <!-- CREDIT CARD FORM STARTS HERE -->

                                    <h3 class="panel-title display-td" >Dados do Cartão</h3>

                                    <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">



                                    <div class="panel-body">
                                        <form role="form" id="payment-form" method="POST" action="javascript:void(0);">
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <div class="form-group">
                                                        <label for="cardNumber">Número do Cartão</label>
                                                        <div class="input-group">
                                                            <input 
                                                                type="tel"
                                                                class="form-control"
                                                                name="cardNumber"
                                                                placeholder="Numero do cartão"
                                                                autocomplete="cc-number"

                                                                />
                                                            <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                                        </div>
                                                    </div>                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-7 col-md-7">
                                                    <div class="form-group">
                                                        <label for="cardExpiry"><span class="hidden-xs">Data de Validade</span><span class="visible-xs-inline">EXP</span> </label>
                                                        <input 
                                                            type="tel" 
                                                            class="form-control" 
                                                            name="cardExpiry"
                                                            placeholder="MM/AA"
                                                            autocomplete="cc-exp"

                                                            />
                                                    </div>
                                                </div>
                                                <div class="col-xs-5 col-md-5 pull-right">
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
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <div class="form-group">
                                                        <label for="couponCode">Nome como no cartão</label>
                                                        <input type="text" class="form-control" name="couponCode" />
                                                    </div>
                                                </div>                        
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-12">

                                                    <button class="subscribe btn btn-success btn-lg btn-block" type="button">Pagar R$</button>


                                                </div>

                                            </div>
                                            <div class="row" style="display:none;">
                                                <div class="col-xs-12">
                                                    <p class="payment-errors"></p>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <INPUT TYPE="hidden" NAME="prova_id" value="${prova_id.id}">


                        <div class="form-group">
                            <label for="exampleInputPassword1">Total:</label>
                            <input type="text" name="txtTotal" class="form-control" value="${inscricao.total}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                                <br>
                                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                                <a href="PesquisaAdministradorController" class="btn btn-default">Cancelar</a>

                                </form>                   
                            </div>
                        </div>
                </div>

                <div class="col-md-3">
                    <div class="sidebar-nav-fixed pull-right affix">
                        <div class="well">
                            <ul class="nav ">
                                <li class="nav-header"><h4>Resumo do pedido:</li>

                                </li>
                                <li class="nav-header">${prova_id.nomeProva}</li>
                            <li>Lote: 
                            </li>
                            <li>Kit:
                            </li>
                            <li><h4>Total: </h4>
                            </li>
                        </ul>
                    </div>
                    <!--/.well -->
                </div>
                <!--/sidebar-nav-fixed -->
            </div>
        </div>
    </body>
</html>
