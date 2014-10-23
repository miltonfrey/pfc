/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;


public interface EquivalenciaDao {
    
    public void creaContrato(Contrato c);
    public void modificaContrato(Contrato c);
    public List<Contrato> listaContratos(Movilidad m);
    public void eliminaContrato(Contrato c);
    
    
    
    public void insertarEquivalencia(Equivalencia e);
   public void eliminarEquivalencia(Equivalencia e);
    public void actualizarEquivalencia(Equivalencia e);
    public List<Equivalencia> listarEquivalencias();
    public List<Equivalencia> listarEquivalenciasPorContrato(Integer id);
    
    public void insertarGrupoAsignaturasA(GrupoAsignaturaA grupo);
    public void insertarGrupoAsignaturasB(GrupoAsignaturaB grupo);
   // public void insertarMiembroGrupoAsignatura(MiembroGrupoAsignatura m);
    public Contrato findContrato(Integer id);
   
}
