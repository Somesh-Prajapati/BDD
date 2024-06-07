package pageObjects;

import enums.LandingPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusableComponents.SeleniumHelper;

public class LandingPageObjects extends SeleniumHelper {
    WebDriver driver;

    public LandingPageObjects(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private static final By lblBooks = By.xpath("//ul[@class='top-menu']//a[contains(@href,'/books')]");
    private static final By lblComputers = By.xpath("//ul[@class='top-menu']//a[contains(@href,'computers')]");
    private static final By lblElectronics = By.xpath("//ul[@class='top-menu']//a[contains(@href,'electronics')]");
    private static final By lblApparelShoes = By.xpath("//ul[@class='top-menu']//a[contains(@href,'apparel')]");
    private static final By lblDigitalDownloads = By.xpath("//ul[@class='top-menu']//a[contains(@href,'digital')]");
    private static final By lblJewelry = By.xpath("//ul[@class='top-menu']//a[contains(@href,'jewelry')]");
    private static final By lblGiftCards = By.xpath("//ul[@class='top-menu']//a[contains(@href,'gift')]");


    public void verifyLabelsVisibility(){
        verifyText(lblBooks, LandingPageConstants.BOOKS_LABEL);
        verifyText(lblComputers, LandingPageConstants.COMPUTERS_LABEL);
        verifyText(lblElectronics, LandingPageConstants.ELECTRONICS_LABEL);
        verifyText(lblApparelShoes, LandingPageConstants.APPAREL_SHOES_LABEL);
        verifyText(lblDigitalDownloads, LandingPageConstants.DIGITAL_DOWNLOADS_LABEL);
        verifyText(lblJewelry, LandingPageConstants.JEWELRY_LABEL);
        verifyText(lblGiftCards, LandingPageConstants.GIFT_CARDS_LABEL);
    }
}
