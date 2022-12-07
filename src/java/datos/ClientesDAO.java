
package datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.TblClientes;


public class ClientesDAO {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ClientesPU" );
    EntityManager em = emf.createEntityManager();
    
    public List<TblClientes> listar() {
        TypedQuery<TblClientes> query = em.createNamedQuery("TblClientes.findAll", TblClientes.class);
        List<TblClientes> result = query.getResultList();
        return result;
    }
    
    public TblClientes buscar( TblClientes c) {
        c = em.find(TblClientes.class, c.getCedulaCliente());
        return c;
    }
    
    public void insertar( TblClientes c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public void modificar(TblClientes c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }
    
    public void eliminar( TblClientes c){
        em.getTransaction().begin();
        c = em.find(TblClientes.class, c.getCedulaCliente());
        em.remove(c);
        em.getTransaction().commit();
    }
}
