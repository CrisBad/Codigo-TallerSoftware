package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Customer;
import java.util.List;

/**
 * Interface de los servicios del repositorio
 *
 * @author Cnunez
 */
public interface ICustomerRepository {
    
    
     List<Customer> findAll();
    
    Customer findCustomer(int id);
    
    boolean createCustomer(Customer customer);
    
    boolean delete(Integer id);

}
