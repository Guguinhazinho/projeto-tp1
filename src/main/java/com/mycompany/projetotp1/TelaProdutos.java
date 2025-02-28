
package com.mycompany.projetotp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author lucas
 */
public class TelaProdutos extends javax.swing.JFrame {

    /**
     * Creates new form Produtos
     */
    
    private static final String DIRETORIO_DADOS = "src/Dados/";
    public TelaProdutos() {
        initComponents();
         String filePath = DIRETORIO_DADOS + "Produtos.csv";
        File file = new File(filePath);
        
        try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {
            DefaultTableModel modeloTabela = (DefaultTableModel) jTable3.getModel();
            String linha;
            modeloTabela.setRowCount(0); 
        
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(","); 
                modeloTabela.addRow(dados);       
            } 
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar os dados do arquivo.");
        }
        
        
       
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("Nome do Produto");

        jButton1.setText("Adicionar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Comprar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Produto", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Quantidade");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Procurar Produto:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Total: ");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Produto", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextField4.setBorder(null);

        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                        .addGap(142, 142, 142))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))
                        .addContainerGap(70, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed
    private void getSum(){
        double total = 0.0;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Pega os valores de preço e quantidade da tabela
            double preco = Double.parseDouble(model.getValueAt(i, 2).toString());  // Preço está na terceira coluna (índice 2)
            int quantidade = Integer.parseInt(model.getValueAt(i, 1).toString());  // Quantidade está na segunda coluna (índice 1)

            // Soma o valor total (preço * quantidade)
            total += preco * quantidade;
    }

    // Exibe o total formatado no TextField
    jTextField4.setText(String.format("%.2f", total));
    }
    
    
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
       DefaultTableModel model = (DefaultTableModel) jTable2.getModel(); // Tabela do carrinho

        // Pega o nome do produto e a quantidade inseridos pelo usuário
        String nomeProduto = jTextField1.getText();
        String quantidadeTexto = jTextField2.getText();

        // Verifica se os campos não estão vazios
        if (nomeProduto.isEmpty() || quantidadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        // Verifica se a quantidade é um número válido
        int quantidadeDesejada;
        try {
            quantidadeDesejada = Integer.parseInt(quantidadeTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Por favor, insira um número.");
            return;
        }
        
        // Verifica se o produto já está no carrinho
        for (int i = 0; i < model.getRowCount(); i++) {
            String produtoExistente = model.getValueAt(i, 0).toString(); // Nome do produto na tabela
            if (produtoExistente.equalsIgnoreCase(nomeProduto)) {
                JOptionPane.showMessageDialog(this, "O produto já está no carrinho!");
                return; // Sai do método para evitar a duplicação
            }
    }
        // Caminho do arquivo de produtos
        String caminhoArquivo = DIRETORIO_DADOS + "Produtos.csv";

        // Verificar no arquivo se o produto existe e se há quantidade suficiente
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean produtoEncontrado = false;

            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(","); // Divide os dados pelo separador ","
                String nome = dados[0];
                double preco = Double.parseDouble(dados[1]);
                int quantidadeDisponivel = Integer.parseInt(dados[2]);

                // Verifica se o nome do produto corresponde
                if (nome.equalsIgnoreCase(nomeProduto)) {
                    produtoEncontrado = true;

                    // Verifica se a quantidade desejada está disponível
                    if (quantidadeDesejada <= quantidadeDisponivel && quantidadeDesejada != 0) {
                        // Adiciona o produto ao carrinho
                        model.addRow(new Object[]{nome, quantidadeDesejada, preco});
                        JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Quantidade insuficiente para o produto " + nomeProduto);
                    }
                    break;
                }
            }

            if (!produtoEncontrado) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado: " + nomeProduto);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao acessar o arquivo.");
            return;
        }
        getSum();
    }                                     
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jTable2.setModel(new DefaultTableModel(null,new String[]{"Nome do Produto","Quantidade","Preço"}));
        double zero = 0;
        jTextField4.setText(String.format("%.2f", zero));
        
    }//GEN-LAST:event_jButton2MouseClicked
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel(); // Tabela do carrinho

        // Pega o nome do produto e a quantidade inseridos pelo usuário
        String nomeProduto = jTextField1.getText();
        String quantidadeTexto = jTextField2.getText();

        // Verifica se os campos não estão vazios
        if (nomeProduto.isEmpty() || quantidadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        // Verifica se a quantidade é um número válido
        int quantidadeDesejada;
        try {
            quantidadeDesejada = Integer.parseInt(quantidadeTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Por favor, insira um número.");
            return;
        }
    // Criar e exibir a tela de pagamento
    String total = jTextField4.getText();
    TelaCompra telaPagamento = new TelaCompra(total);
    telaPagamento.setVisible(true);
}


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String textoFiltro = jTextField3.getText().trim(); // Obtém o texto do campo de busca
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable3.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabela);

        jTable3.setRowSorter(sorter); // Configura o sorter na tabela

        // Aplica o filtro
        if (textoFiltro.isEmpty()) {
            sorter.setRowFilter(null); // Mostra todos os itens
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro)); // Filtro insensível a maiúsculas/minúsculas
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new TelaProdutos().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
