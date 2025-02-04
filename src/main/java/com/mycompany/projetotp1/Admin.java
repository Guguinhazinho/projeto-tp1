package com.mycompany.projetotp1;

public class Admin {

    public void acessarEstoque() {
        System.out.println("Acessando o estoque...");
    }

    public void acessarHistorico() {
        System.out.println("Acessando o histórico de compras...");
    }

    public void aumentarEstoque(String nomeProduto, int quantidade) {
        System.out.println("Aumentando o estoque do produto: " + nomeProduto + " em " + quantidade + " unidades.");
    }
}