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
public class eliminarUsuarioBean implements Serializable{

    @ManagedProperty(value="#{beanUtilidades}")
    private beanUtilidades beanUtilidades;
    
    @ManagedProperty(value="#{usuarioService}")  
    private transient UsuarioService usuarioService;
    
    
    private ArrayList<Usuario> selectedUsuarios;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Usuario> filteredUsuarios;
    
    
    public eliminarUsuarioBean() {
    }
    @PostConstruct
    public void init(){
        
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        
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

    public ArrayList<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(ArrayList<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
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
    
    
    
    public String eliminaUsuariosLista(){
        
        if(selectedUsuarios.isEmpty()){
            return null;
        }
        
        for(Usuario u:selectedUsuarios){
        
        try{
         usuarioService.delete(u);
      
        }catch(Exception ex){
                     
            beanUtilidades.creaMensaje("error al eliminar "+ u.getLogin(), FacesMessage.SEVERITY_FATAL);
            return null;
                 }
        }
        beanUtilidades.creaMensaje("usuarios borrado ", FacesMessage.SEVERITY_INFO);
        setListaUsuarios((ArrayList < Usuario >)usuarioService.listar());
        return null;
          
    }
    
    
    
    
    
    
    
}
