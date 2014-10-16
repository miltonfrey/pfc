package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class mensajesRecibidosAdminBean implements Serializable{

    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{mensajeService}")
    private MensajeService mensajeService;
    
    private Usuario user;
    
     private boolean activaRecibido;
    private String textAreaRecibido;
    private String temaRecibido;
    
    private boolean activaTexto;
    
    private Mensaje selectedMensajeRecibido;
    private ArrayList<Mensaje> listaMensajesRecibidos;
    private ArrayList<Mensaje> selectedMensajesRecibidos;
    private ArrayList<Mensaje> filteredMensajesRecibidos;
    
    private ArrayList<Usuario> selectedUsuarios;
    
    private ArrayList<String> estados;
    
    public mensajesRecibidosAdminBean() {
    }
    
    @PostConstruct
    public void init(){
         ArrayList<String> aux= new ArrayList<String>();
        aux.add("si");
        aux.add("no");
        setEstados(aux);
        
        HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        user=(Usuario)session.getAttribute("admin");
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesRecibidosTotal("admin"));
        
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

    public boolean isActivaRecibido() {
        return activaRecibido;
    }

    public void setActivaRecibido(boolean activaRecibido) {
        this.activaRecibido = activaRecibido;
    }

    public String getTextAreaRecibido() {
        return textAreaRecibido;
    }

    public void setTextAreaRecibido(String textAreaRecibido) {
        this.textAreaRecibido = textAreaRecibido;
    }

    public String getTemaRecibido() {
        return temaRecibido;
    }

    public void setTemaRecibido(String temaRecibido) {
        this.temaRecibido = temaRecibido;
    }

    public boolean isActivaTexto() {
        return activaTexto;
    }

    public void setActivaTexto(boolean activaTexto) {
        this.activaTexto = activaTexto;
    }

    public Mensaje getSelectedMensajeRecibido() {
        return selectedMensajeRecibido;
    }

    public void setSelectedMensajeRecibido(Mensaje selectedMensajeRecibido) {
        this.selectedMensajeRecibido = selectedMensajeRecibido;
    }

    public ArrayList<Mensaje> getListaMensajesRecibidos() {
        return listaMensajesRecibidos;
    }

    public void setListaMensajesRecibidos(ArrayList<Mensaje> listaMensajesRecibidos) {
        this.listaMensajesRecibidos = listaMensajesRecibidos;
    }

    public ArrayList<Mensaje> getSelectedMensajesRecibidos() {
        return selectedMensajesRecibidos;
    }

    public void setSelectedMensajesRecibidos(ArrayList<Mensaje> selectedMensajesRecibidos) {
        this.selectedMensajesRecibidos = selectedMensajesRecibidos;
    }

    public ArrayList<Mensaje> getFilteredMensajesRecibidos() {
        return filteredMensajesRecibidos;
    }

    public void setFilteredMensajesRecibidos(ArrayList<Mensaje> filteredMensajesRecibidos) {
        this.filteredMensajesRecibidos = filteredMensajesRecibidos;
    }

    public ArrayList<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(ArrayList<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }
    
    
    
    
    
     public String leerMensajeRecibido(){
        
        activaRecibido=true;
        temaRecibido=selectedMensajeRecibido.getTema();
        textAreaRecibido=selectedMensajeRecibido.getTexto();
        
        Mensaje aux=mensajeService.find(selectedMensajeRecibido.getIdmensaje());
            
            if(aux!=null){
            aux.setLeidoDestino("si");
            selectedMensajeRecibido.setLeidoDestino("si");
        //if (filteredMensajesRecibidos!=null) filteredMensajesRecibidos.add(aux);
        try{
            
            mensajeService.enviarMensaje(aux);
            
        }catch(Exception ex){
            
            beanUtilidades.creaMensaje("se ha producido un error al leer mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
            }
      
        
      return "";
        
    }
     
     public void actualizarRecibidos(){
     
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesRecibidosTotal("admin"));
        for(Mensaje m:selectedMensajesRecibidos){
            
            if(selectedMensajeRecibido!=null&&m.getIdmensaje().equals(selectedMensajeRecibido.getIdmensaje()))
             
            activaRecibido=false;
            
        }    
     }
    
    
    public String eliminarMensajesRecibidos(){
        
        if(selectedMensajesRecibidos.isEmpty()){
            return "";
        }
        
        for(Mensaje m:selectedMensajesRecibidos){
         
            Mensaje aux=mensajeService.find(m.getIdmensaje());
            
            if(aux!=null){
            aux.setEliminadoDestino("si");
               
            
            try{
                
                if(aux.getEliminadoOrigen().equals("si")){
                    
                    mensajeService.eliminarMensaje(aux);
                }else{
                    
                     mensajeService.enviarMensaje(aux);
                }
                
            }catch(Exception ex){
                
                beanUtilidades.creaMensaje("se ha producido un error en el borrado de mensajes", FacesMessage.SEVERITY_ERROR);
                return "";
            }
            
        }
        }
         beanUtilidades.creaMensaje("mensajes eliminados correctamente", FacesMessage.SEVERITY_INFO);
        actualizarRecibidos();
        return "";
    
    }
    
    
         public void cerrarMensajeRecibido(){
        
        textAreaRecibido="";
        temaRecibido="";
        activaRecibido=false;
              
   
    
    
    
}
}