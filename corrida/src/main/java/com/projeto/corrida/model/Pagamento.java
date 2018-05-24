package com.projeto.corrida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue
    private Long id;

    private float valorTotal;
    private boolean status;
    private String tipoPagamento;
    private String codigoBarra;

    public Pagamento(Long id, float valorTotal, boolean status, String tipoPagamento, String codigoBarra) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.status = status;
        this.tipoPagamento = tipoPagamento;
        this.codigoBarra = codigoBarra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
