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
import pojos.Exceptions.PasswordIncorrectoException;
import pojos.Exceptions.UsuarioNotFoundException;

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
    @Transactional(readOnly = true)
    public Usuario find(String nombre)throws UsuarioNotFoundException{
        
        Usuario u=usuarioDao.find(nombre);
        if(u==null){
            throw new UsuarioNotFoundException();
        }
        
        return u;
    }
    
    @Override
    public void delete(Usuario u){
        
        usuarioDao.delete(u);
       
    }
    
    @Override
    @Transactional(readOnly = true)
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

    
    @Override
    public void autenticarUsuario(String password,Usuario u)throws PasswordIncorrectoException{
        
        password=md5Password(password);
            String pass=u.getPassword();
            if((pass.equals(password)==false)||u.getTipoUsuario()!=1){
                
               throw new PasswordIncorrectoException();
            }
        
    
}

   @Override
   public void autenticarAdmin(String password,Usuario u) throws PasswordIncorrectoException{
       
       password=md5Password(password);
            String pass=u.getPassword();
            if((pass.equals(password)==false)||u.getTipoUsuario()!=0){
                
               throw new PasswordIncorrectoException();
            }
       
   }
    
    
}