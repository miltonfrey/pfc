/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
    
   
    private Equivalencia equivalencia;
    
    
    private ArrayList<Equivalencia>listaEquivalencias;
    
    private ArrayList<Asignatura>selectedAsignaturasFic;
    private ArrayList<Asignatura> selectedAsignaturasUni;
    
    private ArrayList<Asignatura>selectedEquivalencias;
    
    public beanEquivalencia() {
        
    }
    
    @PostConstruct
    public void init(){
        
       
        
        
        
        equivalencia=new Equivalencia();
        
        
        
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

    public Equivalencia getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Equivalencia equivalencia) {
        this.equivalencia = equivalencia;
    }

    public ArrayList<Asignatura> getSelectedAsignaturasUni() {
        return selectedAsignaturasUni;
    }

    public void setSelectedAsignaturasUni(ArrayList<Asignatura> selectedAsignaturasUni) {
        this.selectedAsignaturasUni = selectedAsignaturasUni;
    }
    
    
    
    
    
    
    
    
    
    
    
    public String añadirAsignaturasFic(){
        
      /*  GrupoAsignatura grupoA=new GrupoAsignatura();
        equivalencia.setGrupoAsignaturaByGrupoAsignaturaA(grupoA);
        
        MiembroGrupoAsignatura m;
        for(Asignatura a:selectedAsignaturasFic){
        
       // MiembroGrupoAsignaturaId id=new MiembroGrupoAsignaturaId(a.getId().getCodAsignatura(),a.getNombreAsignatura());
        
        m=new MiembroGrupoAsignatura(a, grupoA);
        grupoA.getMiembroGrupoAsignaturas().add(m);
        
        }
        
        equivalencia.setGrupoAsignaturaByGrupoAsignaturaA(grupoA);
        */
        return "";
                
    }
    
    
    public String añadirAsignaturasUniversidad(){
        
        creaMensaje(selectedAsignaturasUni.get(0).getNombreAsignatura(),FacesMessage.SEVERITY_INFO);
        
        return "";
        
    }
    
    
    
    public String eliminaEquivalenciasLista(){
        
        
        return "";
        
    }
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
}
