/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class beanContrato implements Serializable{

    @ManagedProperty(value="#{movilidadService}")
    private MovilidadService movilidadService;
    
    @ManagedProperty(value="#{asignaturaService}")
    private AsignaturaService asignaturaService;
    
    
    private HttpServletRequest request;
    
    private ArrayList<Movilidad> listaMovilidadesValidas;
    private Movilidad selectedMovilidad;
    private Asignatura selectedAsignatura;
    
    
    
    private ArrayList<Asignatura>listaAsignaturasUniversidad;
    private ArrayList<Asignatura>listaAsignaturasFic;
    
    private ArrayList<Asignatura> selectedAsignaturas;
    private ArrayList<Asignatura> filteredAsignaturasFic;
    private ArrayList<Asignatura> filteredAsignaturasUni;
    
    
    public beanContrato() {
    }
    
    @PostConstruct
    public void init(){
        
        HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       
        if((Usuario)session.getAttribute("user")!=null){
           user=(Usuario)session.getAttribute("user");
        } 
        listaMovilidadesValidas=(ArrayList<Movilidad>)movilidadService.listarMovilidadesValidas(user.getLogin());
        
        //if (request.getRequestURI().equals(request.getContextPath()+"/usuario/elaborarContrato.xhtml"))
        
        
        
    }
    
    

    public MovilidadService getMovilidadService() {
        return movilidadService;
    }

    public void setMovilidadService(MovilidadService movilidadService) {
        this.movilidadService = movilidadService;
    }

    public AsignaturaService getAsignaturaService() {
        return asignaturaService;
    }

    public void setAsignaturaService(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private Usuario user;
    
    
    public Movilidad getSelectedMovilidad() {
        return selectedMovilidad;
    }

    public void setSelectedMovilidad(Movilidad selectedMovilidad) {
        this.selectedMovilidad = selectedMovilidad;
    }

    public ArrayList<Movilidad> getListaMovilidadesValidas() {
        return listaMovilidadesValidas;
    }

    public void setListaMovilidadesValidas(ArrayList<Movilidad> listaMovilidadesValidas) {
        this.listaMovilidadesValidas = listaMovilidadesValidas;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ArrayList<Asignatura> getListaAsignaturasUniversidad() {
    
        return listaAsignaturasUniversidad;
    }

    public void setListaAsignaturasUniversidad(ArrayList<Asignatura> listaAsignaturasUniversidad) {
        this.listaAsignaturasUniversidad = listaAsignaturasUniversidad;
    }

    public ArrayList<Asignatura> getListaAsignaturasFic() {
        return listaAsignaturasFic;
    }

    public void setListaAsignaturasFic(ArrayList<Asignatura> listaAsignaturasFic) {
        this.listaAsignaturasFic = listaAsignaturasFic;
    }

    public ArrayList<Asignatura> getSelectedAsignaturas() {
        return selectedAsignaturas;
    }

    public void setSelectedAsignaturas(ArrayList<Asignatura> selectedAsignaturas) {
        this.selectedAsignaturas = selectedAsignaturas;
    }

    public ArrayList<Asignatura> getFilteredAsignaturasFic() {
        return filteredAsignaturasFic;
    }

    public void setFilteredAsignaturasFic(ArrayList<Asignatura> filteredAsignaturasFic) {
        this.filteredAsignaturasFic = filteredAsignaturasFic;
    }

    public ArrayList<Asignatura> getFilteredAsignaturasUni() {
        return filteredAsignaturasUni;
    }

    public void setFilteredAsignaturasUni(ArrayList<Asignatura> filteredAsignaturasUni) {
        this.filteredAsignaturasUni = filteredAsignaturasUni;
    }

   

    public Asignatura getSelectedAsignatura() {
        return selectedAsignatura;
    }

    public void setSelectedAsignatura(Asignatura selectedAsignatura) {
        this.selectedAsignatura = selectedAsignatura;
    }
    
    
    
    
    
    
    
    
    
    
    public String crearContrato(){
        
        
        listaAsignaturasFic=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad("UDC");
        listaAsignaturasUniversidad=(ArrayList<Asignatura>)asignaturaService.listarAsignaturasPorUniversidad(selectedMovilidad.getUniversidad().getNombre());
        
        return ("elaborarContrato.xhtml?faces-redirect=true");
        
        
    }
    
    public String detallesAsign(){
        
        return "detallesAsign.xhtml?faces-redirect=true";
        
    }
    
    
    
    
}
