package Assignment2;

public abstract class Clothes implements ClothingInterface { //Clothes class is the base class
	                                                         //Or Super class
	
	private String brand; //Creating private attributes
	private String colour;
	private double price;
	private char size;
	private int quantity;
    
	public Clothes() {    //Creating empty constructors (takes no parameters/
		brand="Unknown"; //Initializes object with default values)
		colour = "Unknown"; 
		price = 0.00;
		size = '-';
		quantity = 0;                  	
	}
    
	
	public Clothes(String brand,String colour,double price,char size,int quantity) {
		this.brand= brand; //Creating parameterized constructors
		this.colour = colour;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
	}

	public String getBrand() { //Getter method 1 for brand
		return brand;
	}

	public void setBrand(String brand) { //Setter method 1 for brand
		this.brand = brand;
	}

	public String getColour() { //Getter method 2 for colour
		return colour;
	}

	public void setColour(String colour) { //Setter method 2 for colour
		this.colour= colour;
	}

	public double getPrice() { //Getter method 3 for price
		return price;
	}

	public void setPrice(Double price) { //Setter method 3 for price
		this.price= price;
	}

	public char getSize() { //Getter method 4 for size
		return size;
	}

	public void setSize(char size) { //Setter method 4 for size
		this.size= size;
	}

	public int getQuantity() { //Getter method 5 for quantity
		return quantity;
	}

	public void setQuantity(int quantity) { //Setter method 5 for quantity
		this.quantity= quantity;
	}
	
	

	public double totalPrice(){ //Method 1 to calculate total price
		return price*quantity;
	}

	
	
	public double discount(double discountPercent) { //Method 2 to calculate discount amount
		return totalPrice() * (discountPercent/100);
	}

	
	
	public double finalPrice(double discountPercent) { //Method 3 to calculate final price 
		return totalPrice()- discount(discountPercent);//after discount
	}


	
	public void displayDetails() { // Polymorphism method to diplayDetails
        System.out.println("Clothing brand: " + brand);
        System.out.println("Item colour: " + colour);
        System.out.println("Price: RM" + price);
        System.out.println("Size: " + size);
        System.out.println("Item quantity: " + quantity);
    }
}