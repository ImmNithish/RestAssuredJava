package day4;


import java.util.Random;



public class Invoice {

	
	

	String SalesOrder ;
	 int invoice;
	

		    public static int generateRandomInt(int minValue, int maxValue) {
		        Random random = new Random();
		        return random.nextInt(maxValue - minValue + 1) + minValue;
		    }
		    
		    public static String appendCleintID(int length) {
		          String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789-";
		          Random random = new Random();
		            StringBuilder stringBuilder = new StringBuilder(length);

		            // Loop to append random characters to the StringBuilder
		            for (int i = 0; i < length; i++) {
		                int randomIndex = random.nextInt(CHARACTERS.length());
		                char randomChar = CHARACTERS.charAt(randomIndex);
		                stringBuilder.append(randomChar);
		            }

		            // Return the generated random string
		            return stringBuilder.toString();
		        }
		  
	
	 public String getSalesOrder() {
		return SalesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		SalesOrder = salesOrder;
	}


	public int getInvoice() {
		return invoice;
	}


	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}
	
	
	
	

	
}
