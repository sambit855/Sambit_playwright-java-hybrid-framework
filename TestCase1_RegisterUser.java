package automation_Exericies;

import com.microsoft.playwright.*;

public class TestCase1_RegisterUser {

    public static void main(String[] args) {

       Playwright playwright =  Playwright.create();
       // Launch browser
       Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
       BrowserContext context1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
       Page page =  context1.newPage();
      //  Navigate to url 'http://automationexercise.com'
        page.navigate("https://automationexercise.com/");
       // Verify that home page is visible successfully
        System.out.println(" Page Title is : " + page.title() );
        // Click on 'Signup / Login' button
        page.locator("a:has-text(' Signup / Login')").click();
        // Verify 'New User Signup!' is visible
       boolean   Signup = page.locator("h2:has-text('New User Signup!')").isVisible();
        System.out.println("Does new user signup text display on the screen ? : " + Signup);
        // Enter name and email address
        page.locator("input[type = 'text'][data-qa = 'signup-name']").fill("Sambit");
        page.locator("input[type='email'][data-qa = 'signup-email']").fill("sambitt@gmail.com");
        //Click 'Signup' button
        page.locator("button[type='submit'][data-qa='signup-button']:has-text('Signup')").click();
       // Verify that 'ENTER ACCOUNT INFORMATION' is visible
       boolean Account_Information = page.locator("b:has-text('Enter Account Information')").isVisible();
        System.out.println("Dose Account Information  text displayed on the screen ? " + Account_Information );
        if(Account_Information){
           String  ActualText =  page.locator("b:has-text('Enter Account Information')").innerText();
            System.out.println(" Actual Text is : " + ActualText );
            if(ActualText.equals("Enter Account Information")){
                System.out.println("Displayed text as per design .");
            }
            else{
                System.out.println("Displayed text is incorrect . ");
            }
        }

       // Fill details: Title, Name, Email, Password, Date of birth
        page.locator("#id_gender1").check();
       Locator Name =  page.locator("#name");
        Name.click();
        Name.clear();
        Name.fill("Sambit Kumar Mohapatra");
        //Password
        page.locator("#password").fill("sambit@123");
       // Date of birth -day
        page.locator("select[data-qa='days']#days").selectOption("10");
        // Date of birth -month
        page.locator("select[data-qa = 'months']#months").selectOption("February");
        // Date of birth -year
        page.locator("select[data-qa = 'years']#years").selectOption("2001");
        //Select checkbox 'Sign up for our newsletter!'
        page.locator("label:has-text('Sign up for our newsletter!')").check();
        //Select checkbox 'Receive special offers from our partners!'
        page.locator("label:has-text('Receive special offers from our partners!')").check();

       // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        page.locator("#first_name").fill("Sambit Kumar");
        page.locator("#last_name").fill("Mohapatra");
        page.locator("#address1").fill("Samalpur");
        page.locator("#state").fill("odisha");
        page.locator("#city").fill("Balasore");
        page.locator("#zipcode").fill("756008");
        page.locator("#mobile_number").fill("7681828900");
       // Click 'Create Account button'
        page.locator("button[data-qa='create-account']:has-text('Create Account')").click();
        //Verify that 'ACCOUNT CREATED!' is visible
       boolean AcCreated = page.locator("h2:has-text('Account Created!')").isVisible();
        System.out.println("Text Displayed : " + AcCreated );
       Locator Text = page.locator("p:has-text('Congratulations! Your new account has been successfully created!')");
       String CratedText =  Text.textContent().trim();
        System.out.println("CratedText is : " + CratedText);
       // Click 'Continue' button
        page.locator("a[data-qa='continue-button']:has-text('Continue')").click();

        //Verify that 'Logged in as username' is visible
        Locator userName = page.locator("a b");
        String actualName = userName.textContent().trim();
        System.out.println(actualName);
        //Click 'Delete Account' button
        page.locator("a:has-text('Delete Account')").click();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
       boolean Account_Deleted = page.locator("h2[data-qa='account-deleted']:has-text('Account Deleted!')").isVisible();
        System.out.println(" Dose Account Delete Text Displayed ? " + Account_Deleted );

        context1.close();
        playwright.close();


    }
}
