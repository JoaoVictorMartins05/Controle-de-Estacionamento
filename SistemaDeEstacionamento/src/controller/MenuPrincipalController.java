/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import view.MenuPrincipalView;

/**
 *
 * @author joaov
 */
public class MenuPrincipalController {

    private MenuPrincipalView t;
    private JFrame anterior;
    
    public MenuPrincipalController(JFrame anterior) {
        this.anterior = anterior; 
        t = new MenuPrincipalView(anterior);
    }
    
    
    public void open(){
        this.t.setLocationRelativeTo(this.anterior);         
        this.t.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.t.setResizable(false);
        this.anterior.dispose();
        this.t.setVisible(true);
    }
    
    
}
