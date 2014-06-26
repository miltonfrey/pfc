/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;


public interface UsuarioService {
    
    public Usuario find(String nombre);
    public void delete(Usuario u);
    public List<Usuario> listar();
    
    
    
}
