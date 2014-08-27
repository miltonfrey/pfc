/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;



/**
 *
 * @author abc
 */
@ManagedBean
//@javax.faces.bean.SessionScoped
@javax.faces.bean.ViewScoped
public class beanUsuario implements Serializable{

        
    
    
    
    private String login;
    private String password;
    private String passwordAux;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Usuario user;
    private String titulacion;
    
    
    private Usuario selectedUsuario;
    private ArrayList<Usuario> selectedUsuarios;
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Usuario> filteredUsuarios;
    private ArrayList<String> listaTitulaciones;
   
    private ArrayList<Mensaje> listaMensajes;
    
    
    public beanUsuario() {
    }
    
    @PostConstruct
    public void init(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        ArrayList<String>aux=new ArrayList<String>();
        aux.add("GEI");
        aux.add("MUEI");
        setListaTitulaciones(aux);
        
        HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        if(session.getAttribute("user")!=null){
            
            user=(Usuario)session.getAttribute("user");
        }
        
     /*  if (request.getRequestURI().equals(request.getContextPath()+"/usuario/verMisMensajes.xhtml")){
        
        }
        
        */
        
    }
    
    @ManagedProperty(value="#{usuarioService}")  //  Bean injected
    private transient UsuarioService usuarioService;
    
    @ManagedProperty(value="#{mensajeService}")
    private transient MensajeService mensajeService; //quitarlo y ponerlo en MensajeBean
   
    /////////////////////////////////////////////////////////////// GETTERS Y SETTERS
    
    
    
    
    
    
    
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public MensajeService getMensajeService() {
        return mensajeService;
    }

    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    
    
    
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        
        
    }
    
    public ArrayList<Usuario> getFilteredUsuarios() {
        return filteredUsuarios;
    }

    public void setFilteredUsuarios(ArrayList<Usuario> filteredUsuarios) {
        this.filteredUsuarios = filteredUsuarios;
    }
    
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////
   
///////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(ArrayList<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
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

    
    
    
    
    
    public void setPassword(String password) {
        this.password = password;
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

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void actualizar(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        //if(filteredUsuarios!=null)
        //filteredUsuarios.remove(selectedUsuario);
        //filteredUsuarios=null;
        
       
        
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
    
    
    public String eliminaUsuarioLista(){
        
        
        try{
         usuarioService.delete(selectedUsuario);
        
                 
                 
        }catch(Exception ex){
                     
            creaMensaje("error al eliminar "+ getSelectedUsuario().getLogin(), FacesMessage.SEVERITY_FATAL);
            return "";
                 }
         
        creaMensaje("usuario borrado "+getSelectedUsuario().getLogin(), FacesMessage.SEVERITY_INFO);
        actualizar();
        return "";
          
    }
    
    public String eliminaUsuariosLista(){
        
        if(selectedUsuarios.isEmpty()){
            return "";
        }
        
        for(Usuario u:selectedUsuarios){
        
        try{
         usuarioService.delete(u);
      
        }catch(Exception ex){
                     
            creaMensaje("error al eliminar "+ getSelectedUsuario().getLogin(), FacesMessage.SEVERITY_FATAL);
            return "";
                 }
        }
        creaMensaje("usuarios borrado ", FacesMessage.SEVERITY_INFO);
        actualizar();
        return "";
          
    }
    
    
    
    public String creaUsuario(){
        
        if(getPassword().equals(getPasswordAux())==false){
            
            creaMensaje("los password no coinciden", FacesMessage.SEVERITY_ERROR);
            return "";
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
            
            creaMensaje("ya existe ese login", FacesMessage.SEVERITY_ERROR);
            return "";
            
            
                }
        
        creaMensaje("usuario creado", FacesMessage.SEVERITY_INFO);
        
        login="";
        nombre="";
        apellido1="";
        apellido2="";
        titulacion="";
        password="";
            return("");
        
    }
        
    
            public String autenticarAdmin(){
            Usuario u=usuarioService.find(getLogin());
            
            if(u==null){
                
                creaMensaje("login inexistente", FacesMessage.SEVERITY_ERROR);
                return "";
            }
            
            String pass=u.getPassword();
            if((pass.equals(password)==false)||u.getTipoUsuario()!=0){
                
                creaMensaje("password incorrecto", FacesMessage.SEVERITY_ERROR); // meter numero de errores al loguear
                return "";
                
                
            }else{
                
                HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("admin", u);
                return "admin/index.xhtml?faces-redirect=true";
                
            }
            
            
        }
        
        public String autenticarUsuario(){
            
            
             Usuario u=usuarioService.find(getLogin());
            
            if(u==null){
                
                creaMensaje("login inexistente", FacesMessage.SEVERITY_ERROR);
                return "";
            }
            
            String pass=u.getPassword();
            if((pass.equals(password)==false)||u.getTipoUsuario()!=1){
                
                creaMensaje("password incorrecto", FacesMessage.SEVERITY_ERROR); // meter numero de errores al loguear
                
                
                return "";
                
                
            }else{
                HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("user", u);
              
                
                
                return "usuario/index.xhtml?faces-redirect=true";
                
            }
            
            
        }
        
        public void numeroMovilidades(){
            
            
            Set<Movilidad> movilidades=user.getMovilidads();
            creaMensaje(" "+movilidades.size(), FacesMessage.SEVERITY_INFO);
           
            
        }
        
        
        
        
        public String salir(){
            
            
            
            HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.invalidate();
            return("/principal.xhtml?faces-redirect=true");
            
            
        }
        
        
        public void cancel(){
            
        }
        
        
        
        
        
       
        
        
        public String comprobarContext(){
            
            HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            
            creaMensaje(request.getRequestURI(), FacesMessage.SEVERITY_WARN); //direccion que hizo el request
            creaMensaje(request.getContextPath(), FacesMessage.SEVERITY_WARN); // direccion del contexto
            creaMensaje(request.getRequestURL().toString(), FacesMessage.SEVERITY_WARN);
            return "";
        }
        
        public void comprobarSession(){
            
            HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            
            Usuario u=(Usuario)session.getAttribute("user");
            
            if(u!=null){
            creaMensaje(u.getLogin() ,FacesMessage.SEVERITY_INFO);
            
        }
            else
                creaMensaje(" " ,FacesMessage.SEVERITY_INFO);
            
            
            
        }
        
        
        public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
        
     /*   public void prueba(){
            
             HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
             session.setAttribute("atr1", "atr1");
            session.setAttribute("atr2", "atr2");
            
            creaMensaje((String)session.getAttribute("atr1")+" "+(String)session.getAttribute("atr2"), FacesMessage.SEVERITY_INFO);
        }
        
        */
        
        
    }
    

