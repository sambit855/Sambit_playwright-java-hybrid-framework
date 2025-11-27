package Practices;

import com.microsoft.playwright.*;

public class Negative_password_test {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        Page page = context1.newPage();
       /* Test case 3: Negative password test
        Open page
        Type username student into Username field
        Type password incorrectPassword into Password field
        Push Submit button
        Verify error message is displayed
        Verify error message text is Your password is invalid! */

        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("input#username[name = 'username']").fill("student");
        page.locator("input#password[name='password']").fill("Password13");
        page.locator("button#submit.btn:has-text('submit')").click();
        System.out.println("new page URL : " + page.url());

        boolean ErrorText  = page.locator("div#error.show:has-text('Your password is invalid!')").isVisible();
        System.out.println(" Dose inline error displayed ? " + ErrorText );

        if (ErrorText){
          String  Actual_ErrorText  = page.locator("div#error.show:has-text('Your password is invalid!')").innerText().trim();
          System.out.println(" Actual Error Text : " + Actual_ErrorText);
          if(Actual_ErrorText.equals("Your password is invalid!")) {
              System.out.println(" Error text is displayed correctly as per design ");
          }
          else {
              System.out.println(" Error text not displayed correctly as per design ");
          }
        }

        context1.close();
        playwright.close();


    }
}
