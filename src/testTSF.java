import com.sun.source.doctree.SeeTree;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.*;



public class testTSF {

    public static  void log(String s){


    }
    public static void main(String[] args) throws InterruptedException, IOException {

        //code to write test report
          File report = new File("Report.txt");
          report.createNewFile();
          FileWriter fw = new FileWriter("Report.txt");


        //give path to geckodriver for firefox
        System.setProperty("webdriver.firefox.driver", "/home/pratik/Downloads/geckodriver");
        //create FireFox driver
        WebDriver driver = new FirefoxDriver();
        //open TSF website in firefox

        fw.write("Opening https://www.thesparksfoundationsingapore.org\n");
        driver.navigate().to("https://www.thesparksfoundationsingapore.org/");

        fw.write("Opened Sucessfully\n");


        //code to check title of page
        fw.write("Checking for Title\n");
        String title = driver.getTitle();
        if (title.equalsIgnoreCase("The Sparks Foundation | Home")){
            fw.write("Title Matches\n");
        System.out.println("Title Matches");}
        else {
            fw.write("Title Does not  Match\n");
            System.out.println("Title not matching");
        }
        Thread.sleep(3000);


        //code to check if logo loads properly
        fw.write("Checking for logo...\n");

        boolean logo = driver.findElement(By.cssSelector("a.col-md-6 > img:nth-child(1)")).isDisplayed();
        if (logo){
            System.out.println("Logo is displayed");
        fw.write("Logo is displayed\n");}

        else {
            System.out.println("Logo is not displayed");
            fw.write("Logo is not Displayed\n");
        }


        //to check if navigation bar loads
        fw.write("Checking navigation bar\n");

        boolean navbar = driver.findElement(By.cssSelector(".navbar")).isDisplayed();
        if (navbar){
            System.out.println("Navigation bar is loaded Successfully");
        fw.write("Navigation bar is loaded Successfully\n");}

        else {
            System.out.println("Navigation bar not loaded");
        fw.write("Navigation bar not loaded\n");}


    //check spelling of about us
        fw.write("Spell check\n");

    String tag = driver.findElement(By.cssSelector("li.dropdown:nth-child(1) > a:nth-child(1)")).getText();
        if (tag.equals("About Us")){
            System.out.println("Spelling for About us tag is correct");
            fw.write("spelling for About us tag is correct\n");
        }



        else {
            System.out.println("please check spelling for about us tag");
            fw.write("please check spelling for about us tag\n");
        }

        //click on about us
        WebElement about = driver.findElement(By.cssSelector("li.dropdown:nth-child(1) > a:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(about).click().perform();
        fw.write("Opened Drop down from About Us\n");

        Thread.sleep(2000);
        //go to executive team from drop down menu
        WebElement exec = driver.findElement(By.cssSelector("li.dropdown:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)"));
        action.moveToElement(exec).click().perform();
        fw.write("Clicked on Executive Team\n");

        Thread.sleep(3000);
        fw.write("Page Loaded\n");

        String foundingTeam = driver.findElement(By.cssSelector("html body div.w3l_inner_section.about-w3layouts div.container div.inner_w3l_agile_grids div.blog-w3ls.col-md-9 div.single-middle div.media-body h4")).getText();

        //check for spelling
        if (foundingTeam.equals("Priyesh Kumar")){
            System.out.println("Spelling correct for founding team");
        fw.write("Spelling correct for founding team\n");
        }

        else{
            System.out.println("Please check spelling of founding team");
            fw.write("Please check spelling of founding team\n");
        }

        //go to contact us
        WebElement contact = driver.findElement(By.cssSelector(".nav > li:nth-child(6) > a:nth-child(1)"));
        String con = contact.getText();
        if (con.equals("Contact Us")) {
            System.out.println("Spelling for contact us option is correct");
            fw.write("Spelling for contact us option is correct\n");

        } else{
            System.out.println("Spelling for contact us option is not correct");
        fw.write("Spelling for contact us option is not correct\n");}


        action.moveToElement(contact).click().perform();
        Thread.sleep(1000);
        fw.write("Contact us page loaded \n");

        //scroll down to end
        action.sendKeys(Keys.END).perform();
        Thread.sleep(500);
        fw.write("Checking for LinkedIn link button\n");


        //click on linkedin icon
        WebElement linkedin = driver.findElement(By.cssSelector(".top-header-agile-right > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
        action.moveToElement(linkedin).click().perform();
        Thread.sleep(2000);
        fw.write("Linked in opened..\n");

        driver.quit();
        fw.write("Browser Closed\n");
        fw.write("Test Completed\n");
        fw.close();



    }


    }


