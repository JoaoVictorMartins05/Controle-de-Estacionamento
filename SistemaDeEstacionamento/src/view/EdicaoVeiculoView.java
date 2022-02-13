/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EdicaoVeiculoController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class EdicaoVeiculoView extends javax.swing.JFrame {

     private MenuPrincipalView anterior;
     EdicaoVeiculoController edicaoVeiculoController;
     private Object[] movimentacao;
    
    
    public EdicaoVeiculoView(MenuPrincipalView anterior, Object[] obj, EdicaoVeiculoController edicaoVeiculoController) {
        this.anterior = anterior;
        this.movimentacao = obj;
        this.edicaoVeiculoController = edicaoVeiculoController;
        initComponents();
        preencherCampos();
    }
    
    private void preencherCampos(){
        this.edtPlaca.setText((String) movimentacao[1]);  
        this.edtModelo.setText((String) movimentacao[2]);           
    }
    
    private boolean verificarCampos(){
        if(this.edtModelo.getText().equals("") || this.edtPlaca.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos!");
            return false;
        }else{
            return true;
        }
    }
    

    private void preencherMovimentacao(){
        this.movimentacao[1] = this.edtPlaca.getText();
        this.movimentacao[2] = this.edtModelo.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edtModelo = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        edtPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        edtModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadNovo.png"))); // NOI18N
        btnAdicionar.setText("atualizar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadCancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Edição de Veículo");

        lblPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlaca.setText("Placa:");

        lblModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblModelo.setText("Modelo: ");

        edtPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlaca)
                            .addComponent(lblModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addGap(57, 57, 57)
                                .addComponent(btnCancelar))
                            .addComponent(edtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addComponent(edtModelo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(edtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(edtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(verificarCampos()){
            preencherMovimentacao();
            edicaoVeiculoController.editar(movimentacao);
            this.anterior.atualizarTabela();
            edicaoVeiculoController.close();
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.edicaoVeiculoController.close();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.anterior.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField edtModelo;
    private javax.swing.JTextField edtPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    // End of variables declaration//GEN-END:variables
}
