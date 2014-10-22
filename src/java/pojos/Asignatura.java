package pojos;
// Generated 22-oct-2014 10:55:47 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Asignatura generated by hbm2java
 */
@Entity
@Table(name="asignatura"
    ,catalog="pfc2"
)
public class Asignatura  implements java.io.Serializable {


     private AsignaturaId id;
     private Universidad universidad;
     private String nombreAsignatura;
     private Short creditos;
     private String periodo;
     private String infoAsigantura;
     private String webAsignatura;
     private String facultad;
     private String titulacion;
     private Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaAs = new HashSet<MiembroGrupoAsignaturaA>(0);
     private Set<MiembroGrupoAsignaturaB> miembroGrupoAsignaturaBs = new HashSet<MiembroGrupoAsignaturaB>(0);

    public Asignatura() {
    }

	
    public Asignatura(AsignaturaId id, Universidad universidad) {
        this.id = id;
        this.universidad = universidad;
    }
    public Asignatura(AsignaturaId id, Universidad universidad, String nombreAsignatura, Short creditos, String periodo, String infoAsigantura, String webAsignatura, String facultad, String titulacion, Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaAs, Set<MiembroGrupoAsignaturaB> miembroGrupoAsignaturaBs) {
       this.id = id;
       this.universidad = universidad;
       this.nombreAsignatura = nombreAsignatura;
       this.creditos = creditos;
       this.periodo = periodo;
       this.infoAsigantura = infoAsigantura;
       this.webAsignatura = webAsignatura;
       this.facultad = facultad;
       this.titulacion = titulacion;
       this.miembroGrupoAsignaturaAs = miembroGrupoAsignaturaAs;
       this.miembroGrupoAsignaturaBs = miembroGrupoAsignaturaBs;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="codAsignatura", column=@Column(name="codAsignatura", nullable=false) ), 
        @AttributeOverride(name="nombreUniversidad", column=@Column(name="nombreUniversidad", nullable=false, length=45) ) } )
    public AsignaturaId getId() {
        return this.id;
    }
    
    public void setId(AsignaturaId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nombreUniversidad", nullable=false, insertable=false, updatable=false)
    public Universidad getUniversidad() {
        return this.universidad;
    }
    
    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    
    @Column(name="nombreAsignatura", length=50)
    public String getNombreAsignatura() {
        return this.nombreAsignatura;
    }
    
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    
    @Column(name="creditos")
    public Short getCreditos() {
        return this.creditos;
    }
    
    public void setCreditos(Short creditos) {
        this.creditos = creditos;
    }

    
    @Column(name="periodo", length=10)
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
    @Column(name="infoAsigantura")
    public String getInfoAsigantura() {
        return this.infoAsigantura;
    }
    
    public void setInfoAsigantura(String infoAsigantura) {
        this.infoAsigantura = infoAsigantura;
    }

    
    @Column(name="webAsignatura", length=200)
    public String getWebAsignatura() {
        return this.webAsignatura;
    }
    
    public void setWebAsignatura(String webAsignatura) {
        this.webAsignatura = webAsignatura;
    }

    
    @Column(name="facultad", length=50)
    public String getFacultad() {
        return this.facultad;
    }
    
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    
    @Column(name="titulacion", length=45)
    public String getTitulacion() {
        return this.titulacion;
    }
    
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="asignatura")
    public Set<MiembroGrupoAsignaturaA> getMiembroGrupoAsignaturaAs() {
        return this.miembroGrupoAsignaturaAs;
    }
    
    public void setMiembroGrupoAsignaturaAs(Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaAs) {
        this.miembroGrupoAsignaturaAs = miembroGrupoAsignaturaAs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="asignatura")
    public Set<MiembroGrupoAsignaturaB> getMiembroGrupoAsignaturaBs() {
        return this.miembroGrupoAsignaturaBs;
    }
    
    public void setMiembroGrupoAsignaturaBs(Set<MiembroGrupoAsignaturaB> miembroGrupoAsignaturaBs) {
        this.miembroGrupoAsignaturaBs = miembroGrupoAsignaturaBs;
    }




}


