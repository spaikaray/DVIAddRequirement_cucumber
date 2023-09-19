package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.AddAddress;
import Pages.AddRequirements;
import Pages.ConnectDB2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Add_Req_Steps {
	WebDriver driver= Hooks.driver;
	AddRequirements addReqPage= new AddRequirements(driver);
	AddAddress addAddress= new AddAddress(driver);
	ConnectDB2 connectDB= new ConnectDB2(driver);
	
	@Given("user is on the Add Requirement section")
	public void user_is_on_the_add_requirement_section() {
		String heading_text= addReqPage.checkHeading();
		Assert.assertTrue(heading_text.contains("Add Requirement"));
		System.out.println("Heading is:"+heading_text);
	 
	}

	@When("user enters Title")
	public void user_enters_title() {
		try {
			addReqPage.addTitle("Cloud Developer");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("enters Search for Client")
	public void enters_search_for_client() {
		
		try {
			addReqPage.addClient("Agile Tech");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}

	@And("selects options from Employment Type dropdown")
	public void selects_options_from_employment_type_dropdown() {
		
		try {
			addReqPage.selectEmpType();
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@And("selects an option from Workplace dropdown")
	public void selects_an_option_from_workplace_dropdown() {
		
		try {
			addReqPage.selectWorkPlace();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("adds job description")
	public void adds_job_description() {
		
		try {
			addReqPage.addJobDescription("We are in need of a Senior Project Manager for the Lifecycle CRM project.\r\n"
					
					+ "This is a remote position. ");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("selects a value from the Open Positions dropdown")
	public void selects_a_value_from_the_open_positions_dropdown() {
		try {
		addReqPage.selectOpenPositions();
		Thread.sleep(5000);
	  
	}catch (InterruptedException e) {
	
			e.printStackTrace();
		}
	}

	@And("adds Conract Duration")
	public void adds_conract_duration() {
		
		try {
			addReqPage.selectContractDuration("12 months");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("Status is Open by default and disabled")
	public void status_is_open_by_default_and_disabled() {
		addReqPage.Status();
		
	}

	@And("adds skills required")
	public void adds_skills_required() {
		try {
			String selectSkill1 = "HTML";
			addReqPage.addSkills(selectSkill1);
			WebElement matchingSkill1 = driver.findElement(By.xpath("//*[@id=\"skill-input-item-0\"]"));
			String availableSkill1 = matchingSkill1.getText();

			if (availableSkill1.contains(selectSkill1)) {
				matchingSkill1.click();

			} else {

				System.out.println("skill not available");
			}
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		try {
			String selectSkill2 = "sql";
			addReqPage.addSkills(selectSkill2);
			Thread.sleep(3000);
			WebElement matchingSkill2 = driver.findElement(By.xpath("//*[@id=\"skill-input-item-0\"]"));
			matchingSkill2.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	
		}
	

	@Then("user is able to enter the values for these fields")
	public void user_is_able_to_enter_the_values_for_these_fields() {
	   System.out.println("user entered all field values");
	}
	
	@Given("user partially enters a valid address in the Search for Address field")
	public void user_partially_enters_a_valid_address_in_the_search_for_address_field() {
	   System.out.println("user partially enters address");
	}

	@And("search field displays auto suggesstion of matching address")
	public void search_field_displays_auto_suggesstion_of_matching_address() {
	   System.out.println("search field displays auto suggesstion of matching address");
	}

	@And("user selects a matching address")
	public void user_selects_a_matching_address() {
		try {
			String partialAaddress = "4500 Brooktree Road";
			addAddress.searchAddress(partialAaddress);
			Thread.sleep(4000);
			WebElement matchingAddress = driver.findElement(By.id("Address-input-item-0"));
			String addressText = matchingAddress.getText();

			if (addressText.contains(partialAaddress)) {
				matchingAddress.click();
				System.out.println("matching address is clicked");
			} else {
				System.out.println("no matching address available");
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@And("all address fields are filled automatically")
	public void all_address_fields_are_filled_automatically() {
		
		try {
			addAddress.address1Text();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@When("user clicks on the Create Requirement button")
	public void user_clicks_on_the_create_requirement_button() {
		
		try {
			addAddress.clickCreateButton();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("new requirement is created")
	public void new_requirement_is_created() {
	   System.out.println("new req is created");
	}

	@And("Requirement saved messages is displayed")
	public void requirement_saved_messages_is_displayed() {
		
		try {
			addAddress.savedMessage();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Given("user created a new requirement sucessfully")
	public void user_created_a_new_requirement_sucessfully() {
	    System.out.println("new req is created successfully");
	}

	@When("user connects to the DB table")
	public void user_connects_to_the_db_table() {
		 System.out.println("user is attempting to connect to DB in next step");
	}

	@When("executes the select statement")
	public void executes_the_select_statement() {
		
		System.out.println("user will execute the statement in next step");
	}

	@Then("new record should be available in the DB table")
	public void new_record_should_be_available_in_the_db_table() {
		try {
			connectDB.verifyDB();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("new req is created successfully");
	}

}
