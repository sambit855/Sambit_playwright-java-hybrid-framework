package Practices;

import com.microsoft.playwright.*;

public class practicetestautomation {

    public static void main(String[] args) {

       Playwright playwright =  Playwright.create();
       Browser browser  = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
       BrowserContext context1 =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
       Page page  = context1.newPage();

//        Test case 1: Positive LogIn test
//        Open page
//        Type username student into Username field
//        Type password Password123 into Password field
//        Push Submit button
//        Verify new page URL contains practicetestautomation.com/logged-in-successfully/
//        Verify new page contains expected text ('Congratulations' or 'successfully logged in')
//        Verify button Log out is displayed on the new page

        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("input#username[name = 'username']").fill("student");
        page.locator("input#password[name='password']").fill("Password123");
        page.locator("button#submit.btn:has-text('submit')").click();
        System.out.println("new page URL : " + page.url());

        boolean NewPageText = page.locator("h1.post-title:has-text('Logged In Successfully')").isVisible();
        System.out.println("new Page is Text is :" + NewPageText);
        if(NewPageText) {
            String ActualText = page.locator("h1.post-title:has-text('Logged In Successfully')").innerText().trim();
            System.out.println("ActualText : " + ActualText);
            if (ActualText.equals("Logged In Successfully")) {
                System.out.println("New page text display as per design ");
            } else {
                System.out.println("New page text is incorrect ");

            }
        }

        boolean logoutButton =  page.locator("a:has-text('Log out')").isVisible();
        System.out.println("Logout button is displayed ? " + logoutButton );

        context1.close();
        playwright.close();


    }
}
