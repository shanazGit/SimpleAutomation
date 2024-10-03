import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageNavigation {
    public static void main (String[]args){
        automationScript();
    }

    private static void automationScript() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.getTitle();
        if(driver.getTitle().equalsIgnoreCase("google")){
            System.out.println("Script worked, page contains the title google");
        }else{
            System.out.println("Something went wrong with the script, google not found");
        }
       driver.navigate().to("https://www.yahoo.com/");
        if(driver.getTitle().equalsIgnoreCase("yahoo")){
            System.out.println("Script worked, yahoo found");
        }
        else{
            System.out.println("Something went wrong with the script, yahoo not found");
        }
        driver.navigate().back();
        if(driver.getTitle().equalsIgnoreCase("google")){
            System.out.println("Script worked, google found on the page");
        }else{
            System.out.println("Something went wrong with the script, google not found");
        }
        driver.quit();
    }
}
