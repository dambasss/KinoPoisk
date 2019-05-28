package pages;

import org.openqa.selenium.By;

public class loginpage {

    public By OtherAcc = By.xpath("//span[@class='passp-account-list__sign-in-button-text']");
    public By login = By.xpath("//input[@id='passp-field-login']");
    public By buttonEnter = By.xpath("//button[contains(@class,'passp-form-button')]");
    public By password = By.xpath("//input[contains(@type,'password')]");

}
