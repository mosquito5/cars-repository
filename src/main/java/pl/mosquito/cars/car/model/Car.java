package pl.mosquito.cars.car.model;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double mileage;
    private int engineSize;
    private double price;
    private String brand;
    private String model;
    private String fuel;

    Car() {
    }

    public Car(double mileage, int engineSize, double price, String brand, String model, String fuel) {
        //  super();
        this.mileage = mileage;
        this.engineSize = engineSize;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

}
