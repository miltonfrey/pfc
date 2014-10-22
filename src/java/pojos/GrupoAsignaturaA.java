package pojos;
// Generated 22-oct-2014 15:25:10 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * GrupoAsignaturaA generated by hbm2java
 */
@Entity
@Table(name="grupo_asignatura_a"
    ,catalog="pfc2"
)
public class GrupoAsignaturaA  implements java.io.Serializable {


     private Integer idequivalencia;
     private Equivalencia equivalencia;
     private Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaAs = new HashSet<MiembroGrupoAsignaturaA>(0);

    public GrupoAsignaturaA() {
    }

	
    public GrupoAsignaturaA(Equivalencia equivalencia) {
        this.equivalencia = equivalencia;
    }
    public GrupoAsignaturaA(Equivalencia equivalencia, Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaAs) {
       this.equivalencia = equivalencia;
       this.miembroGrupoAsignaturaAs = miembroGrupoAsignaturaAs;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="equivalencia"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="idequivalencia", unique=true, nullable=false)
    public Integer getIdequivalencia() {
        return this.idequivalencia;
    }
    
    public void setIdequivalencia(Integer idequivalencia) {
        this.idequivalencia = idequivalencia;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Equivalencia getEquivalencia() {
        return this.equivalencia;
    }
    
    public void setEquivalencia(Equivalencia equivalencia) {
        this.equivalencia = equivalencia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="grupoAsignaturaA")
    public Set<MiembroGrupoAsignaturaA> getMiembroGrupoAsignaturaAs() {
        return this.miembroGrupoAsignaturaAs;
    }
    
    public void setMiembroGrupoAsignaturaAs(Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaAs) {
        this.miembroGrupoAsignaturaAs = miembroGrupoAsignaturaAs;
    }




}


