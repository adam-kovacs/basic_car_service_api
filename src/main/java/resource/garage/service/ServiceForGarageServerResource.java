package resource.garage.service;

import model.Service;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import service.ServiceService;

public class ServiceForGarageServerResource extends ServerResource {

    private ServiceService serviceService = ServicesForGarageServerResource.serviceService;

    @Get
    public Service getService() {
        return serviceService.getServiceById(Integer.parseInt(getAttribute("serviceId")));
    }

    @Put
    public Service updateService(Service service) {
       return serviceService.updateService(service, Integer.parseInt(getAttribute("serviceId")));
    }

    @Delete
    public Service deleteService() {
        return serviceService.deleteService(Integer.parseInt(getAttribute("serviceId")));
    }
}
