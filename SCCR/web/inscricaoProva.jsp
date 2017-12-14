<%-- 
    Document   : inscricaoProva
    Created on : 08/12/2017, 00:22:28
    Author     : Familia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="bootstrap.jspf"/>

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>

        <!-- If you're using Stripe for payments -->
        <script type="text/javascript" src="https://js.stripe.com/v2/"></script>
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

        <style type= "text/css ">
            div{
                border: solid 2px;
                width: 500px;
                height: 300px;
            }
        </style>

    </head>


    <body>
        <div class="container">



            <form action="">
                <label> <input type="radio" name="gender" id="mostra_aba1" onchange="mostrar_abas(this)" /> Pagar com Cartão </label>
                <label><input type="radio" name="gender" id="mostra_aba2" onchange="mostrar_abas(this)" /> Boleto Bancario </label>

            </form>

            <div id="div_aba1" style="display:none;">


                <div class="row">
       
                    <div class="col-xs-12 col-md-4">


                        <!-- CREDIT CARD FORM STARTS HERE -->
                        <div class="panel panel-default credit-card-box">
                            <div class="panel-heading display-table" >
                                <div class="row display-tr" >
                                    <h3 class="panel-title display-td" >Dados do Cartão</h3>
                                    <div class="display-td" >                            
                                        <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
                                    </div>
                                </div>                    
                            </div>
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
                                                        required autofocus 
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
                                                    required 
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
                                                    required
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
                </div>
            </div>

            <div id="div_aba2" style="display:none;">
                Conteúdo da aba 2
            </div>
            

        </div>
    </div>  


</body>
</html>
