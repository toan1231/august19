package ui_automation.step_definitions;


import io.cucumber.java.en.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ui_automation.pages.MealBExpensePage;
import ui_automation.pages.MealBLoginPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;
import ui_automation.utilities.WaitHelper;

import javax.security.auth.login.Configuration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MealBExpenseStep {

    MealBLoginPage mealBLoginPage = new MealBLoginPage();
    MealBExpensePage mealBExpensePage = new MealBExpensePage();


    String expenseName = "Tacos";
    double amount = 40.72;
    String businessRelationshipOption = "Vendor";
    String businessPurpose = "Team Meeting";
    String companyName = "Yoll";
    String projectName="SDET";

    @Given("user navigates to MealB login page")
    public void user_navigates_to_MealB_login_page() {
        Driver.getInstance().getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "mealb.url")+"/Account/Login");
    }

    @Then("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() throws InterruptedException {
        String username = ConfigurationReader.getProperty("ui-config.properties", "mealb.username");
        String password = ConfigurationReader.getProperty("ui-config.properties", "mealb.password");
        mealBLoginPage.login(username, password);

    }
    @Then("user clicks on Expense Tab")
    public void userClicksOnExpenseTab() {
        mealBExpensePage.expenseTab.click();
    }

    @Then("user clicks on Add Expense button")
    public void user_clicks_on_Add_Expense_button() {
        mealBExpensePage.addExpenseButton.click();
    }

    @Then("user selects Meal and Entertainment option")
    public void user_selects_Meal_and_Entertainment_option() {
        mealBExpensePage.addMealAndEntOption.click();
    }

    @Then("user fills out all fields on Meal and Entertainment modal window")
    public void user_fills_out_all_fields_on_Meal_and_Entertainment_modal_window() throws InterruptedException, IOException {
      String file= System.getProperty("user.dir")+"/src/test/resources/testData";
      //I don't have exel account so it won't work

    FileInputStream fis=new FileInputStream(file);
    XSSFWorkbook workbook=new XSSFWorkbook(fis);
    XSSFSheet sheet=workbook.getSheetAt(0);
//     XSSFRow row=sheet.getRow(0);
//           XSSFCell cell= row.getCell(0);
//           String cellValue=cell.getStringCellValue();
        String expenseName=sheet.getRow(1).getCell(3).getStringCellValue();



    mealBExpensePage.addMealAndEntExpense(amount, expenseName, businessRelationshipOption,businessPurpose ,
                companyName, projectName);
    }

    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {
        mealBExpensePage.modalSaveButton.click();
    }

    @Then("user verifies that newly created expense shows up on expense table")
    public void user_verifies_that_newly_created_expense_shows_up_on_expense_table() {
        String actualExpenseName = mealBExpensePage.getExpenseTableData(1, 2);
        Assert.assertEquals("The expense names do not match", expenseName, actualExpenseName);
    }


}