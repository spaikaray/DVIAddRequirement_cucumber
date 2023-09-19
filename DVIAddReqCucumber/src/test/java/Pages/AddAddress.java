package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAddress {
	
	WebDriver driver;
	
	By search_address= By.xpath("/html/body/div/div/div[1]/div[1]/main/div[2]/div/section/div/div[1]/div/div/div/input");
	By address_1= By.name("AddressLine1");
	By address_2= By.name("AddressLine2");
	By City= By.id("inputCity");
	By State= By.id("inputState");
	By Zip= By.id("inputZip");
	By create_req_btn= By.xpath("/html/body/div/div/div[1]/div[1]/main/div[3]/button");
	
	
	public AddAddress(WebDriver driver) {
		this.driver= driver;
	}
	
	public void searchAddress(String address) {
		driver.findElement(search_address).sendKeys(address);
			
	}
	
	public String address1Text() {
		String address1FieldText= driver.findElement(address_1).getAttribute("value");
		System.out.println("address 1 text is:"+address1FieldText); 
		return address1FieldText;
	}
	
	public void clickCreateButton() {
		driver.findElement(create_req_btn).click();
		
	}
	
	public boolean savedMessage() {
		String message= "" ;
		return message.contains("Requirement Saved");
	}
	
	

}
