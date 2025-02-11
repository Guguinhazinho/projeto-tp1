package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCompra extends JFrame {
    private JLabel jLabelPagamento, jLabelTotal, jLabelNumeroCartao, jLabelVencimento, jLabelCodigoSeguranca, jLabelNomeTitular;
    private JComboBox<String> jComboBoxPagamento;
    private JButton jButtonConfirmar;
    private JTextField jTextFieldTotal, jTextFieldNumeroCartao, jTextFieldVencimento, jTextFieldCodigoSeguranca, jTextFieldNomeTitular;

    public TelaCompra(String total) {
        setTitle("Tela de Compra");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(10, 1));

        jLabelPagamento = new JLabel("Selecione o tipo de pagamento:");
        jComboBoxPagamento = new JComboBox<>(new String[]{"Crédito", "Débito"});
        jComboBoxPagamento.addActionListener(evt -> atualizarCamposCartao());

        jLabelTotal = new JLabel("Total:");
        jTextFieldTotal = new JTextField(total);
        jTextFieldTotal.setEditable(false);

        jLabelNumeroCartao = new JLabel("Número do Cartão:");
        jTextFieldNumeroCartao = new JTextField();
        limitarEntradaNumerica(jTextFieldNumeroCartao, -1); // Sem limite fixo

        jLabelVencimento = new JLabel("Data de Vencimento:");
        jTextFieldVencimento = new JTextField();
        limitarFormatoVencimento(jTextFieldVencimento);

        jLabelCodigoSeguranca = new JLabel("Código de Segurança:");
        jTextFieldCodigoSeguranca = new JTextField();
        limitarEntradaNumerica(jTextFieldCodigoSeguranca, 3); // Máximo 3 dígitos

        jLabelNomeTitular = new JLabel("Nome do Titular:");
        jTextFieldNomeTitular = new JTextField();
        limitarEntradaTexto(jTextFieldNomeTitular);

        jButtonConfirmar = new JButton("Confirmar Compra");
        jButtonConfirmar.addActionListener(evt -> confirmarCompra());

        add(jLabelPagamento);
        add(jComboBoxPagamento);
        add(jLabelTotal);
        add(jTextFieldTotal);
        add(jLabelNumeroCartao);
        add(jTextFieldNumeroCartao);
        add(jLabelVencimento);
        add(jTextFieldVencimento);
        add(jLabelCodigoSeguranca);
        add(jTextFieldCodigoSeguranca);
        add(jLabelNomeTitular);
        add(jTextFieldNomeTitular);
        add(jButtonConfirmar);

        atualizarCamposCartao();
        setVisible(true);
    }

    private void limitarEntradaNumerica(JTextField textField, int maxLength) {
    textField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();

            if (!Character.isDigit(c)) {
                e.consume();
                return;
            }

            String text = textField.getText().replaceAll("\\s", ""); // Remove espaços existentes
            if (maxLength > 0 && text.length() >= maxLength) {
                e.consume();
                return;
            }

            // Insere um espaço a cada 4 dígitos
            if (text.length() > 0 && text.length() % 4 == 0) {
                textField.setText(textField.getText() + " ");
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                String text = textField.getText();
                if (text.length() > 0 && text.charAt(text.length() - 1) == ' ') {
                    textField.setText(text.substring(0, text.length() - 1)); // Remove o espaço ao apagar
                }
            }
        }
    });
}

    private void limitarFormatoVencimento(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textField.getText();

                if (!Character.isDigit(c) || text.length() >= 5) {
                    e.consume();
                    return;
                }

                if (text.length() == 2) {
                    textField.setText(text + "/");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    String text = textField.getText();
                    if (text.length() == 3) {
                        textField.setText(text.substring(0, 2)); // Remove a barra ao apagar
                    }
                }
            }
        });
    }

    private void limitarEntradaTexto(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isISOControl(c)) {
                    e.consume();
                }
            }
        });
    }

    private void atualizarCamposCartao() {
        boolean exibirCampos = jComboBoxPagamento.getSelectedItem().equals("Crédito") || jComboBoxPagamento.getSelectedItem().equals("Débito");
        jLabelNumeroCartao.setVisible(exibirCampos);
        jTextFieldNumeroCartao.setVisible(exibirCampos);
        jLabelVencimento.setVisible(exibirCampos);
        jTextFieldVencimento.setVisible(exibirCampos);
        jLabelCodigoSeguranca.setVisible(exibirCampos);
        jTextFieldCodigoSeguranca.setVisible(exibirCampos);
        jLabelNomeTitular.setVisible(exibirCampos);
        jTextFieldNomeTitular.setVisible(exibirCampos);
    }

    private void confirmarCompra() {
        String tipoPagamento = (String) jComboBoxPagamento.getSelectedItem();
        String total = jTextFieldTotal.getText();
        String numeroCartao = jTextFieldNumeroCartao.getText().trim();
        String vencimento = jTextFieldVencimento.getText().trim();
        String codigoSeguranca = jTextFieldCodigoSeguranca.getText().trim();
        String nomeTitular = jTextFieldNomeTitular.getText().trim();

        if (("Crédito".equals(tipoPagamento) || "Débito".equals(tipoPagamento)) &&
                (numeroCartao.isEmpty() || vencimento.isEmpty() || codigoSeguranca.isEmpty() || nomeTitular.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos do cartão.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Compra realizada com " + tipoPagamento.toLowerCase() + "!\nTotal: R$ " + total,
                "Recibo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        new TelaCompra("0.00");
    }
}
