import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login {

    @Test
    public void navigate() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

            String title = driver.getTitle();
            String expectedTitle = "Welcome to Duotify!";
        Assert.assertEquals(title,expectedTitle);

            WebElement signUp = driver.findElement(By.id("hideLogin"));
            signUp.click();


        Faker faker = new Faker();
        Thread.sleep(3000);
        String fn = faker.address().firstName();
        String ln = faker.address().lastName();
        String userName = faker.name().username();
        String firstNameAndLastName = fn+" "+ln;




        WebElement username = driver.findElement(By.name("username"));
        username.click();
        username.sendKeys(userName);

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.click();
        firstName.sendKeys(fn);

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.click();
        lastName.sendKeys(ln);


        WebElement email = driver.findElement(By.name("email"));
        email.click();
        String emailGenerate = faker.internet().emailAddress();
        email.sendKeys(emailGenerate);

        WebElement repeatEmail = driver.findElement(By.name("email2"));
        repeatEmail.click();
        repeatEmail.sendKeys(emailGenerate);

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        String passwordCreate = faker.internet().password();
        password.sendKeys(passwordCreate);

        WebElement passwordRepeat = driver.findElement(By.name("password2"));
        passwordRepeat.click();
        passwordRepeat.sendKeys(passwordCreate);

        WebElement regButton = driver.findElement(By.name("registerButton"));
        regButton.click();


            String url = driver.getCurrentUrl();
            String expectedURL = "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
            Assert.assertEquals(url, expectedURL);

            WebElement name = driver.findElement(By.id("nameFirstAndLast"));
            String nameOnTheLeft = name.getText();
            Assert.assertEquals(nameOnTheLeft, firstNameAndLastName);

            name.click();
            Thread.sleep(500);
            String pageSource = driver.getPageSource();
            Assert.assertTrue(pageSource.contains(firstNameAndLastName));

            WebElement logout = driver.findElement(By.id("rafael"));
            logout.click();

            Thread.sleep(2000);
            String url2 = driver.getCurrentUrl();
            String expectedURL2 = "http://duotify.us-east-2.elasticbeanstalk.com/register.php";
            Assert.assertEquals(url2, expectedURL2);


        WebElement username2 = driver.findElement(By.name("loginUsername"));
        username2.click();
        username2.sendKeys(userName);
        WebElement password2 = driver.findElement(By.name("loginPassword"));
        password2.click();
        password2.sendKeys(passwordCreate);

        WebElement login = driver.findElement(By.name("loginButton"));
        login.click();

        Thread.sleep(1000);
        String pageSource2 = driver.getPageSource();
        String text = "You Might Also Like";
        Assert.assertTrue(pageSource2.contains(text));


        driver.findElement(By.id("nameFirstAndLast")).click();
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);
        Assert.assertEquals(url2, expectedURL2);





    }



}
