/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author joaov
 */
public class Valor {

    private int id;
    private float valor_primeira_hora;
    private float valor_demais_horas;
    private Date data_fim;
    
      
    public Valor() {
    }

    public Valor(int id, float valor_primeira_hora, float valor_demais_horas, Date data_fim) {
        this.id = id;
        this.valor_primeira_hora = valor_primeira_hora;
        this.valor_demais_horas = valor_demais_horas;
        this.data_fim = data_fim;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the valor_primeira_hora
     */
    public float getValor_primeira_hora() {
        return valor_primeira_hora;
    }

    /**
     * @param valor_primeira_hora the valor_primeira_hora to set
     */
    public void setValor_primeira_hora(float valor_primeira_hora) {
        this.valor_primeira_hora = valor_primeira_hora;
    }

    /**
     * @return the valor_demais_horas
     */
    public float getValor_demais_horas() {
        return valor_demais_horas;
    }

    /**
     * @param valor_demais_horas the valor_demais_horas to set
     */
    public void setValor_demais_horas(float valor_demais_horas) {
        this.valor_demais_horas = valor_demais_horas;
    }

    /**
     * @return the data_fim
     */
    public Date getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
    
    
    
    
    
}
