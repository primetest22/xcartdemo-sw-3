package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;
import java.util.List;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyIphone() throws InterruptedException {

        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.linkText("Bestsellers"));
        //verity actual and expected text
        verifyElements("Bestsellers text not matching", "Bestsellers", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Sales')]"));
        mouseHoverAndClick(By.partialLinkText("Name A -"));
        Thread.sleep(1500);
        mouseHover(By.xpath("//img[@alt='iPhone 5S']"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));

        //verify product to cart
        verifyElements("Product not added to the cart",
                "Product has been added to your cart",
                By.xpath("//li[contains(text(),'Product has been added to your cart')]"));

        //close the message (product has been added to your cart)
        clickOnElement(By.xpath("//a[@class='close']"));
        Thread.sleep(1500);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //validate message "Your shopping cart - 1 item"
        verifyElements("(Your shopping cart - 1 item) text not found",
                "Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"));

        //verify subtotal
        verifyElements("Expected subtotal not matching",
                "Subtotal: $299.00", By.xpath("//ul[@class='sums']//li[@class='subtotal']"));
        //verify total
        verifyElements("Expected total not matching",
                "$309.73", By.xpath("//ul[@class='totals']//li[@class='total']//span[@class='surcharge-cell']"));
        //click on checkout
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));

        verifyElements("Expected text not displayed",
                "Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"));
        sendTextToElement(By.id("email"), "abc1@yahoo.com");
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));

        verifyElements("Expected text not displayed",
                "Secure Checkout", By.xpath("//h1[contains(text(),' Secure Checkout')]"));

        //fill all mandatory fields
        sendTextToElement(By.id("shippingaddress-firstname"), "india");
        sendTextToElement(By.id("shippingaddress-lastname"), "amdavad");
        sendTextToElement(By.id("shippingaddress-street"), "guj");
        sendTextToElement(By.id("shippingaddress-custom-state"), "Manchester");
        Thread.sleep(1500);
        //click on chekbox
        clickOnElement(By.id("create_profile"));
        //enter password
        Thread.sleep(3000);
        sendTextToElement(By.id("password"), "password123");
        //click on local shipping button
        WebElement LocalShipping = findElementsOnBrowser(By.id("method128"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", LocalShipping);

        //click on payment method COD
        clickOnElement(By.xpath("//input[@id='pmethod6' and @name='methodId']"));
        //verify total
        verifyElements("Expected total not matching",
                "$311.03", By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"));
        Thread.sleep(3000);
        //click on place order button
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        //verify order text
        verifyElements("Expected text not displayed", "Thank you for your order",
                By.xpath("//h1[@id='page-title']"));

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.linkText("Bestsellers"));
        //verity actual and expected text
        verifyElements("Bestsellers text not matching", "Bestsellers", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Sales')]"));
        mouseHoverAndClick(By.partialLinkText("Name A -"));
        Thread.sleep(3000);
        mouseHover(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));

        //verify product to cart
        verifyElements("Product not added to the cart",
                "Product has been added to your cart",
                By.xpath("//li[contains(text(),'Product has been added to your cart')]"));

        //close the message (product has been added to your cart)
        clickOnElement(By.xpath("//a[@class='close']"));
        Thread.sleep(1500);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //validate message "Your shopping cart - 1 item"
        verifyElements("(Your shopping cart - 1 item) text not found",
                "Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"));

        //click on empty your cart
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //validate alert text
        String alerText = getTextFromAlert();
        Assert.assertEquals("Alet text not matching", "Are you sure you want to clear your cart?", alerText);
        //accept alert
        acceptAlert();

        getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        verifyElements("Message not displayed", "Item(s) deleted from your cart",
                By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        Thread.sleep(3000);
        verifyElements("not matching", "Your cart is empty",
                By.xpath("//h1[contains(text(),'Your cart is empty')]"));

    }

    @After
    public void tearUp() {
        closeBrowser();
    }
}
