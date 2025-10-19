package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepdef.ui.BaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddToChartPage extends BaseTest {

    WebDriver driver;
    By addToChartButton = By.id("add-to-cart-sauce-labs-backpack");
    By removeFromChartButton = By.id("remove-sauce-labs-backpack");

    public AddToChartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItem(){
        driver.findElement(addToChartButton).click();
    }

    public String validate(){
        return driver.findElement(removeFromChartButton).getText();

    }
    public String validateError(){
        return driver.findElement(removeFromChartButton).getText();

    }
}
