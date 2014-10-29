package pojos;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pojos.Exceptions.PasswordIncorrectoException;
import pojos.Exceptions.UsuarioNotFoundException;


//import javax.faces.bean.SessionScoped;
//import javax.faces.component.UIComponent;
import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class autenticarUsuarioBean implements Serializable{

     @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{usuarioService}")  
    private transient UsuarioService usuarioService;
    
   
    
    private String login;
    private String password;  
    
    public autenticarUsuarioBean() {
    }
    
    
    public beanUtilidades getBeanUtilidades() {
        return beanUtilidades;
    }

    public void setBeanUtilidades(beanUtilidades beanUtilidades) {
        this.beanUtilidades = beanUtilidades;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostConstruct
    public void init(){
        
        
    }
    
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public String autenticarUsuario(){
             
        Usuario u;
        
             try{
             u=usuarioService.find(getLogin());
             }catch(UsuarioNotFoundException ex){
              beanUtilidades.creaMensaje("login inexistente", FacesMessage.SEVERITY_ERROR);
              return null; 
             }
             
             
            try{ 
            usuarioService.autenticarUsuario(password,u);
            }catch(PasswordIncorrectoException ex){
               beanUtilidades.creaMensaje("password incorrecto", FacesMessage.SEVERITY_ERROR);
               return null;
            }
            
                HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("user", u);
                return "usuario/index.xhtml?faces-redirect=true";
            
        }
    
    
}
