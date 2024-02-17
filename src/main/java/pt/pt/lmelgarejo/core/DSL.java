package pt.pt.lmelgarejo.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static pt.pt.lmelgarejo.core.DriverFactory.getDriver;

public class DSL {

    public void acceptCookies() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("cmm-cookie-banner.hydrated")));
        WebElement root = getDriver().findElement(By.cssSelector("cmm-cookie-banner.hydrated"));

        SearchContext shadowRoot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
        Thread.sleep(5000);
        shadowRoot1.findElement(By.cssSelector("wb7-button.button.button--accept-all.wb-button.hydrated")).click();
    }

    public void selectYourState(){
        WebElement yourState = getDriver().findElement(By.xpath("//label[.='* Your state']/..//select"));
        Select comboYourState = new Select(yourState);
        comboYourState.selectByVisibleText("New South Wales");
    }

    public void insertYourPostalCode(){
        getDriver().findElement(By.xpath("//input[@aria-labelledby='postal-code-hint']")).sendKeys("2007");
    }

    public void selectYourPurpose(){
        getDriver().findElement(By.xpath("//span[.='Private']//..//div[@class='wb-radio-control__indicator']")).click();
    }

    public void confirmYourLocation() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//span[.='Continue']/..")).click();
    }

    public void clickSearchOptions() throws InterruptedException {
        Thread.sleep(5000);
        getDriver().findElement(By.cssSelector("svg.show")).click();
    }

    public void selectPreOwner(){
        getDriver().findElement(By.xpath("//span[.=' Pre-Owned']")).click();
    }

    public void selectColoursOption() throws InterruptedException {
        Thread.sleep(10000);
        getDriver().findElement(By.xpath("//p[.='Colour']")).click();
    }

    public void sortResultAsPriceDescendending(){
        List<WebElement> sorting = getDriver().findElements(By.cssSelector("wb-select.hydrated select"));
        Select comboSorting = new Select(sorting.get(1));
        comboSorting.selectByVisibleText(" Price (descending) ");
    }

    public void selectExpensiveCar() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
//        WebElement expensiveCar = getDriver().findElement(By.cssSelector("div.dcp-cars-srp-results__tile:nth-child(1)"));
        Thread.sleep(15000);
//        wait.until(ExpectedConditions.visibilityOf(expensiveCar));
//        expensiveCar.click();
        getDriver().findElement(By.cssSelector("div.dcp-cars-srp-results__tile:nth-child(1)")).click();
    }

    public void collectCarData() throws InterruptedException {
        Thread.sleep(5000);
        WebElement vin = getDriver().findElement(By.xpath("//span[.='VIN ']/following-sibling::span"));
        WebElement modelYear = getDriver().findElement(By.xpath("//span[.='Model Year ']/following-sibling::span"));
        System.out.println(vin.getText());
        System.out.println(modelYear.getText());
    }

    public void confirmEnquire(){
        getDriver().findElement(By.xpath("//button[.=' Enquire Now ']")).click();
    }

    public void fillForm() throws InterruptedException {
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//label[.=' First Name ']/following-sibling::input")).sendKeys("John");
        getDriver().findElement(By.xpath("//label[.=' Last Name ']/following-sibling::input")).sendKeys("Doe");
        getDriver().findElement(By.xpath("//label[.=' E-Mail ']/following-sibling::input")).sendKeys("john.doe.com");
        getDriver().findElement(By.xpath("//label[.=' Phone ']/following-sibling::input")).sendKeys("0441912267");
        getDriver().findElement(By.xpath("//label[.=' Postal Code ']/following-sibling::input")).sendKeys("2007");
        getDriver().findElement(By.xpath("//label[.='Comments (optional)']/following-sibling::textarea")).sendKeys("Best car");
        Thread.sleep(5000);
        getDriver().findElement(By.cssSelector("div:nth-child(8) > div > div > wb-checkbox-control > label > wb-icon")).click();
        getDriver().findElement(By.xpath("//span[.='Email']/following-sibling::wb-icon")).click();
    }

    public void confirmFormOptions(){
        getDriver().findElement(By.xpath("//button[.=' Proceed ']")).click();
    }

    public String getInvalidadEmailErrorMessage(){
        return getDriver().findElement(By.xpath("//wb-control-error[.=' Please enter a valid email address using a minimum of six characters. ']")).getText();
    }

    public String getSubmitFormErrorMessage(){
        return getDriver().findElement(By.cssSelector("p[class='dcp-error-message__error-hint']")).getText();
    }
}
