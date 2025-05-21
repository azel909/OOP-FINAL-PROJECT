package Assignment2;
public class Main {

	public static void main(String[] args) {
		Shirt newShirt = new Shirt(); //Creating newShirt object
		Dress newDress =  new Dress(); //Creating newDress object
		Pants newPants = new Pants(); //Creating newPants object
		Customer newCustomer = new Customer ("Hannah", "hannah123@gmail.com", "0123456789"); 
		//Creating newCustomer object
		Payment newPayment = new Payment("Credit Card", true); //Creating newPayment object
        Order newOrder = new Order ("12/4/2025", "2.00 PM"); //Creating newOrder object 
        new Login();
        new GUI2();
        new HomePage();
        
		
		
		//Setting newShirt attributes using setter methods
        newShirt.setBrand("Gucci");
        newShirt.setColour("Purple");
        newShirt.setPrice(241.10);
        newShirt.setSize('S'); 
        newShirt.setQuantity(4);
        newShirt.setShirtMaterial("Silk");

        //Setting newDress attributes using setter methods
        newDress.setBrand("Dior");
        newDress.setColour("Red");
        newDress.setPrice(300.00);
        newDress.setSize('M');
        newDress.setQuantity(2);
        newDress.setDressLength("Short");

        //Setting newPants attributes using setter methods
        newPants.setBrand("Levis");
        newPants.setColour("Blue");
        newPants.setPrice(180.50);
        newPants.setSize('L');
        newPants.setQuantity(5);
        newPants.setPantsStyle("Jeans");
        
        Clothes[] clothesArray = {newShirt, newDress, newPants};
        
        System.out.println("CLOTHING STORE RECEIPT");
        System.out.println("----------------------------");
        
        
        for (int i = 0; i < clothesArray.length; i++) {
        	
            System.out.println("Item No. " + (i + 1));
            clothesArray[i].displayDetails();          //Method that shows polymorphism
            
            if (clothesArray[i] instanceof Dress) { //Checks if the item is dress 
                Dress x = (Dress) clothesArray[i];  //to perform distinctive method
                System.out.println("Dress occasion: " + x.dressOccassion());
            }

            System.out.println("Total price: RM" + clothesArray[i].totalPrice());
            System.out.println("Discount percentage : 40%");
            System.out.println("Discount amount : RM" + clothesArray[i].discount(40));
            System.out.println("Final price: RM" + clothesArray[i].finalPrice(40));
            System.out.println("----------------------------");

        }
        
        newShirt.setPrice(200.00);  // Manipulation of attribute price using setter
        newShirt.setQuantity(3);   // Manipulation of attribute quantity using setter
        System.out.println("UPDATED RECEIPT FOR ITEM NO. 1"); //Updated for item 1/array[0]
        System.out.println("----------------------------");
        System.out.println("Clothing brand: " + newShirt.getBrand());
        System.out.println("Item colour: " + newShirt.getColour());
        System.out.println("Shirt material: " + newShirt.getShirtMaterial());
        System.out.println("Price: RM" + newShirt.getPrice());
        System.out.println("Size: " + newShirt.getSize());
        System.out.println("Item quantity: " + newShirt.getQuantity());
        System.out.println("Total price: RM" + newShirt.totalPrice());
        System.out.println("Discount percentage: 40%");
        System.out.println("Discount amount: RM" + newShirt.discount(40.00));
        System.out.println("Final price: RM" + newShirt.finalPrice(40.00));
        System.out.println("----------------------------");
        
        
        
        double grandTotal = 0.0;
        // Calculate total of all items after discount
        for (int i = 0; i < clothesArray.length; i++) {
             grandTotal += clothesArray[i].finalPrice(40.00); //Add each item's final price 
                                                              //to grandTotal
          }
        
        String formattedTotal = String.format("%.2f", grandTotal); //Fixes the decimal round-off
        System.out.println("Grand Total: RM" + formattedTotal);
        System.out.println("----------------------------");
        
        newCustomer.displayCustomerDetails(); //Method to print customer details
        newPayment.paymentProcess(); //Method to print payment processes
        newOrder.orderDetails(); //Method to print order details (Time and date)
        
        System.out.println("----------------------------------------------------------");
        if (grandTotal > 500) {  //Use if-else to decide if receive a voucher or not based on 
        	                    //grandTotal value
        	System.out.println("Thank you for shopping with us!");
        	System.out.println("You have received a 25% off voucher for the next purchase!");
        } else {
            System.out.println("Thank you for shopping with us!");
        }
            System.out.println("----------------------------------------------------------");
    }
}
