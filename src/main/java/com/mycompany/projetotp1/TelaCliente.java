package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCliente extends JFrame {
    private JTextField nomeField;
    private JTextField dataNascimentoField;
    private JTextField cpfField;
    private JTextField enderecoField;
    private JTextField contatoField;
    private JButton adicionarButton;
    private JButton alterarButton;
    private JButton fazerCompraButton;
    private JButton historicoButton;
    private List<Cliente> clientes = new ArrayList<>();
    


public class TelaProduto extends JFrame {
    public TelaProduto() {
        setTitle("Produtos Disponíveis");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Placeholder para produtos
        JLabel placeholder = new JLabel("Lista de produtos será implementada.");
        add(placeholder);

        // Adicionar mais componentes conforme necessário futuramente
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new TelaProduto().setVisible(true);
            }
        });
    }
}


    public TelaCliente() {
        setTitle("Gerenciar Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        nomeField = new JTextField(20);
        dataNascimentoField = new JTextField(20);
        cpfField = new JTextField(20);
        enderecoField = new JTextField(20);
        contatoField = new JTextField(20);
        adicionarButton = new JButton("Adicionar Cliente");
        alterarButton = new JButton("Alterar Dados");
        fazerCompraButton = new JButton("Fazer Compra");
        historicoButton = new JButton("Histórico de Compras");

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String cpf = cpfField.getText();
                String endereco = enderecoField.getText();
                String contato = contatoField.getText();
                Cliente cliente = new Cliente(nome, dataNascimento, cpf, endereco, contato);
                clientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                limparCampos();
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente para alterar:");
                for (Cliente cliente : clientes) {
                    if (cliente.getCpf().equals(cpf)) {
                        // Preencher os campos com os dados atuais do cliente
                        nomeField.setText(cliente.getNome());
                        dataNascimentoField.setText(cliente.getDataNascimento());
                        enderecoField.setText(cliente.getEndereco());
                        contatoField.setText(cliente.getContato());

                        // Alterar dados após preenchimento
                        int confirmar = JOptionPane.showConfirmDialog(null, "Confirma alteração dos dados?");
                        if (confirmar == JOptionPane.YES_OPTION) {
                            cliente.setNome(nomeField.getText());
                            cliente.setDataNascimento(dataNascimentoField.getText());
                            cliente.setEndereco(enderecoField.getText());
                            cliente.setContato(contatoField.getText());
                            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                        }
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        });

        fazerCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a guia de produtos
                new TelaProduto().setVisible(true);
            }
        });

        historicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder para histórico de compras
                JOptionPane.showMessageDialog(null, "Histórico vazio (Funcionalidade será implementada).");
            }
        });

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Data de Nascimento:"));
        add(dataNascimentoField);
        add(new JLabel("CPF:"));
        add(cpfField);
        add(new JLabel("Endereço:"));
        add(enderecoField);
        add(new JLabel("Contato:"));
        add(contatoField);
        add(adicionarButton);
        add(alterarButton);
        add(fazerCompraButton);
        add(historicoButton);
    }

    private void limparCampos() {
        nomeField.setText("");
        dataNascimentoField.setText("");
        cpfField.setText("");
        enderecoField.setText("");
        contatoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }
}
