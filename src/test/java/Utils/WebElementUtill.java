package Utils;

import jdk.nashorn.internal.ir.ContinueNode;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;
//import ru.yandex.qatools.allure.annotations.Attachment;

public class WebElementUtill {
    //public static WebDriver driver = DriverUtil.startCromeDriver();
    public static WebElement element;
/*
    @Attachment(value = "ScreenShot", type = "image/png")
    public static byte[] takeScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
*/

/*
//метод для имитирования ввода текста, на входе By локатор элемента, текст для ввода
//ожидание в течение seconds секунд
public static void safeSendKey(WebDriver driver, By locator, String text, int seconds) {
    WebElement webElement;
    for (int i = 0;; i++) {
        try {
//                System.out.println(locator.toString() + " try");
            webElement = (new WebDriverWait(driver, 1, 1000))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            webElement.clear();
            webElement.sendKeys(text);

//                System.out.println(locator.toString() + " success");
        } catch (UnhandledAlertException e) {
            takeDialogWindowError(driver);
            handleAnyDialogWindow(driver);
            takeScreenShot(driver);
            throw e;
        } catch (Exception e) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
            }
            if (i == seconds) {
                takeScreenShot(driver);
                log.error("Тайм-аут элемента " + getNameLocator(locator.toString().split(" ", 2)[1]));
                takeError("Тайм-аут элемента " + getNameLocator(locator.toString().split(" ", 2)[1]));
                fail("Timeout " + locator.toString());
            }
            continue;
        }
        break;
    }
}*/
    public static  WebElement sendKeys(WebDriver driver,By locator, String text) {
        WebElement element=null;
        try {
            element =  (new WebDriverWait(driver, 3, 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            element.clear();
            element.sendKeys(text);
        }
        catch (Exception e) {
            System.out.println("Wrong locator" + locator);
        }
        return element;
    }

    /*
    //метод для имитирования клика по элементу страницы, на входе By локатор этого элемента,
    //ожидание в течение seconds секунд
    public static void safeClick(WebDriver driver, By locator, int seconds) {
        WebElement webElement;
        for (int i = 0;; i++) {
            try {
//                System.out.println(locator.toString() + " try");
                webElement = (new WebDriverWait(driver, 1, 1000))
                        .until(ExpectedConditions.elementToBeClickable(locator));
                webElement.click();
//                System.out.println(locator.toString() + " success");
            } catch (UnhandledAlertException e) {
                takeDialogWindowError(driver);
                handleAnyDialogWindow(driver);
                takeScreenShot(driver);
                throw e;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
                if (i == seconds) {
                    takeScreenShot(driver);
                    log.error("Тайм-аут элемента " + getNameLocator(locator.toString().split(" ", 2)[1]));
                    takeError("Тайм-аут элемента " + getNameLocator(locator.toString().split(" ", 2)[1]));
                    fail("Timeout " + locator.toString());
                }
                continue;
            }
            break;
        }
    }
    */
    public static  WebElement ClickElement(WebDriver driver,By locator) {
        WebElement element=null;
        try {
            element =  (new WebDriverWait(driver, 3, 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
        catch (Exception e) {
            System.out.println("Wrong locator" + locator);
        }
        return element;
    }
/*

    //метод для имитирования клика по значению из выпадающего списка
    //ожидание в течение 5 секунд
    public static void safeClickToDropDownListElement(WebDriver driver, String elementText) {
        By locator = By.xpath("//li/a[.=\"" + elementText + "\"]");
        safeClick(driver, locator, 5);
    }
*/

    public static  void selectElement(WebDriver driver,String text) {
        WebElement element=null;
        try {
            element =  (new WebDriverWait(driver, 3, 1000))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//select/option[.='" + text + "']")));
            element.click();
        }
        catch (Exception e)
        {
            System.out.println("Wrong locator" + text);
        }
    }

    public static  void selectElement(WebDriver driver,By locator, String text) {
        try {
            WebElement elementCopy = (new WebDriverWait(driver, 3, 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            elementCopy.click();
            Thread.sleep(2000);
            WebElement element = (new WebDriverWait(driver, 3, 1000))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(locator+"/option[.='" + text + "']")));
            element.click();

        }
        catch (NullPointerException ex){
            System.out.println("Не нашел локатор" + locator + "/option[.='" + text + "']");
        }
        catch (Exception e)
        {
            System.out.println("Другая ошибка");
            e.printStackTrace();
        }
    }

    public static  void intervalFilmsRating(WebDriver driver,String MaxMin , String Year) {
        try {
            element =  (new WebDriverWait(driver, 3, 1000))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@name,'" + MaxMin + "')]/option[.='" + Year + "']")));
            element.click();
        }
        catch (Exception e)
        {
            System.out.println("Не нашел локатор");
        }
    }

    public static  void SelectFromList(WebDriver driver,String NameList,String Parameter) {
    try {
        element =  (new WebDriverWait(driver, 3, 1000))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id= '" + NameList + "']//input[@data-name = '" + Parameter + "']")));
        element.click();
    }
    catch (Exception e){
        System.out.println("Wrong locator");
    }
    }
    //метод для получения текста из элемента с локатором locator, ожидает seconds секунд
    public static String getText(WebDriver driver, By locator) {
        try {
            element = (new WebDriverWait(driver, 3, 1000))
                        .until(ExpectedConditions.elementToBeClickable(locator));
            String value1 = element.getText();
                //value1 = webElement.getAttribute("value");
             return value1;
        }
        catch (Exception e){
            System.out.println("Wrong locator");
        }
        return " ";
    }
}
