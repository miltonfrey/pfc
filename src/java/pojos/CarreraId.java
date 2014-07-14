package pojos;
// Generated 14-jul-2014 17:58:38 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CarreraId generated by hbm2java
 */
@Embeddable
public class CarreraId  implements java.io.Serializable {


     private String nombre;
     private String universidad;

    public CarreraId() {
    }

    public CarreraId(String nombre, String universidad) {
       this.nombre = nombre;
       this.universidad = universidad;
    }
   


    @Column(name="nombre", nullable=false, length=40)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Column(name="universidad", nullable=false, length=45)
    public String getUniversidad() {
        return this.universidad;
    }
    
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CarreraId) ) return false;
		 CarreraId castOther = ( CarreraId ) other; 
         
		 return ( (this.getNombre()==castOther.getNombre()) || ( this.getNombre()!=null && castOther.getNombre()!=null && this.getNombre().equals(castOther.getNombre()) ) )
 && ( (this.getUniversidad()==castOther.getUniversidad()) || ( this.getUniversidad()!=null && castOther.getUniversidad()!=null && this.getUniversidad().equals(castOther.getUniversidad()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNombre() == null ? 0 : this.getNombre().hashCode() );
         result = 37 * result + ( getUniversidad() == null ? 0 : this.getUniversidad().hashCode() );
         return result;
   }   


}

