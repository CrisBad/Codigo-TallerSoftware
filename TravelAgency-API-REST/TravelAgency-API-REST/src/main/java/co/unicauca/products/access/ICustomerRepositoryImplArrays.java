package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Default;

/**
 * Implementación por defecto. El framewok contenedor de CDI (Contexts and
 * Dependency Injection) carga la implementación por defecto.
 *
 * @author Cnunez
 */

@Default
public class ICustomerRepositoryImplArrays implements ICustomerRepository {
   
    /**
     * Array List de clientes
     */
    private static List<Customer> customers;

    public ICustomerRepositoryImplArrays() {
        if (customers == null){
            customers = new ArrayList();
            inicializar();
        }
        
    }

    private void inicializar() {
        customers.add(new Customer(98000001, "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino"));
        customers.add(new Customer(98000002, "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino"));
        customers.add(new Customer(98000003, "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino"));
        customers.add(new Customer(98000004, "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        customers.add(new Customer(98000005, "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(98000006, "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(98000007, "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(98000008, "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(98000009, "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(98000010, "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));

    }

    /**
     * Busca u Customer en el arreglo
     *
     * @param id cedula del customer
     * @return objeto Customer
     */
    @Override
    public Customer findCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public boolean createCustomer(Customer newCustomer) {
        Customer cust = this.findCustomer(newCustomer.getId());
        
        if (cust != null) {
            //Ya existe
            return false;
        }
        customers.add(newCustomer);
        return true;
    }
    
    @Override
    public boolean delete(Integer id) {
        int i = 0;
        for (Customer cus : customers) {
            if (cus.getId().equals(id)) {
            customers.remove(i++);
            return true;
            }
        }
        return false;
    }
}
