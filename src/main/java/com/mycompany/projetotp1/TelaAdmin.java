package com.mycompany.projetotp1;

import javax.swing.*;
import java.util.ArrayList;

public class TelaAdmin {

    public static void main(String[] args) {
        Admin admin = new Admin();
        ArrayList<String> historicoEstoque = new ArrayList<>();

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
                case 0: // Acessar Estoque
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

                case 1: // Acessar Histórico
                    JOptionPane.showMessageDialog(null, "Histórico de Compras ainda não implementado.", "Histórico", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2: // Aumentar Estoque
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

                case 3: // Sair
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema.", "Administração", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    continuar = false;
                    break;
            }
        }
    }
}
