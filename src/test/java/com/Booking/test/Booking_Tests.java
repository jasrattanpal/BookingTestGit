package com.Booking.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking_Tests {


    private WebDriverManager webDriverManger;

    public Booking_Tests(WebDriverManager webDriverManger) {
        this.webDriverManger = webDriverManger;

    }


    @Given("^The menu is expandale on the booking homepage$")
    public void naviagateToBooking() {

        webDriverManger.start();
        webDriverManger.getDriver().navigate().to("https://www.booking.com");
        webDriverManger.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Click Accept Button$")
    public void AcceptButton() {
        webDriverManger.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
        webDriverManger.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriverManger.quit();

    }

    @Then("Check the logo")
    public void logo() {
        webDriverManger.start();
        webDriverManger.getDriver().navigate().to("https://www.booking.com");
        webDriverManger.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean linkIsDisplayed = webDriverManger.getDriver().findElement(By.className("bui-header__logo")).isDisplayed();
        Assert.assertTrue(" logo was not displayed", linkIsDisplayed);
        webDriverManger.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Then("sign in page")
    public void signinpage() {
        webDriverManger.getDriver().findElement(By.xpath("//a[@class='bui-button bui-button--secondary js-header-login-link']//span[@class='bui-button__text'][contains(text(),'Sign in')]")).click();
    }

    @Then("invalid email address {string}")
    public void invalidemail(String email) {
        webDriverManger.getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'Continue with email')]")).click();
        boolean invalidmessage = webDriverManger.getDriver().findElement(By.id("username-description")).isDisplayed();
        Assert.assertTrue("Please check if the email address you've entered is correct was not displayed", invalidmessage);
        webDriverManger.quit();

    }

    @Then("valid email address {string}")
    public void validemail(String email2) {
        naviagateToBooking();
        webDriverManger.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
        webDriverManger.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        signinpage();
        webDriverManger.getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(email2);
        webDriverManger.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'Continue with email')]")).click();
        webDriverManger.getDriver().findElement(By.cssSelector("#password")).isDisplayed();
    }
        @Then("valid password {string}")
        public void validpassword(String password) {
        webDriverManger.getDriver().findElement(By.cssSelector("#password")).sendKeys(password);
            webDriverManger.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
            boolean SearchBoxIsDissplayed = webDriverManger.getDriver().findElement(By.xpath("//input[@id='ss']")).isDisplayed();
        Assert.assertTrue("Input search box was not displayed",SearchBoxIsDissplayed);

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        Date day = new Date();
        SimpleDateFormat todayday = new SimpleDateFormat("dd");


        webDriverManger.getDriver().findElement(By.xpath("//input[@id='ss']")).sendKeys("Dubai");
        webDriverManger.getDriver().findElement(By.xpath("//div[contains(@class,'xp__dates-inner xp__dates__checkin')]//div[contains(@class,'xp__group xp__date c2-wrapper-s-hidden')]//div[contains(@class,'sb-date-field b-datepicker')]//div[contains(@class,'-empty sb-date__field-svg_icon')]//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")).click();
      //  String dateXpath = "//span[contains(@aria-label'" + sdf.format(today) + "')]//span[contains(@aria-hidden,'true')][contains(text(),'28')]";
        String dateXpath = "//span[@aria-label='" + sdf.format(today) + "']//span[@aria-hidden='true'][contains(text(),'"+ todayday.format(day) +"')]";
        webDriverManger.getDriver().findElement(By.xpath(dateXpath)).click();
        webDriverManger.getDriver().findElement(By.xpath("//span[@aria-label='9 May 2021']//span[@aria-hidden='true'][contains(text(),'9')]")).click();
        webDriverManger.getDriver().findElement(By.className("xp__button")).click();
        boolean onestar = webDriverManger.getDriver().findElement(By.xpath(" //span[contains(text(),'1 star')]")).isDisplayed();
        Assert.assertTrue("One Star is not displayed",onestar);
        boolean fivestar = webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'5 star')]")).isDisplayed();
        Assert.assertTrue("five Star is not displayed",fivestar);
        webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'5 star')]")).click();
        webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'Superb: 9+')]")).click();
        webDriverManger.getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     //   boolean burj = webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'Burj Al Arab Jumeirah')]")).isDisplayed();
     //   Assert.assertTrue("One Star is not displayed",burj);
     //   webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'Burj Al Arab Jumeirah')]")).click();
     //   webDriverManger.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);








    }

}






