package Assignment2;

public class Customer {   //Additional class to print customer information
	private String name;  // Customer's name
    private String email; // Customer's email address
    private String phoneNum; // Customer's phone number
    
    public Customer(String name, String email, String phoneNum) { //Constructor
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public String getName() { //Getter method for name
        return name;
    }

    public void setName(String name) { //Setter method for name
        this.name = name;
    }

    public String getEmail() { //Getter method for email
        return email;
    }

    public void setEmail(String email) { //Setter method for email
        this.email = email;
    }

    public String getPhoneNum() { //Getter method for phoneNum
        return phoneNum;
    }

    public void setContact(String phoneNum) { //Setter method for phoneNum
        this.phoneNum = phoneNum;
    }
   
    
    public void displayCustomerDetails() { // Method to display customer details
        System.out.println("Customer details:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNum);
    }
}
