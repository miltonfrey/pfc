/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class beanEquivalencia implements Serializable{

     @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private AsignaturaService asignaturaService;
    
    @ManagedProperty(value="#{beanContrato}")
    private beanContrato beanContrato;
    
   
    private ArrayList<Equivalencia>listaEquivalencias;
    
    private ArrayList<Asignatura>selectedAsignaturasFic;
    private ArrayList<Asignatura>selectedEquivalencias;
    
    
    
    
    public beanEquivalencia() {
        
    }
    
    @PostConstruct
    public void init(){
        
        
        
    }
    
    

    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }

    public AsignaturaService getAsignaturaService() {
        return asignaturaService;
    }

    public void setAsignaturaService(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    public beanContrato getBeanContrato() {
        return beanContrato;
    }

    public void setBeanContrato(beanContrato beanContrato) {
        this.beanContrato = beanContrato;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Asignatura> getSelectedAsignaturasFic() {
        return selectedAsignaturasFic;
    }

    public void setSelectedAsignaturasFic(ArrayList<Asignatura> selectedAsignaturasFic) {
        this.selectedAsignaturasFic = selectedAsignaturasFic;
    }

    public ArrayList<Asignatura> getSelectedEquivalencias() {
        return selectedEquivalencias;
    }

    public void setSelectedEquivalencias(ArrayList<Asignatura> selectedEquivalencias) {
        this.selectedEquivalencias = selectedEquivalencias;
    }

    public ArrayList<Equivalencia> getListaEquivalencias() {
        return listaEquivalencias;
    }

    public void setListaEquivalencias(ArrayList<Equivalencia> listaEquivalencias) {
        this.listaEquivalencias = listaEquivalencias;
    }
    
    
    
    
    
    
    
    
    
    
    
    public String añadirAsignaturasFic(){
        for(Asignatura a:selectedAsignaturasFic){
        
       // MiembroGrupoAsignaturaId id=new MiembroGrupoAsignaturaId(a.getId().getCodAsignatura(),a.getNombreAsignatura());
        GrupoAsignatura g=new GrupoAsignatura();
        
            
            
        MiembroGrupoAsignatura m=new MiembroGrupoAsignatura(a)
        
                }
    }
    
    
    public String eliminaEquivalenciasLista(){
        
        
        return "";
        
    }
    
    
    
    
    
}
