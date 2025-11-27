package Practices;

import com.microsoft.playwright.*;


public class Negative_username_test {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        Page page = context1.newPage();
       /* Test case 2: Negative username test
        Open page
        Type username incorrectUser into Username field
        Type password Password123 into Password field
        Push Submit button
        Verify error message is displayed
        Verify error message text is Your username is invalid!*/

        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("input#username[name = 'username']").fill("incorrectUser");
        page.locator("input#password[name='password']").fill("Password123");
        page.locator("button#submit.btn:has-text('submit')").click();
        System.out.println("new page URL : " + page.url());

        boolean Error = page.locator("div#error.show:has-text('Your username is invalid!')").isVisible();
        System.out.println("Does error Text displayed ? " + Error);


        if(Error) {
            String ErrorText = page.locator("div#error.show:has-text('Your username is invalid!')").innerText().trim();
            System.out.println("Actual Error Text: " + ErrorText);
            if (ErrorText.equals("Your username is invalid!")) {
                System.out.println(" Error text displayed correctly as per design");
            } else {
                System.out.println("Error not displayed as per design.");
            }
        }


        context1.close();
        playwright.close();

    }
}
