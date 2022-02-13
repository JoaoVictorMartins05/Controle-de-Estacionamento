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
import model.Usuario;

/**
 *
 * @author joaov
 */
public class UsuarioDao implements InterfaceDao {

    private ArrayList<Object> listaUsuarios;
    private Usuario usuario;



    @Override
    public ArrayList<Object> consultar(Object obj) {

        this.listaUsuarios = new ArrayList<>();

        try {

            PreparedStatement ps = Persistencia.conectar().prepareStatement("select * from tbl_usuario order by id");
            ResultSet rs = ps.executeQuery();
            
            //System.out.println(rs);
            Usuario m = null;

            while (rs.next()) {
                m = new Usuario();
                m.setId(Integer.parseInt(rs.getString(1)));
                m.setNome(rs.getString(2));
                m.setUsuario(rs.getString(3));
                m.setSenha(rs.getString(4));
                
                this.listaUsuarios.add(m);

            }
            ps.close();
            return listaUsuarios;

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    @Override
    public void inserir(Object obj) {

    }

    @Override
    public void alterar(Object obj) {

    }

    @Override
    public void excluir(Object obj) {
    }

}
