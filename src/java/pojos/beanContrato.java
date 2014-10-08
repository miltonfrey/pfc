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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@ViewScoped
public class beanContrato implements Serializable{

    @ManagedProperty(value="#{movilidadService}")
    private transient MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private transient AsignaturaService asignaturaService;
    
    @ManagedProperty(value="#{equivalenciaService}")
    private transient EquivalenciaService equivalenciaService;

    
    
    private ExternalContext context;
    
    private HttpSession session;
    
    
    private boolean nuevo;
    private boolean visibleContratos;
    
    private Estado changeEstado;
    
    private ArrayList<Contrato> listaContratos;
    private ArrayList<Contrato> filteredContratos;
    private Contrato selectedContrato;
    
    
    private ArrayList<Movilidad> listaMovilidadesValidas;
    private Movilidad selectedMovilidad;
  
    
    public beanContrato() {
    }
    
    @PostConstruct
    public void init(){
        
       context=FacesContext.getCurrentInstance().getExternalContext();
       session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       
        if((Usuario)session.getAttribute("user")!=null){
        user=(Usuario)session.getAttribute("user");
           //listaMovilidadesValidas=(ArrayList<Movilidad>)movilidadService.listarMovilidadesValidas(user.getLogin());
        }else{
            
            
            if((Usuario)session.getAttribute("admin")!=null&&context.getSessionMap().containsKey("movilidad")){
                selectedMovilidad=(Movilidad)context.getSessionMap().get("movilidad");
                listaContratos=(ArrayList < Contrato >)equivalenciaService.listaContratos(selectedMovilidad);
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("movilidad");
            }
            
        }
       
        //if (request.getRequestURI().equals(request.getContextPath()+"/usuario/elaborarContrato.xhtml"))
        
    }

    public EquivalenciaService getEquivalenciaService() {
        return equivalenciaService;
    }

    public void setEquivalenciaService(EquivalenciaService equivalenciaService) {
        this.equivalenciaService = equivalenciaService;
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
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private Usuario user;

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isVisibleContratos() {
        return visibleContratos;
    }

    public void setVisibleContratos(boolean visibleContratos) {
        this.visibleContratos = visibleContratos;
    }

    public ArrayList<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratos(ArrayList<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public ArrayList<Contrato> getFilteredContratos() {
        return filteredContratos;
    }

    public void setFilteredContratos(ArrayList<Contrato> filteredContratos) {
        this.filteredContratos = filteredContratos;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

    public Estado getChangeEstado() {
        return changeEstado;
    }

    public void setChangeEstado(Estado changeEstado) {
        this.changeEstado = changeEstado;
    }
    
    
    
    
    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }

    public ArrayList<Movilidad> getListaMovilidadesValidas() {
        return listaMovilidadesValidas;
    }

    public void setListaMovilidadesValidas(ArrayList<Movilidad> listaMovilidadesValidas) {
        this.listaMovilidadesValidas = listaMovilidadesValidas;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

  
    
    public void verContratos(){
        
        visibleContratos=true;
        listaContratos=(ArrayList<Contrato>)equivalenciaService.listaContratos(selectedMovilidad);
        
        if(listaContratos.isEmpty()){
            nuevo=true;
    }else
            for (Contrato c: listaContratos){
        if(c.getEstado().equalsIgnoreCase("pendiente")||c.getEstado().equalsIgnoreCase("rechazado")||c.getEstado().equalsIgnoreCase("aceptado")){
            nuevo=false;
            break;
        }
    }
    }
   
    public void cerrarContratos(){
        
        visibleContratos=false;
    }
    
    public String editarContrato(){
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad", selectedMovilidad);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", selectedContrato);
       
        
        return ("elaborarContratoEditado.xhtml?faces-redirect=true");
        
    }
    
    
    public String eliminarContrato(){
        
        try{
            
            equivalenciaService.eliminaContrato(selectedContrato);
            
           }catch(Exception ex){
               ex.printStackTrace();
               creaMensaje("error al eliminar contrato", FacesMessage.SEVERITY_ERROR);
               return null;
           }
        
        creaMensaje("contrato eliminado correctamente", FacesMessage.SEVERITY_INFO);
        listaContratos=(ArrayList<Contrato>)equivalenciaService.listaContratos(selectedMovilidad);
        if(listaContratos.isEmpty())
            nuevo=true;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("contrato");
        selectedContrato=null;
        return null;
    }
    
    
    
    public String crearContrato(){
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad", selectedMovilidad);
        return ("elaborarContrato.xhtml?faces-redirect=true");
        
        
    }
    
    
    public String verContratosAdmin(){
       
        
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad", selectedMovilidad);
        
        return ("verContratos.xhtml?faces-redirect=true");
       
    }
    
    public String seleccionarContratoAdmin(){
        
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", selectedContrato);
       return "gestionarContrato.xhtml?faces-redirect=true";
        
    }
    
    public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
    
    
    
    
}
