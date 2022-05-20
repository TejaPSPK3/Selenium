package com.selenium.waits;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class ExplicitWait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driverWE = new ChromeDriver();
		driverWE.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driverWE, Duration.ofSeconds(10));
		driverWE.get("http://automationpractice.com/index.php?id_product=1&controller=product#/color-blue/size-l");
		driverWE.findElement(By.name("Submit")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"))).click();
		//if the element load slow and the wait will perform 10 sec for that elemnt only
		//if the element load fast and the element find within 10 sec then further action perform without any delay
		
		
		//or
		
		
		//	wait.until(d->d.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).isDisplayed());
		
		//or
		
		/*   USER DEFINED CONDITION FOR ISDISPLAY THE ELEMENT
		Function<WebDriver,Boolean> f = new Function<WebDriver,Boolean>(){

			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return input.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).isDisplayed();
			}
			
		};
		
		wait.until(f);
		*/
		
		driverWE.quit();
	}

}
