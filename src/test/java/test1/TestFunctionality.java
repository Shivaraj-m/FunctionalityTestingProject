package test1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFunctionality {
	public static void main(String[] args) throws AWTException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.dealsdray.com/");
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='chevron_right']")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		WebElement fileUploadBtn = driver.findElement(By.xpath("//input[@type='file']"));
		File f = new File("./src/main/resources/data/demo-data.xlsx");
		String absPath = f.getAbsolutePath();
		fileUploadBtn.sendKeys(absPath);
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		WebElement tableTag = driver.findElement(By.xpath("//table[@class='MuiTable-root css-9177x2']"));
		TakesScreenshot driver1 = (TakesScreenshot)driver;
		File src = tableTag.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/table.png");
		FileUtils.copyFile(src, dest);
		
	}

}
