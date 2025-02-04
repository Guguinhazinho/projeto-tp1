/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetotp1;

/**
 *
 * @author LUCAS
 */
public class Produto {
    private String codigo;
    private String tipo;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto(String codigo, String tipo, String descricao, int quantidade, double preco) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean conferirEstoque(int quantidadeDesejada) {
        return quantidade >= quantidadeDesejada;
    }

    public boolean adicionarCarrinho(int quantidadeDesejada) {
        if (conferirEstoque(quantidadeDesejada)) {
            quantidade -= quantidadeDesejada; 
            return true; 
        }
        return false; 
    }

    
}

