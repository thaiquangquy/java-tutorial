package design_patterns;

public class Car {
    public Car(String maker, String model, Integer year, double price) {
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    private String maker;
    private String model;
    private Integer year;
    private double price;
}
