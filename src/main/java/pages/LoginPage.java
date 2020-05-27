package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static config.ApplicationConfig.getDriver;

public class LoginPage {

    private static final String EMAIL_ID = "emailAddress";
    private static final String PASSWORD_ID = "mat-input-1";
    private static final String LOGIN_BUTTON_ID = "logButton";

    public WebElement getEmailField() {return getDriver().findElement(By.id(EMAIL_ID));
    }
    public WebElement getPasswordField(){
        return getDriver().findElement(By.id(PASSWORD_ID));
    }
    public WebElement getLoginButton(){ return getDriver().findElement(By.id(LOGIN_BUTTON_ID));
    }


    public void login(String email,String password){
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}
