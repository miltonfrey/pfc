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
@Service("mensajeService")
public class MensajeServiceImpl implements MensajeService{
    
    @Autowired
    private MensajeDao mensajeDao;

    public MensajeDao getMensajeDao() {
        return mensajeDao;
    }

    public void setMensajeDao(MensajeDao mensajeDao) {
        this.mensajeDao = mensajeDao;
    }
    
    
    @Override
    public List<Mensaje> mensajesEnviados(String origen,String destino){
        
        return mensajeDao.mensajesEnviados(origen, destino);
    }
    
     @Override
    public List<Mensaje> mensajesRecibidos(String origen,String destino){
        
        return mensajeDao.mensajesRecibidos(origen, destino);
    }
    
    @Override
    public void enviarMensaje(Mensaje m){
        mensajeDao.crearMensaje(m);
        
    }
    @Override
    public List<Mensaje> mensajesEnviadosTotal(String destino){
        
        return mensajeDao.mensajesEnviadosTotal(destino);
        
        
    }
    @Override
    public List<Mensaje> mensajesRecibidosTotal(String origen){
        
        return mensajeDao.mensajesRecibidosTotal(origen);
    }
    
    
    @Override
    public void eliminarMensaje(Mensaje m){
        
        mensajeDao.eliminarMensaje(m);
    }
    
    
    public Mensaje find(Integer msgId){
        
        return mensajeDao.find(msgId);
    }
    
}
