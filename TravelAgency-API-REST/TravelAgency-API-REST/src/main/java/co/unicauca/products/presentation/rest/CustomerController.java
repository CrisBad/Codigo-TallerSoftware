package co.unicauca.products.presentation.rest;

import co.unicauca.products.domain.service.CustomerService;
import co.unicauca.products.domain.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * API REST de los servicios web. Es muy simple por ahora, en otra versión se
 * hará una API más robusta. Son nuestros servicios web. La anotación @Path
 * indica la URL en la cual responderá los servicios. Esta anotación se puede
 * poner a nivel de clase y método. En este ejemplo todos los servicios
 * comparten el mismo Path, la acción se hacer mediante la anotació GET
 * (consultar), POST (agregar), PUT (editar), DELETE (eliminar).
 *
 * @author Cnunez
 */
@Stateless
@Path("customers")
public class CustomerController {
   
    /**
     * Se inyecta la única implementación que hay de ProductService
     */
    @Inject
    private CustomerService service;

    public CustomerController() {

    }
    
    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8080/TravelAgency-API-REST/customer-service/customers/
    */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customer> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8080/TravelAgency-API-REST/customer-service/customers/1
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer findById(@PathParam("id") int id) {
        return service.findCustomer(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
            http://localhost:8080/TravelAgency-API-REST/customer-service/customers/ \
            -H 'Content-Type: application/json' \
            -d '{
                "id": "98000012",
                "firstName": "Julian",
                "lastName": "Sanchez",
                "address": "Calle 17 No 19-12 Popayan",
                "mobile": "3145489752",
                "email": "julian@hotmail.com",
                "gender": "Masculino"
        }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(Customer cust) {
        if (service.createCustomer(cust)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente creado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el Cliente\",\"errores\":\"Id ya existe\"}";
        }
    }
    
    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8080/TravelAgency-API-REST/customer-service/customers/
    */

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Integer id) {
        if (service.delete(id)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente borrado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo borrar el cliente\",\"errores\":\"Id no existe\"}";
        }
    }
}
