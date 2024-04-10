package flipkartlogin;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FALoginTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("iphone 15");
		
		searchBox.submit();
		
		String mainPage = driver.getWindowHandle();
		System.out.println("Main page="+ mainPage);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[5]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		
		Set<String> allPages = driver.getWindowHandles();
        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
			}
		}
        System.out.println(driver.getCurrentUrl());
	}

}
