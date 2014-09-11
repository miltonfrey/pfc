package pojos;
// Generated 11-sep-2014 19:42:43 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AsignaturaId generated by hbm2java
 */
@Embeddable
public class AsignaturaId  implements java.io.Serializable {


     private int codAsignatura;
     private String nombreUniversidad;

    public AsignaturaId() {
    }

    public AsignaturaId(int codAsignatura, String nombreUniversidad) {
       this.codAsignatura = codAsignatura;
       this.nombreUniversidad = nombreUniversidad;
    }
   


    @Column(name="codAsignatura", nullable=false)
    public int getCodAsignatura() {
        return this.codAsignatura;
    }
    
    public void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }


    @Column(name="nombreUniversidad", nullable=false, length=45)
    public String getNombreUniversidad() {
        return this.nombreUniversidad;
    }
    
    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AsignaturaId) ) return false;
		 AsignaturaId castOther = ( AsignaturaId ) other; 
         
		 return (this.getCodAsignatura()==castOther.getCodAsignatura())
 && ( (this.getNombreUniversidad()==castOther.getNombreUniversidad()) || ( this.getNombreUniversidad()!=null && castOther.getNombreUniversidad()!=null && this.getNombreUniversidad().equals(castOther.getNombreUniversidad()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCodAsignatura();
         result = 37 * result + ( getNombreUniversidad() == null ? 0 : this.getNombreUniversidad().hashCode() );
         return result;
   }   


}


