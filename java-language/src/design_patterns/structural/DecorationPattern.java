package design_patterns.structural;

abstract class CarFeature extends Car {
    protected Car car;

    public CarFeature(Car car) {
        super(car.getMaker(), car.getModel(), car.getYear(), car.getPrice());
        this.car = car;
    }

    public abstract double getPrice();
}

class SalesTaxDecorator extends CarFeature {
    public SalesTaxDecorator(Car car) {
        super(car);
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() * 1.10;
    }
}

class NavigationDecorator extends CarFeature {
    public NavigationDecorator(Car car) {
        super(car);
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() + 1500;
    }
}

class SunroofDecorator extends CarFeature {

    public SunroofDecorator(Car car) {
        super(car);
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() + 1000;
    }
}

public class DecorationPattern {
    public static void main(String[] args) {
        Car car = new Car("Honda", "Accord", 2022, 25000);
        SalesTaxDecorator carWithSalesTax = new SalesTaxDecorator(car);
        NavigationDecorator carWithNavigation = new NavigationDecorator(carWithSalesTax);
        SunroofDecorator carWithSunroof = new SunroofDecorator(carWithNavigation);

        System.out.println(carWithSunroof.getPrice());
    }
}
