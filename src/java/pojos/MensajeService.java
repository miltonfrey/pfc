/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;


public interface MensajeService {
    
    public List<Mensaje> mensajesEnviados(String origen,String destino);
    public void enviarMensaje(Mensaje m);

}