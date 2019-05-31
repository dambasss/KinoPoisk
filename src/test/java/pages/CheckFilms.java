package pages;

import org.openqa.selenium.By;


public class CheckFilms {

//����������� ����
    public static By NumberFilmSearch = By.xpath("//a[@onclick=\"KP.navigator.loadResult()\"]");
    public static By ShowFilmsButton = By.xpath("//input[@onclick=\"KP.navigator.loadResult()\"][@value=\"�������� ������\"]");
//NEXT--------------->>>>>>>
    public static By country = By.xpath("//select[@id = 'country']");
    public static By fromYear = By.xpath("//select[@id = 'from_year']");
    public static By toYear = By.xpath("//select[@id = 'to_year']");
    public static By contentFind = By.xpath("//select[contains(@name,'content_find')]");
    public static By buttonSearch = By.xpath("//form[@id= 'formSearchMain']//input[@value = '�����']");
    public static By selected = By.xpath("//select/option[.='�����']");
}
