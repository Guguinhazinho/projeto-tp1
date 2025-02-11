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
    private String emailLogado;  // Novo campo para armazenar o email do usuário logado
    private static final String DIRETORIO_DADOS = "src/Dados/";
    private static final String ARQUIVO_CLIENTES = DIRETORIO_DADOS + "dados_completos_clientes.csv";

    public TelaCliente(String emailLogado) {
        this.emailLogado = emailLogado;  // Recebe o email do usuário logado
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

        carregarDadosUsuario();
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

    private void carregarDadosUsuario() {
        // Verifica se o email já existe no arquivo. Caso contrário, cria uma nova entrada com dados temporários
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_CLIENTES))) {
            String linha;
            boolean usuarioEncontrado = false;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals(emailLogado)) {  // Verifica se é o usuário logado
                    emailField.setText(dados[0]);
                    nomeField.setText(dados[1]);
                    cpfField.setText(dados[2]);
                    cepField.setText(dados[3]);
                    enderecoField.setText(dados[4]);
                    contatoField.setText(dados[5]);
                    usuarioEncontrado = true;
                    break;
                }
            }
            if (!usuarioEncontrado) {
                // Caso o usuário não seja encontrado, cria uma nova entrada com dados temporários
                emailField.setText(emailLogado);
                nomeField.setText("Preencha com seus dados");
                cpfField.setText("Preencha com seus dados");
                cepField.setText("Preencha com seus dados");
                enderecoField.setText("Preencha com seus dados");
                contatoField.setText("Preencha com seus dados");
                salvarNovoUsuario();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados do usuário: " + e.getMessage());
        }
    }

    private void salvarNovoUsuario() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_CLIENTES, true))) {
            String linha = emailLogado + ",Preencha com seus dados,Preencha com seus dados,Preencha com seus dados,Preencha com seus dados,Preencha com seus dados";
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados do cliente: " + e.getMessage());
        }
    }

    private void salvarDadosCliente() {
    File arquivoTemp = new File(DIRETORIO_DADOS + "temp.csv");
    File arquivoOriginal = new File(ARQUIVO_CLIENTES);

    try (BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal));
         BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemp))) {

        String linha;
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            if (dados[0].equals(emailLogado)) {
                linha = emailLogado + "," + nomeField.getText() + "," + cpfField.getText() + "," +
                        cepField.getText() + "," + enderecoField.getText() + "," + contatoField.getText();
            }
            bw.write(linha);
            bw.newLine();
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar os dados do cliente: " + e.getMessage());
        return; // Sai do método se ocorrer um erro
    }

    // Fecha os recursos antes de tentar excluir e renomear
    try {
        if (arquivoOriginal.exists()) {
            if (!arquivoOriginal.delete()) {
                JOptionPane.showMessageDialog(this, "Falha ao excluir o arquivo original.");
                return;
            }
        }

        if (!arquivoTemp.renameTo(arquivoOriginal)) {
            JOptionPane.showMessageDialog(this, "Falha ao renomear o arquivo temporário.");
        } else {
            JOptionPane.showMessageDialog(this, "Dados do cliente atualizados com sucesso!");
        }

    } catch (SecurityException e) {
        JOptionPane.showMessageDialog(this, "Erro de segurança ao manipular o arquivo: " + e.getMessage());
    }
}

    public static void main(String[] args) {
        String emailLogado = "exemplo@dominio.com";  // Subst   itua pelo email real do usuário logado
        SwingUtilities.invokeLater(() -> new TelaCliente(emailLogado).setVisible(true));
    }
}
