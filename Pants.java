package Assignment2;

public class Pants extends Clothes { //Pants class inherits Clothes class
	private String pantsStyle; //Distinctive attribute of Pants class
	
	public Pants (String brand, String colour, double price, char size, int quantity,boolean discount, String pantsStyle) {
        super(brand, colour, price, size, quantity, discount); //Calls the super class method
        this.pantsStyle = pantsStyle;
    }
	
    public Pants() { //Empty constructor for pantsStyle
    	super();
        this.pantsStyle = "Unknown";

    }

	public String getPantsStyle() { //Getter method for distinctive attribute (Encapsulation)
        return pantsStyle;
    }

    public void setPantsStyle (String pantsStyle) { //Setter method for distinctive attribute (Encapsulation)
        this.pantsStyle = pantsStyle;
    }

   
    
	@Override
    public void displayDetails() {  // Polymorphism method to diplayDetails
            System.out.println("Clothing brand: " + getBrand());
            System.out.println("Item colour: " + getColour());
            System.out.println("Pants style: " + pantsStyle);
            System.out.println("Price: RM" + getPrice());
            System.out.println("Size: " + getSize());
            System.out.println("Item quantity: " + getQuantity());
        }
}
