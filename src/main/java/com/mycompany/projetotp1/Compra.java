package com.mycompany.projetotp1;

public class Compra {

    private double total;
    private boolean tipoPagamento;


    public Compra(double total, boolean tipoPagamento) {
        this.total = total;
        this.tipoPagamento = tipoPagamento;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(boolean tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double somaTotal(double[] valores) {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        this.total = soma;
        return soma;
    }
}
