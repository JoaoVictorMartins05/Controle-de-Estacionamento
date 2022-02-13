/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SaidaVeiculoController;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author joaov
 */

public class SaidaVeiculoView extends javax.swing.JFrame {

    private MenuPrincipalView anterior;
    private SaidaVeiculoController saidaVeiculoController;
    private Object[] movimentacao;


    public SaidaVeiculoView(MenuPrincipalView anterior, SaidaVeiculoController saidaVeiculoController, Object[] obj ) {
        this.movimentacao = obj;
        this.anterior = anterior;
        this.saidaVeiculoController = saidaVeiculoController;
        initComponents();
        desabilitarCampos();
        preencherCampos();
    }

    public void desabilitarCampos() {
        this.edtHorarioEntrada.setEditable(false);
        this.edtHorarioSaida.setEditable(false);
        this.edtModelo.setEditable(false);
        this.edtPlaca.setEditable(false);
        this.edtTempo.setEditable(false);
        this.edtValor.setEditable(false);
    }
    
    
    public String converterData(Object obj){
        String data = obj.toString();
        String resultado = "";
        resultado = data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4) + " - " + data.substring(11, 19);
        return resultado;
    }
    
    
    public void preencherCampos(){     

        LocalDateTime fim = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        
        Object tempo = calcularTempo(fim);
        
        if(Integer.parseInt(tempo.toString()) == 0){
            tempo = 1;
        }
        
        
        Object valor = calcularValor(tempo);
        
        this.edtPlaca.setText((String) movimentacao[1]);
        this.edtModelo.setText((String) movimentacao[2]);
        this.edtHorarioEntrada.setText(converterData(movimentacao[3]));
        this.edtHorarioSaida.setText(converterData(fim));
        
        this.movimentacao[4] = fim;
        
        this.edtTempo.setText((String) tempo.toString() + " Hora(s)");
             
        this.movimentacao[5] = tempo;
        
        this.edtValor.setText("R$: "+(String) valor.toString());
        
        this.movimentacao[6] = valor;
    }
    
    
    private int calcularTempo(LocalDateTime fim){
        LocalDateTime inicio = (LocalDateTime) movimentacao[3];
        return (int) inicio.until( fim, ChronoUnit.HOURS);
    }
    
    
    private float calcularValor(Object obj){
        int tempo = (int) obj;
        float valorTotal;
        Object[] valor = this.saidaVeiculoController.getValor();
        if(tempo>1){
            valorTotal = (float) valor[1] + ((tempo-1) * ((float) valor[2]));
        }else{
            valorTotal = (float) valor[1];
        }
               
        return valorTotal;       
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPlaca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        btnSaida = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        lblSaída = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        edtPlaca = new javax.swing.JTextField();
        edtModelo = new javax.swing.JTextField();
        edtTempo = new javax.swing.JTextField();
        edtHorarioSaida = new javax.swing.JTextField();
        edtValor = new javax.swing.JTextField();
        lblEntrada = new javax.swing.JLabel();
        edtHorarioEntrada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlaca.setText("Placa:");

        lblModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblModelo.setText("Modelo: ");

        btnSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadNovo.png"))); // NOI18N
        btnSaida.setText("Confirmar Saída");
        btnSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaidaActionPerformed(evt);
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
        jLabel1.setText("Saída de Veículo");

        lblTempo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTempo.setText("Tempo:");

        lblSaída.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSaída.setText("Horário de Saída:");

        lblValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValor.setText("Valor:");

        edtPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPlacaActionPerformed(evt);
            }
        });

        edtModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtTempo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtHorarioSaida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEntrada.setText("Horário de Entrada:");

        edtHorarioEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnSaida)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPlaca)
                                    .addComponent(lblModelo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtPlaca)
                                    .addComponent(edtModelo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTempo)
                                .addGap(22, 22, 22)
                                .addComponent(edtTempo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEntrada)
                                    .addComponent(lblSaída))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtHorarioSaida)
                                    .addComponent(edtHorarioEntrada))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPlaca)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(edtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(edtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEntrada)
                    .addComponent(edtHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaída)
                    .addComponent(edtHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempo)
                    .addComponent(edtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaida)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaidaActionPerformed
        this.saidaVeiculoController.salvar(movimentacao);
        this.anterior.atualizarTabela();
        this.saidaVeiculoController.close();
    }//GEN-LAST:event_btnSaidaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.saidaVeiculoController.close();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void edtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPlacaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.anterior.setVisible(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSaida;
    private javax.swing.JTextField edtHorarioEntrada;
    private javax.swing.JTextField edtHorarioSaida;
    private javax.swing.JTextField edtModelo;
    private javax.swing.JTextField edtPlaca;
    private javax.swing.JTextField edtTempo;
    private javax.swing.JTextField edtValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblSaída;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblValor;
    // End of variables declaration//GEN-END:variables
}
