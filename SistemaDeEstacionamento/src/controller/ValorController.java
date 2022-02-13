/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ValorDao;

/**
 *
 * @author joaov
 */
public class ValorController {

    private ValorDao valorDao;
    
    public ValorController() {
        this.valorDao = new ValorDao();
    }
    
     
    public Object[] carregarValor(){
        Object[] obj = this.valorDao.consultar(null);
        return obj;
    }
    
    
}
