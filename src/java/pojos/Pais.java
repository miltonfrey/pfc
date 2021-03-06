package pojos;
// Generated 02-oct-2014 14:56:35 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pais generated by hbm2java
 */
@Entity
@Table(name="pais"
    ,catalog="pfc"
)
public class Pais  implements java.io.Serializable {


     private String nombre;
     private Set<Universidad> universidads = new HashSet<Universidad>(0);

    public Pais() {
    }

	
    public Pais(String nombre) {
        this.nombre = nombre;
    }
    public Pais(String nombre, Set<Universidad> universidads) {
       this.nombre = nombre;
       this.universidads = universidads;
    }
   
     @Id 

    
    @Column(name="nombre", unique=true, nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pais")
    public Set<Universidad> getUniversidads() {
        return this.universidads;
    }
    
    public void setUniversidads(Set<Universidad> universidads) {
        this.universidads = universidads;
    }




}


