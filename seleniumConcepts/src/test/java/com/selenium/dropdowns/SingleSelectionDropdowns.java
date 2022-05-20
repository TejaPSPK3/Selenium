package com.selenium.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelectionDropdowns {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driverSSD = new ChromeDriver();
		driverSSD.get("https://trytestingthis.netlify.app/");
		Thread.sleep(4000);
		driverSSD.manage().window().maximize();
		WebElement elemOption = driverSSD.findElement(By.id("option"));
		Select selectSSD = new Select(elemOption);
		List<WebElement> allOptions = selectSSD.getOptions();
		for(WebElement allOpt : allOptions)
		{
			System.out.println(allOpt.getText());
		}
		selectSSD.selectByIndex(2);                   //For OPtion 2
		Thread.sleep(3000);
		selectSSD.selectByValue("option 1");          //For Option 1
		Thread.sleep(3000);
		selectSSD.selectByVisibleText("Option");    //For Option 
		Thread.sleep(3000);
		selectSSD.selectByVisibleText("Option 3");    //For Option 3
		Thread.sleep(3000);
		
		WebElement strOption = selectSSD.getFirstSelectedOption();
		System.out.println(strOption.getText());
		driverSSD.quit();
	}

}
