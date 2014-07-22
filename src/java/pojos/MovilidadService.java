/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;

/**
 *
 * @author abc
 */
public interface MovilidadService {
    
    public List<Movilidad> listarTodasMovilidades();
    public List<Movilidad> listarMovilidadesPendientes();
    
    
}
