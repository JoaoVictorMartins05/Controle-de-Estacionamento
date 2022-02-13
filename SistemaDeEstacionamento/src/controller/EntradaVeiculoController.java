/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import view.EntradaVeiculoView;
import view.MenuPrincipalView;

/**
 *
 * @author joaov
 */
public class EntradaVeiculoController {

    private MenuPrincipalView anterior;
    private EntradaVeiculoView entradaVeiculoView;
    private MovimentacaoController movimentacaoController;
    
    public EntradaVeiculoController(MenuPrincipalView anterior, MovimentacaoController movimentacaoController) {
        this.anterior = anterior;
        this.entradaVeiculoView = new EntradaVeiculoView(anterior, this);
        this.movimentacaoController = movimentacaoController;
    }
      
    public void open(){
        this.entradaVeiculoView.setLocationRelativeTo(this.anterior);         
        this.entradaVeiculoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.entradaVeiculoView.setResizable(false);
        this.anterior.setVisible(false);
        this.entradaVeiculoView.setVisible(true);
    }
    
    
    public void salvar(Object[] obj){
        this.movimentacaoController.inserir(obj);
    }
    
    public void atualizarTabela(){
        anterior.carregarMovimentacaoBancoDeDados();
    }
    
    
    public void close(){        
        this.anterior.setVisible(true);
        this.entradaVeiculoView.dispose();
    }
      
    /**
     * @return the entradaVeiculoView
     */
    public EntradaVeiculoView getFrmEntradaVeiculoView() {
        return entradaVeiculoView;
    }

    /**
     * @param frmEntradaVeiculoView the entradaVeiculoView to set
     */
    public void setFrmEntradaVeiculoView(EntradaVeiculoView frmEntradaVeiculoView) {
        this.entradaVeiculoView = frmEntradaVeiculoView;
    }
    
}
