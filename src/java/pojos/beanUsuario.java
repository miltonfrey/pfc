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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author abc
 */
@ManagedBean
@RequestScoped
public class beanUsuario {

        
    
    
    
    private String login;
    private String password;
    private String email;
    private String emailAux;
    private String titulacion;
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<String> listaTitulaciones;
    
    
    public beanUsuario() {
    }
    
    @PostConstruct
    public void init(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        ArrayList<String>aux=new ArrayList<>();
        aux.add("GEI");
        setListaTitulaciones(aux);
    }
    
    
    
    @ManagedProperty(value="#{usuarioService}")  //  Bean injected
    private UsuarioService usuarioService;

    
    /////////////////////////////////////////////////////////////// GETTERS Y SETTERS
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAux() {
        return emailAux;
    }

    public void setEmailAux(String emailAux) {
        this.emailAux = emailAux;
        
        }

    public ArrayList<String> getListaTitulaciones() {
        
       
        return listaTitulaciones;
    }

    public void setListaTitulaciones(ArrayList<String> listaTitulaciones) {
        this.listaTitulaciones = listaTitulaciones;
    }
    
    

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void actualizar(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        
    }
    
    public String eliminaUsuario(){
        
        Usuario u=(Usuario)usuarioService.find(getLogin());
        
        if (u==null){
            creaMensaje("no existe ese usuario", FacesMessage.SEVERITY_ERROR);
            
            return "";
        }
        
        
        if(usuarioService.delete(u)==false){
        
            creaMensaje("error al eliminar", FacesMessage.SEVERITY_FATAL);
            return "";
    }
        creaMensaje("usuario borrado", FacesMessage.SEVERITY_INFO);
        
            return "";
    }
    
    public String creaUsuario(){
        
        if(getEmail().equals(getEmailAux())==false){
            
            creaMensaje("los correos no coinciden", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        
        login=getLogin();
        password=getPassword();
        Usuario u=new Usuario();
        u.setLogin(login);
        u.setPassword(password);
        short s=1;
        u.setTipoUsuario(s);
        u.setEmail(email);
        u.setTitulacion(titulacion);
        
        try{
        usuarioService.insertarUsuario(u);
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
            ex.printStackTrace();
            creaMensaje("ya existe ese login", FacesMessage.SEVERITY_ERROR);
            return "";
            
            
                }
        
        creaMensaje("usuario creado", FacesMessage.SEVERITY_INFO);
            return("");
        
    }
        
        public String volver(){
            
            return("/index.xhtml?faces-redirect");
            
        }
        
        
        
        public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
        
        
        
        
        
        
        
    }
    

