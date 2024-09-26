package order;

import java.io.Serializable;

public class BeanOfOrder implements Serializable
{
	private static final long serialVersionUID = -1288087366134535424L;
    
	private String customerName;
	private String crust;
	private String toppings;
	private String Appetizer;
	private String Address;
	private String creditCard;
	private String creditCardNumber;
	private String repeatCreditCardNumber;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public String getToppings() {
		return toppings;
	}
	public void setToppings(String toppings) {
		this.toppings = toppings;
	}
	public String getAppetizer() {
		return Appetizer;
	}
	public void setAppetizer(String appetizer) {
		Appetizer = appetizer;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getRepeatCreditCardNumber() {
		return repeatCreditCardNumber;
	}
	public void setRepeatCreditCardNumber(String repeatCreditCardNumber) {
		this.repeatCreditCardNumber = repeatCreditCardNumber;
	}
	
	
	
	
	
	
	

}











