package pt.pt.lmelgarejo.page;

import pt.pt.lmelgarejo.core.BasePage;
import pt.pt.lmelgarejo.core.DSL;

public class ShopAustraliaPage extends BasePage {
    public ShopAustraliaPage() {
        super.dsl = new DSL();
    }

    public void acceptCookies() throws InterruptedException {
        dsl.acceptCookies();
    }

    public void selectYourState(){
        dsl.selectYourState();
    }

    public void insertYourPostalCode(){
        dsl.insertYourPostalCode();
    }

    public void selectYourPurpose(){
        dsl.selectYourPurpose();
    }

    public void confirmYourLocation() throws InterruptedException {
        dsl.confirmYourLocation();
    }

    public void clickSearchOptions() throws InterruptedException {
        dsl.clickSearchOptions();
    }

    public void selectPreOwned(){
        dsl.selectPreOwner();
    }

    public void selectColoursOption() throws InterruptedException {
        dsl.selectColoursOption();
    }

    public void sortResultAsPriceDescendending(){
        dsl.sortResultAsPriceDescendending();
    }

    public void selectExpensiveCar() throws InterruptedException {
        dsl.selectExpensiveCar();
    }

    public void collectCarData() throws InterruptedException {
        dsl.collectCarData();
    }

    public void confirmEnquire(){
        dsl.confirmEnquire();
    }

    public void fillForm() throws InterruptedException {
        dsl.fillForm();
    }

    public void confirmeFormOptions(){
        dsl.confirmFormOptions();
    }

    public String getInvalidadEmailErrorMessage(){
        return dsl.getInvalidadEmailErrorMessage();
    }

    public String getSubmitFormErrorMessage(){
        return dsl.getSubmitFormErrorMessage();
    }
}
