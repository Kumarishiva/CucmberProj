package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {

	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Given("^open_any_Browser$")
	public void open_any_Browser() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
	}
	
	@And("^Navigate_to_Login_page$")
	public void Navigate_to_Login_page() throws InterruptedException {
		
		
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		Thread.sleep(3000);
	}
	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void User_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password){
			
		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);			
		
	}
	
	@And("^User click on Login button$")
	public void  User_clicks_on_Login_button(){
		
		loginPage.loginButton().click();
		
	}
	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login() {
		
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
	}
}
