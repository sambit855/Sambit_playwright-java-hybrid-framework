import {test, expect} from '@playwright/test';
test('login', async ({page}) => {

await page.goto("https://automationexercise.com/");

//Verify that home page is visible successfully
const pageTitle =  await page.title();
expect (pageTitle).toBe('Automation Exercise');
console.log('page title is : ' , pageTitle);


//Verify 'Login to your account' is visible
await page.click("a[href='/login']");
const Visible = await page.locator("h2:has-text('Login to your account')").isVisible();
console.log('Dose Login to your account display?',Visible);

// Enter correct email address and password
await page.locator("input[data-qa='login-email']").fill('sambit11@gmail.com');
await page.locator("input[data-qa='login-password']").fill('sambit@1991');
await page.getByRole('button', { name: 'Login' }).click();

//Validate logged in user displayed correctly
const loggedInText = await page.locator('b').textContent();
expect(loggedInText.trim()).toBe('sambit');
console.log('✅ User is logged in as sambit');



await page.close();

});


