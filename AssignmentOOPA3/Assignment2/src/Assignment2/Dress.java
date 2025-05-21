package Assignment2;

public class Dress extends Clothes { //Dress class inherits Clothes class
	private String dressLength; //Distinctive attribute of Dress class

	public Dress(String brand, String colour, double price, char size, int quantity, String dressLength) {
        super(brand, colour, price, size, quantity); //Calls the super class method
        this.dressLength = dressLength;
    }

    public Dress() { //Empty constructor for dressLength
    	super();
        this.dressLength = "Unknown";
	}

	public String getDressLength() { //Getter method for distinctive attribute (Encapsulation)
        return dressLength;
    }

    public void setDressLength(String dressLength) { //Setter method for distinctive attribute (Encapsulation)
        this.dressLength = dressLength;
    }


	
	@Override
    public void displayDetails() {  // Polymorphism method to diplayDetails
            System.out.println("Clothing brand: " + getBrand());
            System.out.println("Item colour: " + getColour());
            System.out.println("Length: " + dressLength);
            System.out.println("Price: RM" + getPrice());
            System.out.println("Size: " + getSize());
            System.out.println("Item quantity: " + getQuantity());
        }
	
	
	public String dressOccassion() { //Distinctive method for Dress class
	    if (dressLength.equalsIgnoreCase("Short")) {
	        return "Parties and casual events";
	    } else if (dressLength.equalsIgnoreCase("Medium")) {
	        return "Casual and formal events";
	    } else if (dressLength.equalsIgnoreCase("Long")) {
	        return "Formal events";
	    } else {
	        return "Unknow occasion";
	    }
	}
}