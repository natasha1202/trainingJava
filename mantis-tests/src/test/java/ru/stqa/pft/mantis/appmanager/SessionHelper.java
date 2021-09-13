package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app){
        super(app);
    }

    public void login(String username, String password) {
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void logout() {
        wd.findElement(By.id("logout-link")).click();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

}
