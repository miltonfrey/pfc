/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.ArrayList;
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
    
    @Override
    public Usuario find(String nombre){
        
        return usuarioDao.find(nombre);
        
    }
    
    @Override
    public boolean delete(Usuario u){
        try{
        usuarioDao.delete(u);
        }catch(Exception ex){    //ver que exception es
            return false;
        }
        return true;
    }
    
    @Override
    public List<Usuario>listar(){
        
        List<Usuario> lista= (ArrayList<Usuario>)usuarioDao.listar();
        Usuario u=usuarioDao.find("admin");
        lista.remove(u);
        return lista;
    }
    
    @Override
    public void insertarUsuario(Usuario u){
        
        
            
            usuarioDao.insertarUsuario(u);
}
    @Override
    public void actualizar(Usuario u){
        
        
        usuarioDao.actualizar(u);
        
        
    }
    @Override
    public String md5Password(String password){
        
       return usuarioDao.md5Password(password);
    }

    
    
}