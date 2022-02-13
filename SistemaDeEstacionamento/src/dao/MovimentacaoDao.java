/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import model.Movimentacao;

/**
 *
 * @author joaov
 */
public class MovimentacaoDao implements InterfaceDao{

    private ArrayList<Object> listaMovimentacao;
    private Movimentacao movimentacao;
    private SimpleDateFormat formato;
    private SimpleDateFormat formatoBanco;
    
    @Override
    public void inserir(Object obj) {
        
        this.movimentacao = (Movimentacao) obj;
        
        try {
            PreparedStatement ps = Persistencia.conectar().prepareStatement("Insert into tbl_movimentacao (placa, modelo, data_entrada, data_saida, tempo, valor_pago)"
                    + "values (?,?,?,?,?,?)");

            Date data = new Date();       

            ps.setString(1, this.movimentacao.getPlaca());
            ps.setString(2, this.movimentacao.getModelo());
            ps.setObject(3, data);
            ps.setString(4, null);
            ps.setString(5, "0");
            ps.setString(6, "0");

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        this.formato = new SimpleDateFormat("dd/MM/yyyy");
        this.listaMovimentacao = new ArrayList<>();

        try {

            PreparedStatement ps = Persistencia.conectar().prepareStatement("select * from tbl_movimentacao order by id");
            ResultSet rs = ps.executeQuery();
            Movimentacao m = null;

            while (rs.next()) {
                m = new Movimentacao();
                m.setId(Integer.parseInt(rs.getString(1)));
                m.setPlaca(rs.getString(2));
                m.setModelo(rs.getString(3));
               
                m.setData_entrada((LocalDateTime) rs.getObject(4));
                m.setData_saida((LocalDateTime) rs.getObject(5));
                              
                m.setTempo(Float.parseFloat(rs.getString(6)));
                m.setValor(Float.parseFloat(rs.getString(7)));

                this.listaMovimentacao.add(m);
            }

            ps.close();
            return this.listaMovimentacao;

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void alterar(Object obj) {
        this.movimentacao = (Movimentacao) obj;
        
        try {
            PreparedStatement ps = Persistencia.conectar().prepareStatement("Update tbl_movimentacao set placa = ?, modelo = ?"
                    + "where id = ?");


            ps.setString(1, this.movimentacao.getPlaca());
            ps.setString(2, this.movimentacao.getModelo());
            ps.setInt(3, this.movimentacao.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public void alterarSaida(Object obj) {
        this.movimentacao = (Movimentacao) obj;
        
        try {
            PreparedStatement ps = Persistencia.conectar().prepareStatement("Update tbl_movimentacao set placa = ?, modelo = ?, data_entrada = ?, "
                    + "data_saida=?, tempo = ?, valor_pago = ?" 
                    + "where id = ?");


            ps.setString(1, this.movimentacao.getPlaca());
            ps.setString(2, this.movimentacao.getModelo());
            ps.setObject(3, this.movimentacao.getData_entrada());
            ps.setObject(4, this.movimentacao.getData_saida());
            ps.setObject(5, this.movimentacao.getTempo());
            ps.setFloat(6, this.movimentacao.getValor());
    
            
            
            
            ps.setInt(7, this.movimentacao.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    
    
    
    
    
}
