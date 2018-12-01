import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import dao.CarDAO;
import dao.CustomerDAO;
import dao.GarageDAO;
import dao.ServiceDAO;
import service.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(CarServerApplication.class).asEagerSingleton();

        bind(CustomerDAO.class).asEagerSingleton();
        bind(CarDAO.class).asEagerSingleton();
        bind(GarageDAO.class).asEagerSingleton();
        bind(ServiceDAO.class).asEagerSingleton();

        bind(CustomerService.class).asEagerSingleton();
        bind(CarService.class).asEagerSingleton();
        bind(GarageService.class).asEagerSingleton();
        bind(ServiceService.class).asEagerSingleton();

        bind(CarValidationService.class).asEagerSingleton();

    }

    @Provides
    @Singleton
    public EntityManagerFactory providesManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("jpa");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
