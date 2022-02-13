/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class LoginView extends javax.swing.JFrame {

    LoginController loginController;

    /**
     * Creates new form TelaMenuPrincipal
     */
    public LoginView(LoginController loginController) {
        initComponents();
        this.loginController = loginController;
        //this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new java.awt.Label();
        lblUsuario = new java.awt.Label();
        lblSenha = new java.awt.Label();
        edtUsuario = new javax.swing.JTextField();
        btnEntrar = new java.awt.Button();
        edtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(60, 50));
        setMinimumSize(new java.awt.Dimension(60, 50));
        setResizable(false);

        lblLogin.setAlignment(java.awt.Label.CENTER);
        lblLogin.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblLogin.setText("Login");

        lblUsuario.setText("Usuário:");

        lblSenha.setText("Senha:");

        edtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtUsuarioKeyPressed(evt);
            }
        });

        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.setLabel("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        edtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 114, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(edtSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        edtUsuario.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (verificarCampos()) {
            this.loginController.entrar(this.edtUsuario.getText(), this.edtSenha.getText());
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void edtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtSenhaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (verificarCampos()) {
                this.loginController.entrar(this.edtUsuario.getText(), this.edtSenha.getText());
            }
        }
    }//GEN-LAST:event_edtSenhaKeyPressed

    private void edtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtUsuarioKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.edtSenha.requestFocus();
        }
    }//GEN-LAST:event_edtUsuarioKeyPressed

    private boolean verificarCampos() {
        if (this.edtUsuario.getText() == null || this.edtSenha.getText().equals("")) {
            confirmacaoClose("Preencha os campos de Usuário e Senha");
            this.edtUsuario.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void confirmacaoClose(String texto) {
        JOptionPane.showMessageDialog(rootPane, texto);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnEntrar;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JTextField edtUsuario;
    private java.awt.Label lblLogin;
    private java.awt.Label lblSenha;
    private java.awt.Label lblUsuario;
    // End of variables declaration//GEN-END:variables
}
