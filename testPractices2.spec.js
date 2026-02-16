import {test,expect} from '@playwright/test'
import { link } from 'node:fs'
test('test practices',  async ({page})=> {

await page.goto("https://testautomationpractice.blogspot.com/")
const pagetitle = await page.title()
console.log('page title is :' ,pagetitle)
await expect(pagetitle).toBe('Automation Testing Practice')

//select the readio button
/*await page.locator("//label[@class='form-check-label' and @for='female']").click();

//seelct dropdown option 
const countrydropdown = await page.locator('#country')
const valueToSelect = 'Japan'
 const country = await page.locator('#country option')

 let dropdownText = await country.allInnerTexts()
 dropdownText = dropdownText.map(text => text.trim());
 await console.log(dropdownText)
  
 if(dropdownText.includes(valueToSelect))
 {
    await countrydropdown.selectOption(valueToSelect);
 }
 else{
    console.log('Value is not present')
 }
 await expect(countrydropdown).toHaveValue('japan')

 //select multi dropdown option

 const MultiOption = await page.locator('#colors option').allInnerTexts()
 console.log(MultiOption)

 await page.selectOption('#colors',['Red','Blue','Green'])

//multiselectdropdown

const multidrop = await page.locator('#animals')
const valueToSelect2 = 'Dog'
const multidropoption = await page.locator('#animals option').allInnerTexts()
await console.log(multidropoption)

if(multidropoption.includes(valueToSelect2))
{
    await multidrop.selectOption(valueToSelect2)
    
}
await expect(await page.locator('#animals')).toHaveValue('dog')

//date picker 

const datebox = await page.locator("//input[@id='datepicker' and @class='hasDatepicker']").click()
const ExpectYear = '2028'
const ExpectMonth= 'August'
const ExpectDate = '27'

while(true)
{
    const CurrentMonth = await page.locator('.ui-datepicker-month').textContent()
    const currentyear = await page.locator('.ui-datepicker-year').textContent()

    if(CurrentMonth === ExpectMonth && currentyear===ExpectYear)
    {

        break;
    }
    await page.locator(".ui-icon:has-text('Next')").click()
}

await page.locator(`.ui-datepicker-calendar a:text-is("${ExpectDate}")`).click();

//select dropdown handleing

await page.locator("//input[@id='txtDate' and @name='SelectedDate' and @class='hasDatepicker']").click()

await expect(await page.locator('.ui-datepicker-calendar')).toBeVisible()//valiade calender is visible after click

const Expectedmonth = 'Nov' 
const Expectyear = '2029'
const ExpectedDates = '25'

await page.selectOption('.ui-datepicker-month',{label : Expectedmonth })
await page.selectOption("//select[@class='ui-datepicker-year' and @aria-label='Select year']",{label : Expectyear})

await page.locator(`a.ui-state-default:text-is("${ExpectedDates}")`).click()

//file upload

await page.locator('#singleFileInput').setInputFiles('C:/Users/HP/OneDrive/Desktop/Sambit_Kumar_Mohapatra_Resume (1).pdf')
await page.locator("//button[@type='submit' and contains(text(),'Upload Single File')]").click()

//web table

const webtable = await page.locator("table[name='BookTable']")
await expect(webtable).toBeVisible()
const tabeletext = await page.locator("table[name='BookTable'] tr").allInnerTexts()
await console.log(tabeletext)

const value = await page
  .locator("table[name='BookTable'] tr")
  .nth(2)            // 2nd row (index starts from 0)
  .locator('td')
  .nth(3)            // 3rd column
  .textContent();

console.log(value);*/

const links = await page.locator('a')
const linkText = await links.allInnerTexts()
if(linkText.includes('Home'))
{
    
    await page.locator('a', { hasText: 'Home' }).nth(2).click();
    
}

})