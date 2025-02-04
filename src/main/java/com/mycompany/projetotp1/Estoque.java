package com.mycompany.projetotp1;

public class Estoque {
    private String nomeProduto;
    private String codProduto;
    private int quantProduto;

    public Estoque(String nomeProduto, String codProduto, int quantProduto) {
        this.nomeProduto = nomeProduto;
        this.codProduto = codProduto;
        this.quantProduto = quantProduto;
    }

    public void avisoBaixoEstoq() {
        // Implementação do método para avisar quando o estoque está baixo
        if (quantProduto < 10) { // Exemplo de limite para aviso de estoque baixo
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

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }
}
