package hotdeals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.xpath("//div[@class='collapse navbar-collapse']//following::ul[2]/li[@class='leaf']/a[@href='sale_products/']/span"));
        //verity actual and expected text
        verifyElements("not matching", "Sale", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClick(By.xpath("//div[@class='sort-box']/ul/li[5]/a[normalize-space()='Name A - Z']"));
        verifyElements("not matching", "Name A - Z", By.xpath("//span[contains(text(),'Name A - Z')]"));
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.xpath("//div[@class='collapse navbar-collapse']//following::ul[2]/li[@class='leaf']/a[@href='sale_products/']/span"));
        //verity actual and expected text
        verifyElements("not matching", "Sale", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClick(By.partialLinkText("Price Low - Hi"));
        verifyElements("not matching", "Price Low - High", By.xpath("//span[contains(text(),'Price Low - High')]"));
    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.xpath("//div[@class='collapse navbar-collapse']//following::ul[2]/li[@class='leaf']/a[@href='sale_products/']/span"));
        //verity actual and expected text
        verifyElements("not matching", "Sale", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClick(By.partialLinkText("Rates"));
        verifyElements("not matching", "Rates", By.xpath("//span[contains(text(),'Rates')]"));
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.linkText("Bestsellers"));
        //verity actual and expected text
        verifyElements("not matching", "Bestsellers", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Sales')]"));
        mouseHoverAndClick(By.partialLinkText("Name Z -"));
        verifyElements("not matching", "Name Z - A", By.xpath("//span[contains(text(),'Name Z - A')]"));
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.linkText("Bestsellers"));
        //verity actual and expected text
        verifyElements("not matching", "Bestsellers", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Sales')]"));
        mouseHoverAndClick(By.partialLinkText("Price High - L"));
        verifyElements("not matching", "Price High - Low", By.xpath("//span[contains(text(),'Price High - Low')]"));
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //hover over mouse on element
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/span[normalize-space()='Hot deals']"));
        //hover over and click on element
        mouseHoverAndClick(By.linkText("Bestsellers"));
        //verity actual and expected text
        verifyElements("not matching", "Bestsellers", By.id("page-title"));

        mouseHover(By.xpath("//span[contains(text(),'Sales')]"));
        mouseHoverAndClick(By.partialLinkText("Rates"));
        verifyElements("not matching", "Rates", By.xpath("//span[contains(text(),'Rates')]"));
    }


    @After
    public void tearUp() {
        closeBrowser();
    }


}
