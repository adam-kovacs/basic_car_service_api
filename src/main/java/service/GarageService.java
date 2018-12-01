package service;

import dao.GarageDAO;
import model.Garage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GarageService {

    private GarageDAO garageDAO;

//    TODO: Solve logic without instantiation
    public GarageService() {
        garageDAO = new GarageDAO();
    }

    public List<Garage> getGarages() {
        return garageDAO.findAll();
    }

    public Garage saveGarage(Garage garage) {
        garageDAO.save(garage);
        return getGarageById(garage.getId());
    }

    public Garage getGarageById(Integer id) {
        return garageDAO.findById(id);
    }

    public Garage updateGarage(Garage garage) {
        garageDAO.update(garage);
        return getGarageById(garage.getId());
    }

    public Garage deleteGarage(Integer garageId) {
        return garageDAO.delete(garageId);
    }
}
