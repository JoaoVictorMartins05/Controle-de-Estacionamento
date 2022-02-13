/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author joaov
 */
public class Movimentacao {

    private int id;
    private String placa;
    private String modelo;
    private LocalDateTime data_entrada;
    private LocalDateTime data_saida;
    private float tempo;
    private float valor;
    
    
    public Movimentacao() {
    }

    public Movimentacao(int id, String placa, String modelo, LocalDateTime data_entrada, LocalDateTime data_saida, float tempo, float valor) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.tempo = tempo;
        this.valor = valor;
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
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the data_entrada
     */
    public LocalDateTime getData_entrada() {
        return data_entrada;
    }

    /**
     * @param data_entrada the data_entrada to set
     */
    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * @return the data_saida
     */
    public LocalDateTime getData_saida() {
        return data_saida;
    }

    /**
     * @param data_saida the data_saida to set
     */
    public void setData_saida(LocalDateTime data_saida) {
        this.data_saida = data_saida;
    }

    /**
     * @return the tempo
     */
    public float getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
    
    
}
