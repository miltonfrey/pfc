/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;


import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author abc
 */
@ManagedBean
@RequestScoped
public class beanUsuario {

    
    
    
    
    private String login;
    private String password;
    private ArrayList<Usuario> listaUsuarios;
    
    public beanUsuario() {
    }
    
    @PostConstruct
    public void init(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        
    }
    
    
    @ManagedProperty(value="#{usuarioService}")
    private UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
    
    
    
    
    
    
    public void actualizar(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        
    }
    
    public String eliminaUsuario(){
        
        Usuario u=(Usuario)usuarioService.find(getLogin());
        
        if (u==null){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage("no existe ese usuario");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null,message);
            return "";
        }
        
        
        if(usuarioService.delete(u)==false){
        
        FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage("error al eliminar");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null,message);
            return "";
    }
        FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage("usuario borrado: "+getLogin());
            message.setSeverity(FacesMessage.SEVERITY_WARN);
            context.addMessage(null,message);
            return "";
    }
    
    public String creaUsuario(){
        
        login=getLogin();
        password=getPassword();
        Usuario u=new Usuario();
        u.setLogin(login);
        u.setPassword(password);
        short s=1;
        u.setTipoUsuario(s);
        
        
        try{
        usuarioService.insertarUsuario(u);
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
                
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage("ya existe ese login");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null,message);
            return "";
            
            
                }
        
        
            return("");
        
    }
        
        public String volver(){
            
            return("/index.xhtml?faces-redirect");
            
        }
        
        
        
        
    }
    

