import{test,expect} from '@playwright/test';
test('multichekbox' , async ({page})=>{

    await page.goto('https://testautomationpractice.blogspot.com/');

   const PageTitle =  await page.title();
    expect(PageTitle.trim()).toBe('Automation Testing Practice');

    // multichekbox

    const CheckboxLocator = [ '#sunday','#monday','#tuesday','#friday','#saturday'];

    for(const day of CheckboxLocator)
        {
        await page.locator(day).click();
}


// select dropdown by option

await page.selectOption('#country' , 'brazil');

await page.waitForTimeout(2000);


await page.locator('#colors').selectOption({label :  'Yellow'});


// print all the option of 


const OptionValue =  await page.$$('#animals option');

for(const value of OptionValue)
{
    console.log(await value.textContent());
}
 

});
