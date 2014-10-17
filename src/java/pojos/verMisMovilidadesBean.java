package pojos;



import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
public class verMisMovilidadesBean implements Serializable{

   
    
   @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
     @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;

     @ManagedProperty(value="#{usuarioService}")
     private UsuarioService usuarioService;
     
     @ManagedProperty(value="#{mensajeService}")
     private MensajeService mensajeService;
  
    
    
    public verMisMovilidadesBean() {
    }
    
    private Usuario usuario;
    
    
    
    private Movilidad selectedMovilidad;
    private ArrayList<Movilidad> listaMisMovilidades;
    private ArrayList<Movilidad> filteredMovilidades;
    
   
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    
    
    @PostConstruct
    public void init(){
    
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       usuario=(Usuario)session.getAttribute("user");
       listaMisMovilidades=(ArrayList < Movilidad >)movilidadService.listarMisMovilidades(usuario.getLogin());
       
        
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

   
    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }

    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public ArrayList<Movilidad> getListaMisMovilidades() {
         Collections.reverse(listaMisMovilidades);
         return listaMisMovilidades;
    }

    public void setListaMisMovilidades(ArrayList<Movilidad> listaMisMovilidades) {
        this.listaMisMovilidades = listaMisMovilidades;
    }

    public ArrayList<Movilidad> getFilteredMovilidades() {
        return filteredMovilidades;
    }

    public void setFilteredMovilidades(ArrayList<Movilidad> filteredMovilidades) {
        this.filteredMovilidades = filteredMovilidades;
    }

    

    
    
    
    
    
    
    public String eliminarMovilidad(){
        
        if(selectedMovilidad.getEstado().equalsIgnoreCase("pendiente")){
            
            try{
            movilidadService.eliminarMovilidad(selectedMovilidad);
            }catch(Exception ex){
                
                beanUtilidades.creaMensaje("se ha producido un error eliminando la movilidad", FacesMessage.SEVERITY_ERROR);
                
            }
            
            beanUtilidades.creaMensaje("movilidad eliminada correctamente, se ha enviado un mensaje al coordinador ", FacesMessage.SEVERITY_INFO);
            
            Mensaje mensaje=new Mensaje(usuarioService.find("admin"),usuario,  Calendar.getInstance().getTime(), "movilidad eliminada", "el usuario "+usuario.getLogin()+" ha eliminado una movilidad", "no","no","no");
            try{
                mensajeService.enviarMensaje(mensaje);
            }catch(Exception ex){
                beanUtilidades.creaMensaje("se ha producido un error enviando el mensaje", FacesMessage.SEVERITY_ERROR);
                return null;
            }
            
            
        }else
         
            if(selectedMovilidad.getEstado().equalsIgnoreCase("aceptada")){
                
                
                Mensaje mensaje=new Mensaje( usuarioService.find("admin"),usuario, Calendar.getInstance().getTime(), "movilidad eliminada", "el usuario "+usuario.getLogin()+" quiere cancelar una movilidad en curso en: "+selectedMovilidad.getUniversidad().getNombre()+" con fecha de inicio:"+ sdf.format(selectedMovilidad.getFechaInicio())+" y fecha fin:"+sdf.format(selectedMovilidad.getFechaFin()), "no","no","no");
            try{
                mensajeService.enviarMensaje(mensaje);
            }catch(Exception ex){
                beanUtilidades.creaMensaje("se ha producido un error enviando el mensaje", FacesMessage.SEVERITY_ERROR);
                    
            }
                beanUtilidades.creaMensaje("se ha enviado un mensaje al coordinador para su cancelación", FacesMessage.SEVERITY_INFO);
            return null;
        
             
        }else
                if(selectedMovilidad.getEstado().equalsIgnoreCase("rechazada")){
                    
                     try{
            movilidadService.eliminarMovilidad(selectedMovilidad);
            }catch(Exception ex){
                
                beanUtilidades.creaMensaje("se ha producido un error eliminando la movilidad", FacesMessage.SEVERITY_ERROR);
                return null;
            }  
                  beanUtilidades.creaMensaje("movilidad eliminada correctamente", FacesMessage.SEVERITY_INFO);
                  actualizar();
                  return null;  
                }
            
        
        return null;
        
    }
    
    public void actualizar(){
        
        listaMisMovilidades=(ArrayList < Movilidad >)movilidadService.listarMisMovilidades(usuario.getLogin());
    }
    
   
    
   
    
    
    
    
    
    }
    

    
    

