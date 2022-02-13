/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovimentacaoDao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import model.Movimentacao;

/**
 *
 * @author joaov
 */
public class MovimentacaoController {

    private MovimentacaoDao movimentacaoDao;
    private Movimentacao movimentacao;

    public MovimentacaoController() {
        this.movimentacaoDao = new MovimentacaoDao();
    }

    public ArrayList<Object[]> carregarMovimentacao() {

        ArrayList<Object[]> arrayObjAtendente = new ArrayList<>();
        ArrayList<Object> arrayObj = movimentacaoDao.consultar(null);

        for (int i = 0; i < arrayObj.size(); i++) {
            Object[] arrayObjAux = new Object[8];
            arrayObjAux[0] = ((Movimentacao) arrayObj.get(i)).getId();
            arrayObjAux[1] = ((Movimentacao) arrayObj.get(i)).getPlaca();
            arrayObjAux[2] = ((Movimentacao) arrayObj.get(i)).getModelo();
            arrayObjAux[3] = ((Movimentacao) arrayObj.get(i)).getData_entrada();
            arrayObjAux[4] = ((Movimentacao) arrayObj.get(i)).getData_saida();
            arrayObjAux[5] = ((Movimentacao) arrayObj.get(i)).getTempo();
            arrayObjAux[6] = ((Movimentacao) arrayObj.get(i)).getValor();
            
           
            arrayObjAtendente.add(arrayObjAux);
        }

        return arrayObjAtendente;
    }
    
    
    public void alterar(Object[] obj) {
        transformar(obj);
        movimentacaoDao.alterar(this.movimentacao);
    }
    
    
    public void alterarSaida(Object[] obj) {
        transformar(obj);
        movimentacaoDao.alterarSaida(this.movimentacao);
    }

    public void inserir(Object[] obj) {
        transformar(obj);
        movimentacaoDao.inserir(this.movimentacao);
    }

    private void transformar(Object[] obj) {
        this.movimentacao = new Movimentacao();

        if (obj[0] != null) {
            movimentacao.setId((int) obj[0]);
        }

        movimentacao.setPlaca((String) obj[1]);
        movimentacao.setModelo((String) obj[2]);
        movimentacao.setData_entrada((LocalDateTime) obj[3]);
        movimentacao.setData_saida((LocalDateTime) obj[4]);
        
        if (obj[5] == null) {
            movimentacao.setTempo(0);
        } else {
            movimentacao.setTempo(Float.parseFloat(obj[5].toString()));
        }

        if (obj[6] == null) {
            movimentacao.setValor(0);
        } else {
            movimentacao.setValor(Float.parseFloat(obj[6].toString()));
        }       
    }

}
