package Assignment2;

public class Payment { 
	 private String paymentMethod;   // Payment method (Credit Card, Cash)
	 private boolean paymentStatus;  // Payment status
	 
	 
	 public Payment( String paymentMethod, boolean paymentStatus) { //Constructors
	        this.paymentMethod = paymentMethod;
	        this.paymentStatus = paymentStatus;  
	 }
	 

	    public String getPaymentMethod() { //Getter method for payment method
	        return paymentMethod;
	    }

	    public void setPaymentMethod(String paymentMethod) { //Setter method for payment method
	        this.paymentMethod = paymentMethod;
	    }

	    public boolean getPaymentStatus() { //Getter method for payment status
	        return paymentStatus;
	    }

	    public void setPaymentStatus(boolean paymentStatus) { //Setter method for payment status
	        this.paymentStatus = paymentStatus;
	    }

	    public void paymentProcess() {
	    	System.out.println("Payment method: " + paymentMethod);
	        if (paymentStatus == true) {
	           System.out.println("Payment has been accepted");
	           System.out.println("Paid");
	    }
	        else {
	        	System.out.println("Payment unaccepted");
	        	System.out.println("Unpaid");
	        }
	    }
}
