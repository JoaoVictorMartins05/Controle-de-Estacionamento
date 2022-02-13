/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joaov
 */
public class Persistencia {
    private static Connection conexao = null;
    
    private Persistencia() throws SQLException{
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Estacionamento", "root", "admin");
    }
    
    
    public static Connection conectar() throws SQLException{
        if(conexao == null){
            new Persistencia();          
        }
        return conexao;
    }
    
    public static void Desconnection() throws SQLException{
        conexao.close();
    }
     
}
