/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author abc
 */
@ManagedBean
@ViewScoped
public class beanMensaje implements Serializable{

    @ManagedProperty(value="#{usuarioService}")
    private transient UsuarioService usuarioService;
    
    @ManagedProperty(value="#{mensajeService}")
    private transient MensajeService mensajeService;
    
    
    private ArrayList<Mensaje> listaMensajesRecibidos;
    private ArrayList<Mensaje> listaMensajesEnviados;
    private Usuario user;
    
    
    
    private boolean activaRecibido;
    private String textAreaRecibido;
    private String temaRecibido;
    private boolean activaEnviado;
    private String textAreaEnviado;
    private String temaEnviado;
    private boolean activaTexto;
    private String tema;
    private String texto;
    
    private Mensaje selectedMensaje;
    private Mensaje selectedMensajeRecibido;
    
    public beanMensaje() {
        
    }
    
    @PostConstruct
    public void init(){
        
       HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       user=(Usuario)session.getAttribute("user");
       
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesEnviados("admin", user.getLogin()));
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviados(user.getLogin(), "admin"));
        
        
    }

   
    
    
    
    

    public ArrayList<Mensaje> getListaMensajesRecibidos() {
        return listaMensajesRecibidos;
    }

    public void setListaMensajesRecibidos(ArrayList<Mensaje> ListaMensajesRecibidos) {
        this.listaMensajesRecibidos = ListaMensajesRecibidos;
    }

    public ArrayList<Mensaje> getListaMensajesEnviados() {
        return listaMensajesEnviados;
    }

    public void setListaMensajesEnviados(ArrayList<Mensaje> listaMensajesEnviados) {
        this.listaMensajesEnviados = listaMensajesEnviados;
    }
    
    

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

    public boolean isActivaTexto() {
        return activaTexto;
    }

    public boolean isActivaEnviado() {
        return activaEnviado;
    }

    public void setActivaEnviado(boolean activaEnviado) {
        this.activaEnviado = activaEnviado;
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

    
   
    
    

    public void setActivaTexto(boolean activaTexto) {
        this.activaTexto = activaTexto;
    }

    public String getTextAreaEnviado() {
        return textAreaEnviado;
    }

    public void setTextAreaEnviado(String textAreaEnviado) {
        this.textAreaEnviado = textAreaEnviado;
    }

    public String getTemaEnviado() {
        return temaEnviado;
    }

    public void setTemaEnviado(String temaEnviado) {
        this.temaEnviado = temaEnviado;
    }

    public Mensaje getSelectedMensaje() {
        return selectedMensaje;
    }

    public void setSelectedMensaje(Mensaje selectedMensaje) {
        this.selectedMensaje = selectedMensaje;
    }

    public Mensaje getSelectedMensajeRecibido() {
        return selectedMensajeRecibido;
    }

    public void setSelectedMensajeRecibido(Mensaje selectedMensajeRecibido) {
        this.selectedMensajeRecibido = selectedMensajeRecibido;
    }
    
    
    
    
    
    
    
    
    
    public void activarTexto(){
        
        activaTexto=true;
    }
    
    
    
    
    
    public void activaMensaje(){
        
        activaTexto=true;
        
    }
    
    public void activaMensajeEnviado(){
        
        
    }
    
    public String enviarMensajeCoordinador(){
        
        Usuario destino=usuarioService.find("admin");
        
        
        Mensaje m=new Mensaje(user, destino, Calendar.getInstance().getTime(), tema, texto, "no");
        try{
        mensajeService.enviarMensaje(m);
        }catch(Exception ex){
            
            creaMensaje("se ha producido un error creando el mensaje", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
        creaMensaje("mensaje enviado correctamente", FacesMessage.SEVERITY_WARN);
        texto="";
        tema="";
        activaTexto=false;
        actualizar();
        return "";
    }
    
    public void cancelarEnvioCoordinador(){
        
        activaTexto=false;
    }
    
    public void actualizar(){
        
        setListaMensajesRecibidos((ArrayList<Mensaje>)mensajeService.mensajesEnviados("admin", user.getLogin()));
        setListaMensajesEnviados((ArrayList<Mensaje>)mensajeService.mensajesEnviados(user.getLogin(), "admin"));
        
    }
    
    public void leerMensajeEnviado(){
        
        activaEnviado=true;
        textAreaEnviado=selectedMensaje.getTexto();
        temaEnviado=selectedMensaje.getTema();
        
    }
    
    public void eliminarMensajeEnviado(){
        
        
    }
    
    
    public void cerrarMensajeEnviado(){
        
        textAreaEnviado="";
        temaEnviado="";
        activaEnviado=false;
        
    }
    
    public void leerMensajeRecibido(){
        
        activaRecibido=true;
        temaRecibido=selectedMensajeRecibido.getTema();
        textAreaRecibido=selectedMensajeRecibido.getTexto();
        
    }
    
    public void cerrarMensajeRecibido(){
        
        textAreaRecibido="";
        temaRecibido="";
        activaRecibido=false;
    }   
    
    
    
     public void creaMensaje(String texto,FacesMessage.Severity s){
            
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(texto);
            message.setSeverity(s);
            context.addMessage(null, message);
        }
    
    
    
    
}
