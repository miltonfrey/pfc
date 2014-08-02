/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;


import java.util.Date;
import java.util.List;

/**
 *
 * @author abc
 */
public interface MovilidadService {
    
    public List<Movilidad> listarTodasMovilidades();
    public List<Movilidad> listarMovilidadesPendientes();
    public Date fechaMin();
    public Date fechaMax();
    public void crearMovilidad(Movilidad m);
    public List<Movilidad> listarMisMovilidades(String user);
    public List<Movilidad> listarMisMovilidadesPorEstado(String user,String estado);
    public void eliminarMovilidad(Movilidad m);
}
