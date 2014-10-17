/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

//import antlr.debug.Event;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.datatable.DataTable;
import pojos.utillidades.beanUtilidades;


/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class equivalenciasBean implements Serializable{

    
    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{usuarioService}")
    private transient UsuarioService usuarioService;
    
     @ManagedProperty(value="#{movilidadService}")
    private transient MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private transient AsignaturaService asignaturaService;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private transient EquivalenciaService equivalenciaService;
    
    @ManagedProperty(value="#{mensajeService}")
    private transient MensajeService mensajeService;
    
   
    private ExternalContext context;
    private HttpSession session;
    private Movilidad selectedMovilidad;
    private Contrato selectedContrato;
    private Contrato contratoComparado;
    private Usuario user;
    
    Equivalencia equivalencia;
    
    
    private ArrayList<Asignatura> listaAsignaturasFic;
    private ArrayList<Asignatura>listaAsignaturasUniversidad;
   
    
    private ArrayList<Equivalencia>listaEquivalencias;
    private ArrayList<Equivalencia> listaAuxEquivalencias=new ArrayList<Equivalencia>();
    private ArrayList<Equivalencia> listaAuxEquivalenciasComparado;
    
    private ArrayList<Equivalencia>selectedEquivalencias;
    
    private static int j=0;
    
    
    
    private String apruebaOrechaza;
    
    public equivalenciasBean() {
        
    }
    
    @PostConstruct
    public void init(){
        context=FacesContext.getCurrentInstance().getExternalContext();
        session=(HttpSession)context.getSession(false);
        
           if(context.getSessionMap().containsKey("movilidad")&&context.getSessionMap().containsKey("contrato")){
           user=(Usuario)session.getAttribute("admin");
           selectedMovilidad=(Movilidad)context.getSessionMap().get("movilidad");
           selectedContrato=(Contrato)context.getSessionMap().get("contrato");
           context.getSessionMap().remove("contrato");
           context.getSessionMap().remove("movilidad");
           listaAuxEquivalencias=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalenciasPorContrato(selectedContrato.getIdContrato());
              
           if(context.getSessionMap().containsKey("contratoComparado")){
        contratoComparado=(Contrato)context.getSessionMap().get("contratoComparado");
        listaAuxEquivalenciasComparado=(ArrayList<Equivalencia>)equivalenciaService.listarEquivalenciasPorContrato(contratoComparado.getIdContrato());
        context.getSessionMap().remove("contratoComparado");
         
           }
           
        }
       else{
            try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/admin/verMovilidades.xhtml");
            }catch(IOException ex){
                    
                    }
    }
       } 

    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }
    
    public MensajeService getMensajeService() {
        return mensajeService;
    }

    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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


    public EquivalenciaService getEquivalenciaService() {
        return equivalenciaService;
    }

    public void setEquivalenciaService(EquivalenciaService equivalenciaService) {
        this.equivalenciaService = equivalenciaService;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
   
    
    public ArrayList<Equivalencia> getSelectedEquivalencias() {
        return selectedEquivalencias;
    }

    public void setSelectedEquivalencias(ArrayList<Equivalencia> selectedEquivalencias) {
        this.selectedEquivalencias = selectedEquivalencias;
    }

    public ArrayList<Equivalencia> getListaEquivalencias() {
        return listaEquivalencias;
    }

    public void setListaEquivalencias(ArrayList<Equivalencia> listaEquivalencias) {
        this.listaEquivalencias = listaEquivalencias;
    }

    public ArrayList<Equivalencia> getListaAuxEquivalencias() {
        return listaAuxEquivalencias;
    }

    public void setListaAuxEquivalencias(ArrayList<Equivalencia> listaAuxEquivalencias) {
        this.listaAuxEquivalencias = listaAuxEquivalencias;
    }

    public ArrayList<Equivalencia> getListaAuxEquivalenciasComparado() {
        return listaAuxEquivalenciasComparado;
    }

    public void setListaAuxEquivalenciasComparado(ArrayList<Equivalencia> listaAuxEquivalenciasComparado) {
        this.listaAuxEquivalenciasComparado = listaAuxEquivalenciasComparado;
    }

   
    public ArrayList<Asignatura> getListaAsignaturasFic() {
        return listaAsignaturasFic;
    }

    public void setListaAsignaturasFic(ArrayList<Asignatura> listaAsignaturasFic) {
        this.listaAsignaturasFic = listaAsignaturasFic;
    }

    public ArrayList<Asignatura> getListaAsignaturasUniversidad() {
        return listaAsignaturasUniversidad;
    }

    public void setListaAsignaturasUniversidad(ArrayList<Asignatura> listaAsignaturasUniversidad) {
        this.listaAsignaturasUniversidad = listaAsignaturasUniversidad;
    }

    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

    public Contrato getContratoComparado() {
        return contratoComparado;
    }

    public void setContratoComparado(Contrato contratoComparado) {
        this.contratoComparado = contratoComparado;
    }

    public String getApruebaOrechaza() {
        return apruebaOrechaza;
    }

    public void setApruebaOrechaza(String apruebaOrechaza) {
        this.apruebaOrechaza = apruebaOrechaza;
    }

   
    public String publicarEquivalencia(){
        
        if(selectedEquivalencias.isEmpty()){
            return null;
        }
        
        for(Equivalencia e:selectedEquivalencias){
            e.setVisible("si");
            try{
                equivalenciaService.actualizarEquivalencia(e);
            }catch(Exception ex){
                beanUtilidades.creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
                return null;
            }
        }
        beanUtilidades.creaMensaje("Las equivalencias han sido publicadas", FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    
    public String noPublicar(){
        
         if(selectedEquivalencias.isEmpty()){
            return null;
        }
        
        for(Equivalencia e:selectedEquivalencias){
            e.setVisible("no");
            try{
                equivalenciaService.actualizarEquivalencia(e);
            }catch(Exception ex){
                beanUtilidades.creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
                return null;
            }
        }
        beanUtilidades.creaMensaje("Las equivalencias seleccionadas ya no son públicas", FacesMessage.SEVERITY_INFO);
        return null;
        
        
    }
    
    
    public String cambiarEstadoContrato(){
        
        beanUtilidades.creaMensaje(selectedContrato.getEstado(), FacesMessage.SEVERITY_INFO);
        
        selectedContrato.setEstado(apruebaOrechaza);
        try{
            
            equivalenciaService.modificaContrato(selectedContrato);
            
        }catch(Exception ex){
            ex.printStackTrace();
            beanUtilidades.creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            
            return null;
        }
        beanUtilidades.creaMensaje("contrato modificado correctamente", FacesMessage.SEVERITY_INFO);
        context.getSessionMap().remove("contrato");
        
        return null;
    }
    
   
}
