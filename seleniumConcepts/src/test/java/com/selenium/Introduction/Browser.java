package com.selenium.Introduction;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.navigate().to("https://in.search.yahoo.com/?fr2=inr");
		String originalWindow = driver.getWindowHandle();
		
		driver.get("https://www.google.com");     
		
		driver.navigate().to("https://www.selenium.dev");   //To open the google in browser
		//Sample navigation methods(back,forward,refresh,new window/tab etc...)
		System.out.println(driver.getCurrentUrl());         //To get the current URL in browser
		System.out.println(driver.getTitle());              //To get the Title of that URL
		driver.navigate().back();                           //Go to back page
		Thread.sleep(3000);
		driver.navigate().forward();                        //Go to forward page
		Thread.sleep(3000);
		driver.navigate().refresh();                        //Make refresh
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);  //create new TAB and switch to that
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.WINDOW);     //create new WINDOW and switch to that
		Thread.sleep(4000);
		
		//Frames
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Action")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		//Window size
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		System.out.println("Width and height od the Screen is: "+width+"\n"+height);
		//Or
		Dimension size = driver.manage().window().getSize();
		double width1 = size.getWidth();
		double height1 = size.getHeight();
		System.out.println("Width and height od the Screen is: "+width1+"\n"+height1);
		driver.manage().window().setSize(new Dimension(1200, 650));
		
		driver.switchTo().window(originalWindow);
		Thread.sleep(5000);
		//Window Position
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println("Position of the Screen is: "+x+" and "+y);
		driver.manage().window().setPosition(new Point(70,70));
		Thread.sleep(3000);
		
		//Maximize,Minimize,FullScreen
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		
		//ScreenShots
		File scrnfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //whole screen
		FileUtils.copyFile(scrnfile, new File("./image.png"));
		driver.navigate().to("https://www.google.com");
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File scrnfile2 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnfile2, new File("./image2.png"));
		
		//JavaScript 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement button = driver.findElement(By.cssSelector(".RNmpXc"));
		String text = (String)js.executeScript("return arguments[0].innerText", button);
		System.out.println(text);
		js.executeScript("arguments[0].click();", button);
		
		js.executeScript("console.log('...Teja is controlling this browser...')");
		
		//For close the Edge browser
		//driver.close();   //Closes the current window
		Thread.sleep(2000);
		//driver.quit();

	}

}
