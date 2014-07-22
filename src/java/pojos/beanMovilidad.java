/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;


@Named(value = "beanMovilidad")
@RequestScoped
public class beanMovilidad {

    
    public beanMovilidad() {
        }
    
    @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;

    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }
    
    
    
    
    
    
    
    
    }
    
