package resource.garage.service;

import model.Service;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import resource.customer.car.service.ServicesForCarServerResource;
import service.ServiceService;
import java.util.List;


public class ServicesForGarageServerResource extends ServerResource {

    static ServiceService serviceService = ServicesForCarServerResource.serviceService;

    @Get
    public List<Service> getServices() {
        return serviceService.getServicesByGarage(Integer.parseInt(getAttribute("garageId")));
    }

    @Post
    public Service saveService(Service service) {
        return serviceService.saveService(Integer.parseInt(getAttribute("garageId")), service);
    }
}
