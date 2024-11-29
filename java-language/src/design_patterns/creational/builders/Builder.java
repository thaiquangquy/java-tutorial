package design_patterns.creational.builders;

import design_patterns.creational.builders.cars.CarType;
import design_patterns.creational.builders.components.Engine;
import design_patterns.creational.builders.components.GPSNavigator;
import design_patterns.creational.builders.components.Transmission;
import design_patterns.creational.builders.components.TripComputer;

public interface Builder {
    void setCarType(CarType carType);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
