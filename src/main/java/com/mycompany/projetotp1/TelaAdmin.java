package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaAdmin {

    public static void main(String[] args) {
        Admin admin = new Admin();
        ArrayList<String> historicoEstoque = new ArrayList<>();

        while (true) {
            // Criar painel para login
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JTextField usuarioField = new JTextField(15);
            JPasswordField senhaField = new JPasswordField(15);

            panel.add(new JLabel("Usuário:"));
            panel.add(usuarioField);
            panel.add(Box.createVerticalStrut(10)); // Espaçamento
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);

            int result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Login Admin",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            // Verificação se o botão OK foi pressionado
            if (result == JOptionPane.OK_OPTION) {
                String nomeUsuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                if ("admin".equals(nomeUsuario) && "1234".equals(senha)) {
                    String[] opcoes = {"Acessar Estoque", "Acessar Histórico", "Aumentar Estoque", "Sair"};
                    boolean continuar = true;

                    while (continuar) {
                        int escolha = JOptionPane.showOptionDialog(
                                null,
                                "Escolha uma opção:",
                                "Administração",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                opcoes,
                                opcoes[0]
                        );

                        switch (escolha) {
                            case 0:
                                if (historicoEstoque.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Nenhum item foi adicionado ao estoque.", "Estoque", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    StringBuilder historico = new StringBuilder("Itens adicionados ao estoque:\n");
                                    for (String item : historicoEstoque) {
                                        historico.append("- ").append(item).append("\n");
                                    }
                                    JOptionPane.showMessageDialog(null, historico.toString(), "Estoque", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case 1:
                                JFrame historicoFrame = new JFrame("Histórico");
                                historicoFrame.setSize(400, 300);
                                historicoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JPanel historicoPanel = new JPanel();
                                historicoPanel.setLayout(new BorderLayout());

                                JLabel tituloHistorico = new JLabel("Histórico de Compras:");
                                tituloHistorico.setFont(new Font("Arial", Font.BOLD, 12));
                                tituloHistorico.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                                historicoPanel.add(tituloHistorico, BorderLayout.NORTH);

                                JButton voltarButton = new JButton("Voltar");

                                class Controle {
                                    boolean continuar = false;
                                }

                                Controle controle = new Controle();

                                voltarButton.addActionListener(e -> {
                                    historicoFrame.dispose();
                                    controle.continuar = true;
                                });

                                JPanel botaoPanel = new JPanel();
                                botaoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                                botaoPanel.add(voltarButton);

                                historicoPanel.add(botaoPanel, BorderLayout.SOUTH);

                                historicoFrame.add(historicoPanel);
                                historicoFrame.setLocationRelativeTo(null);
                                historicoFrame.setVisible(true);

                                while (!controle.continuar) {
                                }
                                break;

                            case 2:
                                String nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome do produto:", "Adicionar Estoque", JOptionPane.PLAIN_MESSAGE);
                                if (nomeProduto == null) {
                                    JOptionPane.showMessageDialog(null, "Operação cancelada. Voltando ao menu...", "Adicionar Estoque", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }

                                String quantidadeStr = JOptionPane.showInputDialog(null, "Digite a quantidade a adicionar:", "Adicionar Estoque", JOptionPane.PLAIN_MESSAGE);
                                if (quantidadeStr == null) {
                                    JOptionPane.showMessageDialog(null, "Operação cancelada. Voltando ao menu...", "Adicionar Estoque", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }

                                try {
                                    int quantidade = Integer.parseInt(quantidadeStr);
                                    admin.aumentarEstoque(nomeProduto, quantidade);
                                    historicoEstoque.add(nomeProduto + " - Quantidade: " + quantidade);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Quantidade inválida. Voltando ao menu...", "Adicionar Estoque", JOptionPane.ERROR_MESSAGE);
                                }
                                break;

                            case 3:
                                continuar = false;
                                JOptionPane.showMessageDialog(null, "Encerrando o sistema.", "Administração", JOptionPane.INFORMATION_MESSAGE);
                                break;
                        }
                    }
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Login Admin", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login cancelado.", "Login Admin", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}
