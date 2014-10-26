package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import pojos.utillidades.beanUtilidades;


@ManagedBean
@ViewScoped
public class crearUsuarioBean implements Serializable{
    
    
    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{usuarioService}")  
    private transient UsuarioService usuarioService;
    
    private String login;
    private String password;
    private String passwordAux;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Usuario user;
    private String titulacion;
    private ArrayList<String> listaTitulaciones;
    
    
    public crearUsuarioBean() {
    }
    
    @PostConstruct
    public void init(){
        
        ArrayList<String>aux=new ArrayList<String>();
        aux.add("GEI");
        aux.add("MUEI");
        setListaTitulaciones(aux);
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

    public String getPasswordAux() {
        return passwordAux;
    }

    public void setPasswordAux(String passwordAux) {
        this.passwordAux = passwordAux;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public ArrayList<String> getListaTitulaciones() {
        return listaTitulaciones;
    }

    public void setListaTitulaciones(ArrayList<String> listaTitulaciones) {
        this.listaTitulaciones = listaTitulaciones;
    }
    
    
    
    
    public String creaUsuario(){
        
        if(getPassword().equals(getPasswordAux())==false){
            
            beanUtilidades.creaMensaje("los password no coinciden", FacesMessage.SEVERITY_ERROR);
            return null;
        }
        
        Usuario u=new Usuario();
        u.setLogin(login);
        u.setPassword(password);
        short s=1;
        u.setTipoUsuario(s);
        u.setNombre(nombre);
        u.setApellido1(apellido1);
        u.setApellido2(apellido2);
        
        u.setTitulacion(titulacion);
        
        try{
        usuarioService.insertarUsuario(u);
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
    //}catch(Exception ex){ 
            beanUtilidades.creaMensaje("ya existe ese login", FacesMessage.SEVERITY_ERROR);
            return null;
            
            
                }
        
        beanUtilidades.creaMensaje("usuario creado", FacesMessage.SEVERITY_INFO);
        
        login="";
        nombre="";
        apellido1="";
        apellido2="";
        titulacion="";
        password="";
            return null;
        
    }
    
    
    
    
    
    
    
}