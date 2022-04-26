package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //click on element
        clickOnElement(By.xpath("//ul[@class ='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'Shipping')]"));
        String expectedDisplay = "Shipping";
        String actualDisplay = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //validate text
        Assert.assertEquals("Not Matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //click on element
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'New!')]"));
        String expectedDisplay = "New arrivals";
        String actualDisplay = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //validate text
        Assert.assertEquals("Not Matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        //click on element
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'Coming soon')]"));

        verifyElements("Not Matching", "Coming soon", By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        //click on element
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'Contact us')]"));
        //validate text
        verifyElements("Not Matching", "Contact us", By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'Contact us')]"));

    }


    @After
    public void tearUp() {
        closeBrowser();
    }
}
