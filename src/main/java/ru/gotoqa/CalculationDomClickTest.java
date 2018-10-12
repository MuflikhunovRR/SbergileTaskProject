package ru.gotoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Muflikhunov Roman
 */
public class CalculationDomClickTest extends FunctionalTest {
    private static CalculationDomClickPage domClickPage;

    @DisplayName("Тестовое задание. Проверка рассчета ипотечного кредита.")
    @ParameterizedTest(name = "Run Test#{index} with UserName = [{arguments}]")
    @ValueSource(strings = { "7, 1000000, 4800000"})
    public void test(String year, String fPay, String propCost) {
        driver.get(prop.getProperty("gotoCalcPage"));
        domClickPage = new CalculationDomClickPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Ежемесячный платеж']/../div[@class = 'dcCalc_result-calculation__value']")));
        domClickPage.setCreditProposeNewFlatList();

        //((JavascriptExecutor) driver).executeScript("document.getElementById('creditTerm').setAttribute('value', '7')");
        domClickPage.setCreditTermField(year);
        domClickPage.setFirstPay(fPay);
        domClickPage.setPropertyCost(propCost);
        domClickPage.clickSberSalaryCardButton(false);
        domClickPage.clickSberSalaryCardButton(true);
    }





}
