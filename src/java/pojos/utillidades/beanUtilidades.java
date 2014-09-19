/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos.utillidades;


import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import pojos.Cursoacademico;
import pojos.Estado;
import pojos.EstadoMovilidad;



@ManagedBean
@RequestScoped
public class beanUtilidades {

    @ManagedProperty(value="#{utilidadService}")
    private transient UtilidadService utilidadService;

    public UtilidadService getUtilidadService() {
        return utilidadService;
    }

    public void setUtilidadService(UtilidadService utilidadService) {
        this.utilidadService = utilidadService;
    }
    
    private ArrayList<Estado> listaEstados;
    private String estado;
    
    private ArrayList<EstadoMovilidad> listaEstadosMovilidad;
    private String estadoMovilidad;
    
    private String cursoAcademico;
    private ArrayList<Cursoacademico> listaCursoAcademico;
    
    
    public beanUtilidades() {
    }
    
    
    @PostConstruct
    public void init(){
        HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
       // if (request.getRequestURI().equals("/pfc/admin/estados.xhtml")==true){
            
            setListaEstados((ArrayList < Estado >)utilidadService.listaEstados());
        //}else{
          //  if (request.getRequestURI().equals("/pfc/admin/estadosMovilidad.xhtml")==true){
            
            setListaEstadosMovilidad((ArrayList < EstadoMovilidad >)utilidadService.listaEstadosMovilidad());
            setListaCursoAcademico((ArrayList<Cursoacademico>)utilidadService.listaCursoAcademico());
        //}
      
    //}
    }

    public ArrayList<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(ArrayList<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<EstadoMovilidad> getListaEstadosMovilidad() {
        return listaEstadosMovilidad;
    }

    public void setListaEstadosMovilidad(ArrayList<EstadoMovilidad> listaEstadosMovilidad) {
        this.listaEstadosMovilidad = listaEstadosMovilidad;
    }

    public String getEstadoMovilidad() {
        return estadoMovilidad;
    }

    public void setEstadoMovilidad(String estadoMovilidad) {
        this.estadoMovilidad = estadoMovilidad;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public ArrayList<Cursoacademico> getListaCursoAcademico() {
        return listaCursoAcademico;
    }

    public void setListaCursoAcademico(ArrayList<Cursoacademico> listaCursoAcademico) {
        this.listaCursoAcademico = listaCursoAcademico;
    }
    
    
    
    
    
    public String creaEstado(){
        
        Estado e=new Estado(estado);
        try{
        utilidadService.crearEstado(e);
        }catch(Exception ex){
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            estado="";
            return null;
        }
        creaMensaje("estado creado o modificado", FacesMessage.SEVERITY_INFO);
        setListaEstados((ArrayList < Estado >)utilidadService.listaEstados());
        estado="";
        return null;
        
        
    }
    
    
    public String eliminaEstado(){
        
        Estado e=new Estado(estado);
        
        try{
        utilidadService.eliminaEstado(e);
        }catch(Exception ex){
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        creaMensaje("estado eliminado", FacesMessage.SEVERITY_INFO);
        estado="";
        setListaEstados((ArrayList < Estado >)utilidadService.listaEstados());
        return null;
    }
    
    
    public String creaEstadoMovilidad(){
        EstadoMovilidad e=new EstadoMovilidad(estadoMovilidad);
        try{
        utilidadService.crearEstadoMovilidad(e);
        }catch(Exception ex){
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            estadoMovilidad="";
            return null;
        }
        creaMensaje("estado guardado", FacesMessage.SEVERITY_INFO);
        listaEstadosMovilidad=(ArrayList < EstadoMovilidad >)utilidadService.listaEstadosMovilidad();
        estadoMovilidad="";
        return null;
    }
    
    public String eliminaEstadoMovilidad(){
        EstadoMovilidad e=new EstadoMovilidad(estadoMovilidad);
        try{
            utilidadService.eliminaEstadoMovilidad(e);
            
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        creaMensaje("estado eliminado", FacesMessage.SEVERITY_INFO);
        listaEstadosMovilidad=(ArrayList < EstadoMovilidad >)utilidadService.listaEstadosMovilidad();
        estadoMovilidad="";
        return null;
    }
    
    public String creaCursoAcademico(){
        Cursoacademico c=new Cursoacademico(cursoAcademico);
        try{
        utilidadService.crearCursoAcademico(c);
    }catch(Exception ex){
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            return null;
            
    }
        creaMensaje("curso académico creado correctamente", FacesMessage.SEVERITY_INFO);
        cursoAcademico="";
        setListaCursoAcademico((ArrayList<Cursoacademico>)utilidadService.listaCursoAcademico());
        return null;
    }
    
    public String eliminaCursoAcademico(){
        
        Cursoacademico c=new Cursoacademico(cursoAcademico);
         try{
        utilidadService.eliminaCursoAcademico(c);
    }catch(Exception ex){
            creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            return null;
            
    }
         cursoAcademico="";
         setListaCursoAcademico((ArrayList<Cursoacademico>)utilidadService.listaCursoAcademico());
        creaMensaje("curso académico eliminado correctamente", FacesMessage.SEVERITY_INFO);
        return null;
    }
        
    
        
    
    
    
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
     
     public void request(){
         
         HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
         creaMensaje(request.getRequestURI(), FacesMessage.SEVERITY_INFO);
     }
    
    
}