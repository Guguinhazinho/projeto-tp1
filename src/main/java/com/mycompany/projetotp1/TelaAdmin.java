package com.mycompany.projetotp1;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;

public class TelaAdmin {
    private JFrame frame;
    private JButton btnAcessarEstoque;
    private JButton btnAcessarHistorico;
    private JButton btnAumentarEstoque;
    private JButton btnSair;
    private Admin admin;
    private ArrayList<String> historicoEstoque;
    
    private static final String DIRETORIO_DADOS = "src/Dados/";
    
    public TelaAdmin() {
        admin = new Admin();
        historicoEstoque = new ArrayList<>();

        
        frame = new JFrame("Administração");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        btnAcessarEstoque = new JButton("Acessar Estoque");
        btnAcessarEstoque.setBounds(100, 30, 200, 30);
        btnAcessarEstoque.addActionListener(e -> acessarEstoque());
        frame.add(btnAcessarEstoque);

        btnAcessarHistorico = new JButton("Acessar Histórico");
        btnAcessarHistorico.setBounds(100, 70, 200, 30);
        btnAcessarHistorico.addActionListener(e -> acessarHistorico());
        frame.add(btnAcessarHistorico);

        btnAumentarEstoque = new JButton("Aumentar Estoque");
        btnAumentarEstoque.setBounds(100, 110, 200, 30);
        btnAumentarEstoque.addActionListener(e -> aumentarEstoque());
        frame.add(btnAumentarEstoque);

        btnSair = new JButton("Sair");
        btnSair.setBounds(100, 150, 200, 30);
        btnSair.addActionListener(e -> sair());
        frame.add(btnSair);

        frame.setVisible(true);
    }

    private void acessarEstoque() {
        if (historicoEstoque.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nenhum item foi adicionado ao estoque.", "Estoque", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder historico = new StringBuilder("Itens adicionados ao estoque:\n");
            for (String item : historicoEstoque) {
                historico.append("- ").append(item).append("\n");
            }
            JOptionPane.showMessageDialog(frame, historico.toString(), "Estoque", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void acessarHistorico() {
        JOptionPane.showMessageDialog(frame, "Histórico de Compras ainda não implementado.", "Histórico", JOptionPane.INFORMATION_MESSAGE);
    }

    private void aumentarEstoque() {
        String nomeProduto = JOptionPane.showInputDialog(frame, "Digite o nome do produto:", "Adicionar Estoque", JOptionPane.PLAIN_MESSAGE);
        if (nomeProduto == null) {
            JOptionPane.showMessageDialog(frame, "Operação cancelada. Voltando ao menu...", "Adicionar Estoque", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String precoProduto = JOptionPane.showInputDialog(frame, "Digite o preço do produto:", "Adicionar Estoque", JOptionPane.PLAIN_MESSAGE);
        if (precoProduto == null) {
            JOptionPane.showMessageDialog(frame, "Operação cancelada. Voltando ao menu...", "Adicionar Estoque", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        String quantidadeStr = JOptionPane.showInputDialog(frame, "Digite a quantidade a adicionar:", "Adicionar Estoque", JOptionPane.PLAIN_MESSAGE);
        if (quantidadeStr == null) {
            JOptionPane.showMessageDialog(frame, "Operação cancelada. Voltando ao menu...", "Adicionar Estoque", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

         try {
                        int quantidade = Integer.parseInt(quantidadeStr);
                        int preco = Integer.parseInt(precoProduto);
                        admin.aumentarEstoque(nomeProduto,preco, quantidade);
                        historicoEstoque.add(nomeProduto +" - Preço: "+ preco+ " - Quantidade: " + quantidade);
                        
                        // Adicionar ao arquivo Produtos.csv
                        try (FileWriter writer = new FileWriter(DIRETORIO_DADOS + "Produtos.csv", true)) {
                            writer.write(nomeProduto +","+ preco +"," + quantidade + "\n");
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "Erro ao salvar no arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Quantidade inválida. Voltando ao menu...", "Adicionar Estoque", JOptionPane.ERROR_MESSAGE);
                    }
    }

    private void sair() {
        frame.dispose();
    }

    public static void main(String[] args) {
        new TelaAdmin();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
