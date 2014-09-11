/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;


public interface EquivalenciaDao {
    
    public void insertarEquivalencia(Equivalencia e);
   public void eliminarEquivalencia(Equivalencia e);
    public void actualizarEquivalencia(Equivalencia e);
    public List<Equivalencia> listarEquivalencias();
    
    public void insertarGrupoAsignaturas(GrupoAsignatura grupo);
    
    public void insertarMiembroGrupoAsignatura(MiembroGrupoAsignatura m);
    
}
