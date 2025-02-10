package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TelaEstoque extends JFrame {
    private JTextField nomeProdutoField;
    private JTextField valorProdutoField;
    private JTextField quantProdutoField;
    private JComboBox<String> produtosComboBox;
    private JButton adicionarButton;
    private JButton editarButton;
    private JButton mostrarProdutosButton;
    private JTextArea produtosTextArea;
    private List<Estoque> produtos = new ArrayList<>();
    private final String FILE_PATH = "src/Dados/Produtos.csv"; // Caminho do CSV

    public TelaEstoque() {
        setTitle("Gerenciar Estoque");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        nomeProdutoField = new JTextField(20);
        valorProdutoField = new JTextField(20);
        quantProdutoField = new JTextField(20);
        produtosComboBox = new JComboBox<>();
        adicionarButton = new JButton("Adicionar Produto");
        editarButton = new JButton("Editar Produto");
        mostrarProdutosButton = new JButton("Mostrar Produtos do Estoque");
        produtosTextArea = new JTextArea(10, 30);
        produtosTextArea.setEditable(false);

        carregarProdutosDoArquivo(); // Carregar produtos do CSV ao abrir a tela

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProduto();
            }
        });

        mostrarProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaProdutos();
            }
        });

        produtosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecionarProduto();
            }
        });

        add(new JLabel("Nome do Produto:"));
        add(nomeProdutoField);
        add(new JLabel("Valor do Produto:"));
        add(valorProdutoField);
        add(new JLabel("Quantidade do Produto:"));
        add(quantProdutoField);
        add(new JLabel("Selecionar Produto:"));
        add(produtosComboBox);
        add(adicionarButton);
        add(editarButton);
        add(mostrarProdutosButton);
        add(new JScrollPane(produtosTextArea));
    }

    private void adicionarProduto() {
        String nomeProduto = nomeProdutoField.getText();
        float valorProduto;
        int quantProduto;

        try {
            valorProduto = Float.parseFloat(valorProdutoField.getText()); // Converte para float
            quantProduto = Integer.parseInt(quantProdutoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor ou quantidade inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estoque produto = new Estoque(nomeProduto, valorProduto, quantProduto);
        produtos.add(produto);
        salvarProdutoNoArquivo(produto);
        atualizarComboBox();
        limparCampos();
    }

    private void editarProduto() {
        int selectedIndex = produtosComboBox.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nomeProduto = nomeProdutoField.getText();
        float valorProduto;
        int quantProduto;

        try {
            valorProduto = Float.parseFloat(valorProdutoField.getText()); // Converte para float
            quantProduto = Integer.parseInt(quantProdutoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor ou quantidade inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estoque produtoSelecionado = produtos.get(selectedIndex);
        produtoSelecionado.setNomeProduto(nomeProduto);
        produtoSelecionado.setValorProduto(valorProduto);
        produtoSelecionado.setQuantProduto(quantProduto);
        atualizarArquivoProdutos();
        atualizarListaProdutos();
        atualizarComboBox();
        limparCampos();
    }

    private void selecionarProduto() {
        int selectedIndex = produtosComboBox.getSelectedIndex();
        if (selectedIndex == -1) return;

        Estoque produtoSelecionado = produtos.get(selectedIndex);
        nomeProdutoField.setText(produtoSelecionado.getNomeProduto());
        valorProdutoField.setText(String.valueOf(produtoSelecionado.getValorProduto()));
        quantProdutoField.setText(String.valueOf(produtoSelecionado.getQuantProduto()));
    }

    private void atualizarListaProdutos() {
        produtosTextArea.setText("");
        for (Estoque produto : produtos) {
            produtosTextArea.append(produto.getNomeProduto() + " - " +
                                    produto.getValorProduto() + " - " +
                                    produto.getQuantProduto() + " Unidades\n");
        }
    }

    private void atualizarComboBox() {
        produtosComboBox.removeAllItems();
        for (Estoque produto : produtos) {
            produtosComboBox.addItem(produto.getNomeProduto());
        }
    }

    private void limparCampos() {
        nomeProdutoField.setText("");
        valorProdutoField.setText("");
        quantProdutoField.setText("");
    }

    private void salvarProdutoNoArquivo(Estoque produto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(produto.getNomeProduto() + "," + produto.getValorProduto() + "," + produto.getQuantProduto() + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o produto!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarArquivoProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Estoque produto : produtos) {
                writer.write(produto.getNomeProduto() + "," + produto.getValorProduto() + "," + produto.getQuantProduto() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar o arquivo de produtos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarProdutosDoArquivo() {
        produtos.clear();
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    String nome = partes[0];
                    float valor = Float.parseFloat(partes[1]); // Converte para float
                    int quantidade = Integer.parseInt(partes[2]);
                    produtos.add(new Estoque(nome, valor, quantidade));
                }
            }
            atualizarComboBox();
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaEstoque().setVisible(true));
    }
}
