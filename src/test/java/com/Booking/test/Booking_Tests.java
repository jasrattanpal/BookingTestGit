package com.Booking.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        String dateXpath = "//span[@aria-label='" + sdf.format(today) + "']//span[@aria-hidden='true'][contains(text(),'"+ todayday.format(day) +"')]";
        webDriverManger.getDriver().findElement(By.xpath(dateXpath)).click();


            LocalDate date = LocalDate.now();
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            String returndate = date.format(formatters);

            System.out.println("Todays Date " + returndate );

            date = date.plusDays(14);
            DateTimeFormatter Rdate = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            DateTimeFormatter Rdays = DateTimeFormatter.ofPattern("dd");
            System.out.println(date.format(Rdate));
            System.out.println(date.format(Rdays));

            webDriverManger.getDriver().findElement(By.xpath("//span[@aria-label='"+ date.format(Rdate) +"']//span[@aria-hidden='true'][contains(text(),'"+ date.format(Rdays) +"')]")).click();
            webDriverManger.getDriver().findElement(By.className("xp__button")).click();
            webDriverManger.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            boolean AllInclusive =  webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'All-inclusive')]")).isDisplayed();
            Assert.assertTrue("All-inclusive is not displayed",AllInclusive);
            webDriverManger.getDriver().findElement(By.xpath("//span[contains(text(),'All-inclusive')]")).click();
            System.out.println("All-Inclusive-Dubai");


    }

}






