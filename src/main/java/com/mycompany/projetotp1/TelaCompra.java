package com.mycompany.projetotp1;

import javax.swing.JOptionPane;

public class TelaCompra {
    public static void main(String[] args) {
        Compra compra;
        compra = new Compra(0, true);

        JOptionPane.showMessageDialog(
                null,
                "Compra realizada:\n" +
                        "Total: R$ " + compra.getTotal() + "\n" +
                        "Tipo de pagamento: " + (compra.isTipoPagamento() ? "Cartão" : "Dinheiro"),
                "Tela de Compras",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
