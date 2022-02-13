/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeestacionamento;

import controller.LoginController;


/**
 *
 * @author joaov
 */
public class SistemaDeEstacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         LoginController tela= new LoginController();
         tela.visualizar();      
    }
    
}
