package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HI
 */
public class Fruit {
    private String Id;
    private String Name;
    private double Price;
    private int Quantity;
    private String Origin;

    public Fruit() {
    }
    
    
    public Fruit(String Id, String Name, double Price, int Quantity, String Origin) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Origin = Origin;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    @Override
    public String toString() {
        return "Fruit{" + "Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Quantity=" + Quantity + ", Origin=" + Origin + '}';
    }
    
    
}
