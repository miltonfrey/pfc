

package pojos;

import java.util.List;


public interface EquivalenciaService {
    
    
    public void crearEquivalencia(Equivalencia e);
    public void eliminarEquivalencia(Equivalencia e);
    public void actualizarEquivalencia(Equivalencia e);
    public List<Equivalencia> listarEquivalencias();
    
    public void crearGrupoAsignaturas(GrupoAsignatura grupo);
}


