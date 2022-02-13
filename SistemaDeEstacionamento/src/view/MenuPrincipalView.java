/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EdicaoVeiculoController;
import controller.EntradaVeiculoController;
import controller.MovimentacaoController;
import controller.SaidaVeiculoController;
import controller.UsuarioController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author joaov
 */
public class MenuPrincipalView extends javax.swing.JFrame {

    private JFrame anterior;

    private ArrayList<Object[]> listaMovimentacao;
    private Object[] movimentacao;

    private SimpleDateFormat formato;
    private SimpleDateFormat formatoBanco;

    private boolean isEstacionado;

    private UsuarioController usuarioController;
    private EntradaVeiculoController entradaVeiculoController;
    private EdicaoVeiculoController edicaoVeiculoController;
    private SaidaVeiculoController saidaVeiculoController;
    private MovimentacaoController movimentacaoController;

    
    public MenuPrincipalView(JFrame anterior) {
        initComponents();
        movimentacaoController = new MovimentacaoController();
        this.listaMovimentacao = new ArrayList<>();
        this.anterior = anterior;
        this.isEstacionado = true;
        this.formato = new SimpleDateFormat("dd/MM/yyyy");
        this.formatoBanco = new SimpleDateFormat("yyyy/MM/dd");
        this.carregarMovimentacaoBancoDeDados();
        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
            MaskFormatter maskTelefone = new MaskFormatter("(##) #####-####");

        } catch (ParseException ex) {
            Logger.getLogger(MenuPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String converterData(Object obj){
        String data = obj.toString();
        String resultado = "";
        resultado = data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4) + " - " + data.substring(11, 19);
        return resultado;
    }

    public void atualizarTabela() {
        Date data = null;
        if (!isEstacionado) {
            String[] colunas = {"ID", "Placa", "Modelo", "Horário de Entrada", "Horário de Saida", "Tempo (Horas)", "Valor (R$)"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);

            this.btnSaidaVeiculo.setEnabled(false);
            

            for (int i = 0; i < this.listaMovimentacao.size(); i++) {
                if (listaMovimentacao.get(i)[4] != null) {
                    Object[] linha = {
                        listaMovimentacao.get(i)[0],
                        listaMovimentacao.get(i)[1],
                        listaMovimentacao.get(i)[2],
                        converterData(listaMovimentacao.get(i)[3]),
                        converterData(listaMovimentacao.get(i)[4]),
                        listaMovimentacao.get(i)[5],
                        listaMovimentacao.get(i)[6],};

                    model.addRow(linha);
                }
            }
            this.tblVeiculos.setModel(model);

        } else {

            String[] colunas = {"ID", "Placa", "Modelo", "Horário de Entrada"};
            this.btnSaidaVeiculo.setEnabled(true);
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            

            for (int i = 0; i < this.listaMovimentacao.size(); i++) {
                if (listaMovimentacao.get(i)[4] == null) {
                    Object[] linha = {
                        listaMovimentacao.get(i)[0],
                        listaMovimentacao.get(i)[1],
                        listaMovimentacao.get(i)[2],
                        converterData(listaMovimentacao.get(i)[3])
                    };
                    model.addRow(linha);
                }
                
            }
            this.tblVeiculos.setModel(model);
        }

    }

    public void consultar(String nome) {
        for (int i = 0; i < listaMovimentacao.size(); i++) {
            movimentacao = listaMovimentacao.get(i);
            if (movimentacao[1].toString().toUpperCase().contains(nome)) {
                for (int j = 0; j < tblVeiculos.getRowCount(); j++) {
                    if ((int) tblVeiculos.getValueAt(j, 0) == (int) movimentacao[0]) {
                        tblVeiculos.setRowSelectionInterval(j, j);
                    }
                }
            }
        }
    }

    public void alterarMovimentacao(boolean isSaida) {
        int id;
        if (tblVeiculos.getSelectedRow() != -1) {
            id = (int) tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 0);

            movimentacao = buscarMovimentacao(id);
            if (movimentacao == null) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um  veículo na tabela");
            } else {
                if (!isSaida) {
                    edicaoVeiculoController = new EdicaoVeiculoController(this, movimentacao, this.movimentacaoController);
                    edicaoVeiculoController.open();
                } else {
                    saidaVeiculoController = new SaidaVeiculoController(this, this.movimentacaoController, this.movimentacao);
                    saidaVeiculoController.open();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um  veículo na tabela");
        }
    }

    public Object[] buscarMovimentacao(int id) {
        for (int i = 0; i < listaMovimentacao.size(); i++) {
            if ((int) listaMovimentacao.get(i)[0] == id) {
                return listaMovimentacao.get(i);
            }
        }
        return null;
    }
      

    public void carregarMovimentacaoBancoDeDados() {
        listaMovimentacao = this.movimentacaoController.carregarMovimentacao();
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        btnEntradaVeiculo = new javax.swing.JButton();
        btnEditarVeiculo = new javax.swing.JButton();
        btnSaidaVeiculo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        edtConsulta = new javax.swing.JTextField();
        CbxFiltro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Estacionamento");

        tblVeiculos.setAutoCreateRowSorter(true);
        tblVeiculos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVeiculos);

        btnEntradaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEntradaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadNovo.png"))); // NOI18N
        btnEntradaVeiculo.setText("Entrada de Veículo");
        btnEntradaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaVeiculoActionPerformed(evt);
            }
        });

        btnEditarVeiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadEdit.png"))); // NOI18N
        btnEditarVeiculo.setText("Editar Veículo");
        btnEditarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVeiculoActionPerformed(evt);
            }
        });

        btnSaidaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaidaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        btnSaidaVeiculo.setText("Saída de Veículo");
        btnSaidaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaidaVeiculoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Consulta");

        edtConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtConsultaActionPerformed(evt);
            }
        });
        edtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtConsultaKeyReleased(evt);
            }
        });

        CbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veículos Estacionados", "Veículos que Saíram" }));
        CbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(318, 318, 318))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEntradaVeiculo)
                        .addGap(27, 27, 27)
                        .addComponent(btnEditarVeiculo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaidaVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(edtConsulta)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntradaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaidaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(edtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmacaoClose();
    }//GEN-LAST:event_formWindowClosing

    private void btnEntradaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaVeiculoActionPerformed
        entradaVeiculoController = new EntradaVeiculoController(this, this.movimentacaoController);
        entradaVeiculoController.open();
    }//GEN-LAST:event_btnEntradaVeiculoActionPerformed

    private void btnEditarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVeiculoActionPerformed
        this.alterarMovimentacao(false);
    }//GEN-LAST:event_btnEditarVeiculoActionPerformed

    private void btnSaidaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaidaVeiculoActionPerformed
        this.alterarMovimentacao(true);
    }//GEN-LAST:event_btnSaidaVeiculoActionPerformed

    private void edtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtConsultaKeyReleased
        consultar(this.edtConsulta.getText().toUpperCase());
    }//GEN-LAST:event_edtConsultaKeyReleased

    private void edtConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtConsultaActionPerformed

    private void CbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxFiltroActionPerformed

        JComboBox cb = (JComboBox) evt.getSource();
        String petName = (String) cb.getSelectedItem();
        //System.out.println(petName);

        if (petName == "Veículos Estacionados") {
            isEstacionado = true;
            atualizarTabela();
        } else {
            isEstacionado = false;
            atualizarTabela();
        }


    }//GEN-LAST:event_CbxFiltroActionPerformed

    private void confirmacaoClose() {
        int input = JOptionPane.showConfirmDialog(this,
                "Você tem certeza que deseja fechar essa janela?", "Fechar Janela?",
                JOptionPane.YES_NO_OPTION);

        if (input == 1) {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxFiltro;
    private javax.swing.JButton btnEditarVeiculo;
    private javax.swing.JButton btnEntradaVeiculo;
    private javax.swing.JButton btnSaidaVeiculo;
    private javax.swing.JTextField edtConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables
}
