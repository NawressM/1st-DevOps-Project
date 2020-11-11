package dsti.devops.carstore;

public class Car {
    protected String matriculation;
    protected String brand;
    protected String model;
    protected float price;
 
    public Car() {
    }
 
    public Car(String matriculation) {
        this.matriculation = matriculation;
    }
 
    public Car(String matriculation, String brand, String model, float price) {
        this.matriculation = matriculation;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
     
    
 
    public String getMatriculation() {
        return matriculation;
    }
 
    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
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
 
    public float getPrice() {
        return price;
    }
 
    public void setPrice(float price) {
        this.price = price;
    }
}
