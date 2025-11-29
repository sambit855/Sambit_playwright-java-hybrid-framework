package automation_Exericies;

import com.microsoft.playwright.*;

public class Test_Case_2_Login_User_with_Incorrect_email_and_password {

    public static void main(String[] args) {

       Playwright playwright =  Playwright.create();
        //Launch browser
      Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
      BrowserContext context =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
      Page page =  context.newPage();
      // Navigate to url 'http://automationexercise.com'
      page.navigate("https://automationexercise.com/");
        //Verify that home page is visible successfully
        System.out.println("Home page : " + page.title());
        // Click on 'Signup / Login' button
        page.locator("a:has-text(' Signup / Login')").click();

       boolean loginText =  page.locator("h2:has-text('Login to your account')").isVisible();
        System.out.println(" Dose login Text displayed ? " + loginText );
        //Enter correct email address and password
        page.locator("input[data-qa= 'login-email']").fill("sambitt@gmail.com");
        page.locator("input[data-qa='login-password']").fill("sambit@123");
        // Click 'login' button
        page.locator("button[data-qa='login-button']:has-text('Login')").click();

        //Verify error 'Your email or password is incorrect!' is visible

       boolean InlineError = page.locator("p:has-text('Your email or password is incorrect!')").isVisible();
        System.out.println("inlineError text is visible ? " +InlineError);

        if(InlineError){
            String Error =  page.locator("p:has-text('Your email or password is incorrect!')").innerText().trim();
            System.out.println("inlineError is : " + Error );
            if(Error.equals("Your email or password is incorrect!")){

                System.out.println(" Inline Text displayed as per design");
            }else{
                System.out.println(" Inline Text displayed incorrect ");
            }
        }


        context.close();
        playwright.close();







    }
}
