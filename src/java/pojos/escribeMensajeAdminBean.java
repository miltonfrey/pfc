package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
public class escribeMensajeAdminBean implements Serializable{

    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{mensajeService}")
    private MensajeService mensajeService;
    
    @ManagedProperty(value="#{usuarioService}")
    private UsuarioService usuarioService;
    
    
    private Usuario user;
    
    private String tema;
    private String texto;
    
   
    
    
    
    
    
    
    public escribeMensajeAdminBean() {
    }
    
    @PostConstruct
    public void init(){
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       user=(Usuario)session.getAttribute("user");
        
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
    
    

   
    public String enviarMensajeCoordinador(){
        
        Usuario destino=usuarioService.find("admin");
        
        
        Mensaje m=new Mensaje(destino, user, Calendar.getInstance().getTime(), tema, texto, "no","no","no");
        try{
        mensajeService.enviarMensaje(m);
        }catch(Exception ex){
            
            beanUtilidades.creaMensaje("se ha producido un error creando el mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        beanUtilidades.creaMensaje("mensaje enviado correctamente", FacesMessage.SEVERITY_WARN);
        texto="";
        tema="";
        
        //actualizarEnviados();
        return "";
    }
   
}
