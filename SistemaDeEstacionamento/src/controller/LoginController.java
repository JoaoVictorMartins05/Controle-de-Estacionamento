/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import view.LoginView;

/**
 *
 * @author joaov
 */
public class LoginController {

    private LoginView tela;
    private MenuPrincipalController menuPrincipalController;
    private UsuarioController usuarioController;
    private ArrayList<Object[]> usuarios;
    
    
    public LoginController() {
         this.tela= new LoginView(this);
         usuarioController = new UsuarioController(this.tela);
         menuPrincipalController = new MenuPrincipalController(this.tela);
         carregarListaUsuarios();
    }
    
    
    public void visualizar(){
        this.tela.setVisible(true);
    }
    
    
    private void carregarListaUsuarios(){
        this.usuarios = this.usuarioController.carregarUsuarios();
    }
    
    
    public void entrar(String usuario, String senha){
//        usuario = "admin";
//        senha = "123456";
        for(int i = 0; i< usuarios.size(); i++){
            if(usuarios.get(i)[2].toString().equals(usuario)
                    && usuarios.get(i)[3].toString().equals(senha)){
                this.menuPrincipalController.open();
            }else{
                this.tela.confirmacaoClose("Usuário ou Senha Incorretos");
            }
        }
    }
    
}
