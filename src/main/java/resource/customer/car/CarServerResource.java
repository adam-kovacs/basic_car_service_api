package resource.customer.car;

import model.Car;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import service.CarService;

public class CarServerResource extends ServerResource {

    private CarService carService = CarsServerResource.carService;


    @Get
    public Car getCar() {
        return carService.getCarById(Integer.parseInt(getAttribute("carId")));
    }

    @Put
    public Car updateCar(Car car) {
        Integer customerId = Integer.parseInt(getAttribute("customerId"));
        Integer carId = Integer.parseInt(getAttribute("carId"));
        return carService.updateCar(customerId, car);
    }

    @Delete
    public Car deleteCar() {
        return carService.deleteCar(Integer.parseInt(getAttribute("carId")));
    }
}