package automation_Exericies;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Test_Case_6_Contact_Us_Form {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright =  Playwright.create();
        //Launch browser
        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        Page page =  context.newPage();
        // Navigate to url 'http://automationexercise.com'
        page.navigate("https://automationexercise.com/");
        //Verify that home page is visible successfully
        System.out.println("Home page : " + page.title());

        page.locator("a:has-text(' Contact us')").click();

        // Verify 'GET IN TOUCH' is visible

        boolean touchText =  page.locator("h2:has-text('Get In Touch')").isVisible();
        System.out.println("does Intouch text displayed ? " +  touchText );
        //Enter name, email, subject and message
        page.locator("input.form-control[data-qa='name']").fill("Sambit kumar Mohapatra");
        page.locator("input.form-control[data-qa='email']").fill("Sambit@gmail.com");
        page.locator("input.form-control[data-qa='subject']").fill("Issue with login");
        page.locator("textarea.form-control[data-qa='message']").fill("f you have any suggestion areas or improvements, " +
                "do let us know. We will definitely work on it.");
        //Upload file
        page.setInputFiles("input[name='upload_file']", Paths.get("C:\\Users\\kabit\\Downloads\\UnexpectedError.png"));
        Thread.sleep(1000);
        page.locator("input[type='submit'][data-qa='submit-button']").click();


        context.close();
        playwright.close();


    }
}
