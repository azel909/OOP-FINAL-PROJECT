package Assignment2;

public class Order {
   private String date;
   private String time;
   
   public Order( String date, String time) { //Constructors
       this.date = date;
       this.time = time;  
   }
   
   public String getDate() {
	   return date;
   }
   
   public void setDate(String date) {
	   this.date = date;
   }

   public String getTime() {
	   return time;
   }
   
   public void setTime(String time) {
	   this.time = time;
   }
   
   public void orderDetails() {
	   System.out.println("Date of payment: " + date);
	   System.out.println("Time of payment: "+ time);
   }
}
