package pojos;
// Generated 04-sep-2014 0:25:19 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Universidad generated by hbm2java
 */
@Entity
@Table(name="universidad"
    ,catalog="pfc"
    , uniqueConstraints = @UniqueConstraint(columnNames="codUniversidad") 
)
public class Universidad  implements java.io.Serializable {


     private String nombre;
     private Pais pais;
     private String info;
     private String web;
     private String codUniversidad;
     private Set<Movilidad> movilidads = new HashSet<Movilidad>(0);
     private Set<Asignatura> asignaturas = new HashSet<Asignatura>(0);

    public Universidad() {
    }

	
    public Universidad(String nombre, String codUniversidad) {
        this.nombre = nombre;
        this.codUniversidad = codUniversidad;
    }
    public Universidad(String nombre, Pais pais, String info, String web, String codUniversidad, Set<Movilidad> movilidads, Set<Asignatura> asignaturas) {
       this.nombre = nombre;
       this.pais = pais;
       this.info = info;
       this.web = web;
       this.codUniversidad = codUniversidad;
       this.movilidads = movilidads;
       this.asignaturas = asignaturas;
    }
   
     @Id 

    
    @Column(name="nombre", unique=true, nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pais")
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    @Column(name="info")
    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    
    @Column(name="web", length=50)
    public String getWeb() {
        return this.web;
    }
    
    public void setWeb(String web) {
        this.web = web;
    }

    
    @Column(name="codUniversidad", unique=true, nullable=false, length=15)
    public String getCodUniversidad() {
        return this.codUniversidad;
    }
    
    public void setCodUniversidad(String codUniversidad) {
        this.codUniversidad = codUniversidad;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="universidad")
    public Set<Movilidad> getMovilidads() {
        return this.movilidads;
    }
    
    public void setMovilidads(Set<Movilidad> movilidads) {
        this.movilidads = movilidads;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="universidad")
    public Set<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }
    
    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }




}


