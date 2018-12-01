package resource.customer;

import model.Customer;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import service.CustomerService;

public class CustomerServerResource extends ServerResource {

    private CustomerService customerService = CustomersServerResource.customerService;

    @Get
    public Customer getCustomer() {
        return customerService.getCustomerById(Integer.parseInt(getAttribute("customerId")));
    }

    @Put
    public Customer updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer, Integer.parseInt(getAttribute("customerId")));
    }

    @Delete
    public Customer deleteCustomer() {
        return customerService.deleteCustomer(Integer.parseInt(getAttribute("customerId")));
    }
}
