package com.mycompany.projetotp1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCompra extends JFrame {
    private JLabel jLabelPagamento, jLabelTotal, jLabelNumeroCartao, jLabelVencimento, jLabelCodigoSeguranca, jLabelNomeTitular;
    private JComboBox<String> jComboBoxPagamento;
    private JButton jButtonConfirmar;
    private JTextField jTextFieldTotal, jTextFieldNumeroCartao, jTextFieldVencimento, jTextFieldCodigoSeguranca, jTextFieldNomeTitular;

    public TelaCompra() {
        setTitle("Tela de Compra");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 1));

        jLabelPagamento = new JLabel("Selecione o tipo de pagamento:");
        jComboBoxPagamento = new JComboBox<>(new String[]{"Crédito", "Débito"});
        jComboBoxPagamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                atualizarCamposCartao();
            }
        });

        jLabelTotal = new JLabel("Total:");
        jTextFieldTotal = new JTextField("100.00");
        jTextFieldTotal.setEditable(false);

        jLabelNumeroCartao = new JLabel("Número do Cartão:");
        jTextFieldNumeroCartao = new JTextField();
        limitarEntradaNumerica(jTextFieldNumeroCartao);

        jLabelVencimento = new JLabel("Data de Vencimento:");
        jTextFieldVencimento = new JTextField();
        limitarEntradaNumerica(jTextFieldVencimento);

        jLabelCodigoSeguranca = new JLabel("Código de Segurança:");
        jTextFieldCodigoSeguranca = new JTextField();
        limitarEntradaNumerica(jTextFieldCodigoSeguranca);

        jLabelNomeTitular = new JLabel("Nome do Titular:");
        jTextFieldNomeTitular = new JTextField();

        jButtonConfirmar = new JButton("Confirmar Compra");
        jButtonConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                confirmarCompra();
            }
        });

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

    private void limitarEntradaNumerica(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
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
    }

    public static void main(String[] args) {
        new TelaCompra();
    }
}
