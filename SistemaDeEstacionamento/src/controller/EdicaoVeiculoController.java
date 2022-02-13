/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import view.EdicaoVeiculoView;
import view.EntradaVeiculoView;
import view.MenuPrincipalView;

/**
 *
 * @author joaov
 */
public class EdicaoVeiculoController {
    
    private MenuPrincipalView anterior;
    private EdicaoVeiculoView edicaoVeiculoView;
    private MovimentacaoController movimentacaoController;

    public EdicaoVeiculoController(MenuPrincipalView anterior, Object[] obj, MovimentacaoController movimentacaoController) {
        this.anterior = anterior;
        this.movimentacaoController = movimentacaoController;
        this.edicaoVeiculoView = new EdicaoVeiculoView(anterior, obj, this);
    }
    
    public void open(){
        this.edicaoVeiculoView.setLocationRelativeTo(this.anterior);         
        this.edicaoVeiculoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.edicaoVeiculoView.setResizable(false);
        this.anterior.setVisible(false);
        this.edicaoVeiculoView.setVisible(true);
    }
    
    public void close(){        
        this.anterior.setVisible(true);
        this.edicaoVeiculoView.dispose();
    }
    
    public void editar(Object[] obj){
        this.movimentacaoController.alterar(obj);
    }
    
    
}
