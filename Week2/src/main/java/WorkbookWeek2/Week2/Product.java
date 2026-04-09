package WorkbookWeek2.Week2;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    private String name;
    private  String description;
    private double price;
    private int quantity;
    
    public Product() {
    	
    }
    
    
    public void setName(String name ) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setPrice(double price ) {
    	this.price = price;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public void setQuantity(int quantity ) {
    	this.quantity = quantity;
    }
    
    public int getQuantity() {
    	return quantity;
    }
    
}