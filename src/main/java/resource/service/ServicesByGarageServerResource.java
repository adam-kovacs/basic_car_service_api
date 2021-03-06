package resource.service;

import com.google.inject.Inject;
import model.Service;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import service.model.ServiceService;
import java.util.List;


public class ServicesByGarageServerResource extends ServerResource {

    @Inject
    private ServiceService serviceService;

    @Get
    public List<Service> getServices() {
        return serviceService.getServicesByGarage(Integer.parseInt(getAttribute("garageId")));
    }

    @Post
    public Service saveService(Service service) {
        return serviceService.saveService(service, Integer.parseInt(getAttribute("garageId")));
    }
}
