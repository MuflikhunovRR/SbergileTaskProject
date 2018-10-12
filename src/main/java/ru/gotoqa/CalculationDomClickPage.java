package ru.gotoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author Muflikhunov Roman
 */
public class CalculationDomClickPage extends PageObject{

    @FindBy(xpath = "//div[text() = 'Цель кредита']/..//span[@class = 'dcCalc_textfield__suffix']")
    WebElement creditProposeList;

    @FindBy(xpath = "//div[@class='dcCalc_selectfield__option' and text()='Покупка квартиры в новостройке']")
    WebElement creditProposeNewFlat;

    @FindBy(id = "estateCost")
    WebElement propertyCostField;

    @FindBy(id = "initialFee")
    WebElement firstPayField;

    @FindBy(id = "creditTerm")
    WebElement creditTermField;

    @FindBy(xpath = "//input[@data-test-id = 'paidToCard']/..")
    WebElement sberSalaryCardButton;



    public boolean isChecked(WebElement element){
        return element.getAttribute("class").contains("dcCalc_switch_checked");
    }

    public void setCheckedFlag(WebElement element, boolean flag) {
        if (flag == isChecked(element)) {
            return;
        }
        element.click();
    }


    public void setCreditProposeNewFlatList() {
        creditProposeList.click();
        creditProposeNewFlat.click();
    }

    public void setPropertyCost(String propCost) {
        propertyCostField.click();
        propertyCostField.clear();
        propertyCostField.sendKeys(propCost);
    }

    public void setFirstPay(String fPay) {
        firstPayField.click();
        firstPayField.clear();
        firstPayField.sendKeys(fPay);
    }

    public void setCreditTermField(String crTerm) {
        creditTermField.click();
        creditTermField.clear();
        creditTermField.sendKeys(crTerm);
    }

    public void clickSberSalaryCardButton(boolean flag) {
        setCheckedFlag(sberSalaryCardButton, flag);
    }



    public CalculationDomClickPage(WebDriver driver) {
        super(driver);
    }
}
