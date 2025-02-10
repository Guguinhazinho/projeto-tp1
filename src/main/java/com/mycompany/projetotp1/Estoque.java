package com.mycompany.projetotp1;

public class Estoque {
    private String nomeProduto;
    private float valorProduto; // Alterado para float
    private int quantProduto;

    public Estoque(String nomeProduto, float valorProduto, int quantProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantProduto = quantProduto;
    }

    public void avisoBaixoEstoq() {
        if (quantProduto < 10) { 
            System.out.println("Aviso: Estoque baixo para o produto " + nomeProduto);
        }
    }

    // Getters e setters
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }
}
