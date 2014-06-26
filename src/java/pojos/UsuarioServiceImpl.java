/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    public Usuario find(String nombre){
        
        return usuarioDao.find(nombre);
        
    }
    
    public boolean delete(Usuario u){
        try{
        usuarioDao.delete(u);
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<Usuario>listar(){
        
        return usuarioDao.listar();
    }
    
    public boolean insertarUsuario(Usuario u){
        
        try{
            
            usuarioDao.insertarUsuario(u);
            
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
            
            return false;
        }
        
        return true;
    }
    
    
    
}
