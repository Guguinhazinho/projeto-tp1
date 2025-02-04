package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaEstoque extends JFrame {
    private JTextField nomeProdutoField;
    private JTextField codProdutoField;
    private JTextField quantProdutoField;
    private JButton adicionarButton;
    private JButton mostrarProdutosButton;
    private JTextArea produtosTextArea;
    private List<Estoque> produtos = new ArrayList<>();

    public TelaEstoque() {
        setTitle("Gerenciar Estoque");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        nomeProdutoField = new JTextField(20);
        codProdutoField = new JTextField(20);
        quantProdutoField = new JTextField(20);
        adicionarButton = new JButton("Adicionar Produto");
        mostrarProdutosButton = new JButton("Mostrar Produtos do Estoque");
        produtosTextArea = new JTextArea(10, 30);
        produtosTextArea.setEditable(false);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto = nomeProdutoField.getText();
                String codProduto = codProdutoField.getText();
                int quantProduto = Integer.parseInt(quantProdutoField.getText());
                Estoque produto = new Estoque(nomeProduto, codProduto, quantProduto);
                produtos.add(produto);
                limparCampos();
            }
        });

        mostrarProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaProdutos();
            }
        });

        add(new JLabel("Nome do Produto:"));
        add(nomeProdutoField);
        add(new JLabel("Código do Produto:"));
        add(codProdutoField);
        add(new JLabel("Quantidade do Produto:"));
        add(quantProdutoField);
        add(adicionarButton);
        add(mostrarProdutosButton);
        add(new JScrollPane(produtosTextArea));
    }

    private void atualizarListaProdutos() {
        produtosTextArea.setText("");
        for (Estoque produto : produtos) {
            produtosTextArea.append(produto.getCodProduto() + 
                                    " " + produto.getNomeProduto() + 
                                    " - " + produto.getQuantProduto() + " Unidades" + "\n");
        }
    }

    private void limparCampos() {
        nomeProdutoField.setText("");
        codProdutoField.setText("");
        quantProdutoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaEstoque().setVisible(true);
            }
        });
    }
}
