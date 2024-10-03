package TestScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckingAlerts {
    public static void main(String[] args) {
        alertCheck();
    }

    private static void alertCheck() {
        WebDriver driver=new ChromeDriver();
        try{
           driver.get("file:///D:/Beginning-Selenium/docs/lesson_2/checkingAlerts.html");
           //Accepting simple alert
          Alert simpleAlert= driver.switchTo().alert();
          System.out.println("Alert text contains: "+simpleAlert.getText());
          if(simpleAlert.getText().equalsIgnoreCase("Welcome! This is a simple alert. Press 'Accept' to continue")){
              System.out.println("Script worked , it contains the simple alert");
          }else{
              System.out.println("Something went wrong with the script, simplealert not found");
          }
          simpleAlert.accept();
//            // Using the WebDriverWait to wait until the alert is displayed
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
//            wait.until(ExpectedConditions.alertIsPresent());
//            // Once the alert is displayed, switching to that alert and Dismissing it
//            simpleAlert = driver.switchTo().alert();
//            System.out.println("=> An another alert text is : "+simpleAlert.getText());
//            simpleAlert.dismiss();
//          simpleAlert.dismiss();

          //Accepting the confirmAlert
            Alert confirmAlert=driver.switchTo().alert();
            if(confirmAlert.getText().equalsIgnoreCase("This is a confirm alert. Do you want to accept or cancel?")){
                System.out.println("Script worked, expected confirm alert was shown ");
            }
            else{
                System.out.println("something went wrong with the script, expected confirm alert was not shown");
            }
            confirmAlert.accept();
            Alert promptAlert=driver.switchTo().alert();
            promptAlert.sendKeys("java");
            promptAlert.accept();
            if(driver.getTitle().contains("java")){
                System.out.println("script worked, it contains java");
            }
            else {
                System.out.println("Something went wrong, java not found");
            }
        }
        finally{
            driver.quit();
        }
    }
}
