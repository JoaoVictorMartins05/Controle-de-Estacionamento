/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import view.EdicaoVeiculoView;
import view.MenuPrincipalView;
import view.SaidaVeiculoView;

/**
 *
 * @author joaov
 */
public class SaidaVeiculoController {

    private MenuPrincipalView anterior;
    private SaidaVeiculoView saidaVeiculoView;
    private MovimentacaoController movimentacaoController;
    private ValorController valorController;

    public SaidaVeiculoController(MenuPrincipalView anterior, MovimentacaoController movimentacaoController, Object[] obj) {
        this.anterior = anterior;
        this.valorController = new ValorController();
        this.saidaVeiculoView = new SaidaVeiculoView(anterior, this, obj);
        this.movimentacaoController = movimentacaoController;
    }

    public void open() {
        this.saidaVeiculoView.setLocationRelativeTo(this.anterior);
        this.saidaVeiculoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.saidaVeiculoView.setResizable(false);
        this.anterior.setVisible(false);
        this.saidaVeiculoView.setVisible(true);
    }

    public void close() {
        this.anterior.setVisible(true);
        this.saidaVeiculoView.dispose();
    }

    public void salvar(Object[] obj) {
        this.movimentacaoController.alterarSaida(obj);
    }

    public void atualizarTabela() {
        anterior.carregarMovimentacaoBancoDeDados();
    }

    public Object[] getValor() {
        return this.valorController.carregarValor();
    }
}
