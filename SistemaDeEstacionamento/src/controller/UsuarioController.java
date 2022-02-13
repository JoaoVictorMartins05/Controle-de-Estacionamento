/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.Usuario;
import view.MenuPrincipalView;

/**
 *
 * @author joaov
 */
public class UsuarioController {

    private JFrame anterior;
    private Usuario paciente;
    private UsuarioDao usuarioDao;
    
    
    
    public UsuarioController(JFrame anterior) {
        this.usuarioDao = new UsuarioDao();       
        this.anterior = anterior;       
    }
    

        
    
    public ArrayList<Object []> carregarUsuarios(){
        
        ArrayList<Object []> arrayObjUsuario = new ArrayList<>();  
        ArrayList<Object> arrayObj = usuarioDao.consultar(null);
               
        for(int i=0;i<arrayObj.size();i++){
              Object [] arrayObjAux = new Object[4];
              arrayObjAux[0] = ((Usuario)arrayObj.get(i)).getId();
              arrayObjAux[1] = ((Usuario)arrayObj.get(i)).getNome();
              arrayObjAux[2] = ((Usuario)arrayObj.get(i)).getUsuario();
              arrayObjAux[3] = ((Usuario)arrayObj.get(i)).getSenha();             
                
              arrayObjUsuario.add(arrayObjAux);
        }
        
        return arrayObjUsuario;
    }
    
    
    public void excluir(Object[] obj){
        transformar(obj);
        usuarioDao.excluir(this.paciente);
    }
    
    public void inserir(Object[] obj){
        transformar(obj);
        usuarioDao.inserir(this.paciente);
    }
    
    public void alterar(Object[] obj){
        transformar(obj);
        usuarioDao.alterar(this.paciente);
    }
    
    
    private void transformar (Object [] obj){
        this.paciente = new Usuario();
        
        if(obj[0] != null){
            paciente.setId((int) obj[0]);
        }
                
        paciente.setNome((String) obj[1]);
        paciente.setUsuario((String) obj[2]);
        paciente.setSenha((String) obj[3]);        
    }
}
