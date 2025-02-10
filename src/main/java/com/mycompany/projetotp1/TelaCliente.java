package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TelaCliente extends JFrame {
    private JTextField emailField, nomeField, cpfField, cepField, enderecoField, contatoField;
    private JButton editarButton, fazerCompraButton, historicoButton;
    private boolean isEditing = false;
    private static final String DIRETORIO_DADOS = "src/Dados/";
    private static final String ARQUIVO_CLIENTES = DIRETORIO_DADOS + "UserDB.csv";
    private static final String ARQUIVO_COMPLETO = DIRETORIO_DADOS + "dados_completos_clientes.csv";

    public TelaCliente() {
        setTitle("Gerenciar Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        Color backgroundColor = new Color(45, 45, 45);
        Color buttonBackgroundColor = new Color(69, 73, 74);
        Color textColor = Color.WHITE;

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBackground(backgroundColor);

        emailField = createTextField("Email", panel, textColor, backgroundColor);
        nomeField = createTextField("Nome", panel, textColor, backgroundColor);
        cpfField = createTextField("CPF", panel, textColor, backgroundColor);
        cepField = createTextField("CEP", panel, textColor, backgroundColor);
        enderecoField = createTextField("Endereço", panel, textColor, backgroundColor);
        contatoField = createTextField("Telefone de Contato", panel, textColor, backgroundColor);

        editarButton = createButton("Adicionar/Editar Dados", buttonBackgroundColor, textColor);
        fazerCompraButton = createButton("Fazer Compra", buttonBackgroundColor, textColor);
        historicoButton = createButton("Histórico de Compras", buttonBackgroundColor, textColor);

        editarButton.addActionListener(e -> toggleEditingMode());
        fazerCompraButton.addActionListener(e -> new TelaProdutos().setVisible(true));
        historicoButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Histórico vazio (Funcionalidade será implementada)."));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(editarButton);
        buttonPanel.add(fazerCompraButton);
        buttonPanel.add(historicoButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        carregarEmail();
    }

    private JTextField createTextField(String label, JPanel panel, Color textColor, Color backgroundColor) {
        JLabel jLabel = new JLabel(label + ":");
        jLabel.setForeground(textColor);
        JTextField textField = new JTextField(20);
        textField.setBackground(backgroundColor);
        textField.setForeground(textColor);
        textField.setEditable(false);
        panel.add(jLabel);
        panel.add(textField);
        return textField;
    }

    private JButton createButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setBackground(background);
        button.setForeground(foreground);
        return button;
    }

    private void toggleEditingMode() {
        isEditing = !isEditing;
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                for (Component innerComp : ((JPanel) comp).getComponents()) {
                    if (innerComp instanceof JTextField) {
                        ((JTextField) innerComp).setEditable(isEditing);
                    }
                }
            }
        }
        if (!isEditing) {
            salvarDadosCliente();
            JOptionPane.showMessageDialog(null, "Dados do cliente atualizados com sucesso!");
        }
    }

    private void carregarEmail() {
        File diretorio = new File(DIRETORIO_DADOS);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_CLIENTES))) {
            String linha;
            if ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length > 0) {
                    emailField.setText(dados[0]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar email: " + e.getMessage());
        }
    }

    private void salvarDadosCliente() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_COMPLETO, true))) {
            String linha = emailField.getText() + "," + nomeField.getText() + "," + cpfField.getText() + "," +
                           cepField.getText() + "," + enderecoField.getText() + "," + contatoField.getText();
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados do cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCliente().setVisible(true));
    }
}
