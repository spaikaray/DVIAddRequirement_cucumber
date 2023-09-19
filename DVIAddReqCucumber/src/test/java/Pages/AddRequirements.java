package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddRequirements {
	
	WebDriver driver;
	
	By heading_add_req= By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/main/div[1]/div/section/div/h3");
	By title_field= By.id("Title");
	By search_client= By.xpath("/html/body/div/div/div[1]/div[1]/main/div[1]/div/section/div/div[1]/div[2]/div/div/div/input");
	By client_suggestion_text= By.xpath("//*[@id=\"client-input-item-0\"]");
	
	//@FindBy(how=How.XPATH, using="*[@id=\"root\"]/div/div[1]/div[1]/main/div[1]/div/section/div/div[1]/div[3]/div/div[1]/div[1]/div[2]")
	By employment_type= By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/main/div[1]/div/section/div/div[1]/div[3]/div/div[1]/div[1]/div[2]");
	
	By employment_type_FT= By.xpath("//*[@id=\"react-select-2-option-1\"]");
	
	By workplace_dropdown= By.id("workplaceType");
//	@FindBy(how=How.ID, using="workplaceType")
//	WebElement workplace_dropdown;
	
	By workplace_hybrid= By.xpath("//*[@id=\"workplaceType\"]/option[2]");
	
	By job_desc= By.id("JobDescription");
	
	By open_positions= By.name("OpenPositions");
//	@FindBy(how=How.NAME, using="OpenPositions")
//	WebElement open_positions;
	
	By open_position_number_3= By.xpath("//*[@id=\"workplaceType\"]/option[7]");
	
	By contract_duration= By.name("ContractDuration");
	By status= By.id("RequirementStatus");
	By search_skills= By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/main/div[1]/div/section/div/div[4]/div/div/div/div/div/input[1]");
	
	public AddRequirements(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public String checkHeading() {
		return driver.findElement(heading_add_req).getText();
		
	}
	
	public void addTitle(String titleText) {
		driver.findElement(title_field).sendKeys(titleText);
		
	}
	
	public void addClient(String clientName) {
		driver.findElement(search_client).sendKeys(clientName);
		WebElement clientSuggestionTexts= driver.findElement(client_suggestion_text);
		if (clientSuggestionTexts.isDisplayed()) {
			clientSuggestionTexts.click();
		}
		else {
			System.out.println("client name auto fill suggesion is not displayed");
		}
		
		
	}
	
	public void selectEmpType () {

		driver.findElement(employment_type).click();
		driver.findElement(employment_type_FT).click();
		
	}	

	public void selectWorkPlace() {
		driver.findElement(workplace_dropdown).click();
		driver.findElement(workplace_hybrid).click();
	
//		Select workPlaceDropdown= new Select(workplace_dropdown);
//		workPlaceDropdown.selectByVisibleText(workPlace);
		
	}
	
	public void addJobDescription(String jobDesc) {
		driver.findElement(job_desc).sendKeys(jobDesc);
		
	}
	
	public void selectOpenPositions() {
		driver.findElement(open_positions).click();
		try {
			Boolean position_number= driver.findElement(open_position_number_3).isDisplayed();
			if (position_number==true) {
				driver.findElement(open_position_number_3).click();
			Thread.sleep(3000);
		}} 
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
	public void selectContractDuration(String contract) {
		driver.findElement(contract_duration).sendKeys(contract);
		
	}
	
	public boolean Status() {
		
		if (driver.findElement(status).isEnabled()) {
			System.out.println("Status should not be enabled");
		}
		else {
			return driver.findElement(status).getText().equalsIgnoreCase("close");
			
		}
		System.out.println("Status is Open");
		return true;
		
	}
	
	public void addSkills(String skill) {
		driver.findElement(search_skills).sendKeys(skill);
		
	}
	

}
