package Assignment2;

public class Shirt extends Clothes {//Shirt class inherits Clothes class
    private String shirtMaterial; //Distinctive attribute of Shirt class
    
    public Shirt(String brand, String colour, double price, char size, int quantity,String shirtMaterial) {
        super(brand, colour, price, size, quantity); //Calls the super class method
        this.shirtMaterial = shirtMaterial;
    }
    
    public Shirt() { //Empty constructor for shirtMaterial
		super();
		this.shirtMaterial = "Unknown";
	}

	public String getShirtMaterial() { //Getter method for distinctive attribute (Encapsulation)
        return shirtMaterial;
    }

    public void setShirtMaterial(String shirtMaterial) { //Setter method for distinctive attribute (Encapsulation)
        this.shirtMaterial = shirtMaterial;
    }

    
    
    @Override
	public void displayDetails() { // Polymorphism method to diplayDetails
        System.out.println("Clothing brand: " + getBrand());
        System.out.println("Item colour: " + getColour());
        System.out.println("Shirt material: " + shirtMaterial);
        System.out.println("Price: RM" + getPrice());
        System.out.println("Size: " + getSize());
        System.out.println("Item quantity: " + getQuantity());
    }
}
