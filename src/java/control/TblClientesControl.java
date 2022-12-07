package control;

import datos.ClientesDAO;
import java.util.List;
import modelo.TblClientes;

public class TblClientesControl {
    
    public List<TblClientes> listar() {
        return new ClientesDAO().listar();
    }
    
    public TblClientes buscar( TblClientes c) {
        return new ClientesDAO().buscar(c);
    }
    
    public void insertar( TblClientes c) {
        new ClientesDAO().insertar(c);
    }
    
    public void modificar(TblClientes c){
        new ClientesDAO().modificar(c);
    }
    
    public void eliminar(TblClientes c){
        new ClientesDAO().eliminar(c);
    }
}
