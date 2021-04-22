package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

public class GroupCreationTests {
  private WebDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    wd.get("http://localhost:8090/addressbook/");
    //wd.manage().window().setSize(new Dimension(960, 692));
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  @Test
  public void testGroupCreation() {
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.name("new")).click();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys("test1");
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys("test2");
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("test3");
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("group page")).click();
  }

  public static boolean isAllertPresent(FirefoxDriver wd){
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e){
      return false;
    }
  }
}
