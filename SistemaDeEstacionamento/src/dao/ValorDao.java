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
import java.util.ArrayList;
import java.util.Date;
import model.Usuario;
import model.Valor;

/**
 *
 * @author joaov
 */
public class ValorDao {
    private Valor m;

    public Object[] consultar(Object obj) {

        Object[] valor = new Object[4];
    

        try {

            PreparedStatement ps = Persistencia.conectar().prepareStatement("select * from tbl_valor order by id");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                m = new Valor();
                m.setId(Integer.parseInt(rs.getString(1)));
                m.setValor_primeira_hora(Float.parseFloat(rs.getString(2)));
                m.setValor_demais_horas(Float.parseFloat (rs.getString(3)));
                if (rs.getObject(4) == null) {
                    m.setData_fim(null);
                } else {
                    m.setData_fim((Date) rs.getObject(4));
                }
                valor[0] = m.getId();
                valor[1] = m.getValor_primeira_hora();
                valor[2] = m.getValor_demais_horas();
                valor[3] = m.getData_fim();
            }
                    
            ps.close();
            return valor;

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
