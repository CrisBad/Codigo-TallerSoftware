package co.unicauca.products.domain.service;

import co.unicauca.products.domain.entity.Customer;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import co.unicauca.products.access.ICustomerRepository;
import java.util.List;

/**
 * Fachada de acceso al negocio por parte de la presentación. Usa el repositorio
 * por defecto. Si no se pone @Default tambien funciona, pues inyecta la
 * implementaició por defecto
 *
 * @author Cnunez
 */

@RequestScoped
public class CustomerService {
    /**
     * Repositorio de clientes
     */
    @Inject
    @Default
    ICustomerRepository repo;

    /**
     * Constructor
     */
    public CustomerService() {
        
    }
    
    public List<Customer> findAll() {
        return repo.findAll();
    }

    /**
     * Buscar un cliente
     *
     * @param id cedula
     * @return objeto tipo Customer
     */
    public Customer findCustomer(Integer id) {
        System.out.println(repo.findCustomer(id).toString());
        return repo.findCustomer(id);
    }

    /**
     * Crea un nuevo customer. Aplica validaciones de negocio
     *
     * @param customer cliente
     * @return devuelve un valor booleano
     */
    public boolean createCustomer(Customer customer) {
        return repo.createCustomer(customer);
    }
    
    /**
     * Elimina un customer. Aplica validaciones de negocio
     *
     * @param id identificador del cliente
     * @return devuelve un valor booleano
     */
    public boolean delete(int id) {
        return repo.delete(id);
    }
}
