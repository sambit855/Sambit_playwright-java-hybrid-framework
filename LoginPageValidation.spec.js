import {test,expect} from '@playwright/test';

/*--------------------------Test 1-------------------------------------*/
test('login test Case 1', async ({page})=>{

//Launch the browser.
//Navigate to the login page URL.
await page.goto ('https://practice.expandtesting.com/login')

//Verify that the login page is displayed successfully.
const PageTitle = await page.title()
console.log(PageTitle)
await expect(page).toHaveTitle(PageTitle);

//Enter Username: practice.
// Enter Password: SuperSecretPassword!.
// Click the Login button.

await page.locator('#username').fill('practice')
await page.locator('#password').fill('SuperSecretPassword!')
await page.click('#submit-login')

//Verify that the user is redirected to the /secure page.
const NewPageTitle = await page.title()
console.log('New PageTitle is : ',NewPageTitle)
expect(page).toHaveTitle(NewPageTitle);

const NewpageUrl = await page.url()
console.log('New PageUrl is : ',NewpageUrl)
expect(page).toHaveURL(NewpageUrl)

//Confirm the success message "You logged into a secure area!" is visible.
const SuccessText = await page.locator("div[id='flash'] b").textContent()
console.log('success message is : ' , SuccessText)
await expect(await page.locator("div[id='flash'] b")).toHaveText('You logged into a secure area!');

//Verify that a Logout button is displayed.
const  LogOutButton = await page.locator("//i[@class='icon-2x icon-signout']").isVisible();
console.log('Dose logout button is displayed? : ' ,LogOutButton)
await expect(await page.locator("//i[@class='icon-2x icon-signout']")).toBeVisible();
});


/*--------------------------Test 2-------------------------------------*/
test('Test Case 2: Invalid Username', async ({page})=>{

//Launch the browser.
//Navigate to the login page URL.
await page.goto ('https://practice.expandtesting.com/login')

//Verify that the login page is displayed successfully.
const PageTitle = await page.title()
console.log(PageTitle)
await expect(page).toHaveTitle(PageTitle);

//Enter an incorrect Username (e.g., wrongUser).
// Enter Password: SuperSecretPassword!.
// Click the Login button.

await page.locator('#username').fill('wrongUserrrr')
await page.locator('#password').fill('SuperSecretPassword!')
await page.click('#submit-login')

await page.waitForTimeout(3000)

//Verify that an error message "Invalid username." is displayed.
const ErrorText =  await page.locator("div[id='flash'] b").innerText()
console.log('Error text is : ',ErrorText)
await expect(ErrorText).toBe("Your username is invalid!")

});

/*--------------------------Test 3-------------------------------------*/
test('Test Case 2: Invalid Password', async ({page})=>{

//Launch the browser.
//Navigate to the login page URL.
await page.goto ('https://practice.expandtesting.com/login')

//Verify that the login page is displayed successfully.
const PageTitle = await page.title()
console.log(PageTitle)
await expect(page).toHaveTitle(PageTitle);

//Enter an correct Username .
// Enter incorrect Password: SuperSecretPassword!////.
// Click the Login button.

await page.locator('#username').fill('practice')
await page.locator('#password').fill('SuperSecretPassword!////')
await page.click('#submit-login')

await page.waitForTimeout(3000)

//Verify that an error message "Invalid username." is displayed.
const ErrorText =  await page.locator("div[id='flash'] b").innerText()
console.log('Error text is : ',ErrorText)
await expect(ErrorText).toBe("Your password is invalid!")
});
