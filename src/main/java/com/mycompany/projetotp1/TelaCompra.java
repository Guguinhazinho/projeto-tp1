package com.mycompany.projetotp1;

import javax.swing.*;

public class TelaCompra extends javax.swing.JFrame {

    public TelaCompra() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("Selecione o tipo de pagamento:");

        // Configurando o JComboBox
        jComboBoxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito"}));

        jButtonConfirmar.setText("Confirmar Compra");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelTotal.setText("Total:");

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextFieldTotal.setText("100.00"); // Apenas um exemplo, o valor real viria de outra lógica de cálculo
        jTextFieldTotal.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        String tipoPagamento = jComboBoxPagamento.getSelectedItem().toString(); // Obtém o tipo de pagamento selecionado
        String total = jTextFieldTotal.getText(); // Obtém o total da compra

        Compra compra = new Compra(Double.parseDouble(total), tipoPagamento.equals("Cartão"));

        // Exibe uma mensagem com os detalhes da compra
        JOptionPane.showMessageDialog(this, "Compra realizada:\n" +
                "Total: R$ " + compra.getTotal() + "\n" +
                "Tipo de pagamento: " + tipoPagamento, "Recibo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCompra().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JTextField jTextFieldTotal;
}
