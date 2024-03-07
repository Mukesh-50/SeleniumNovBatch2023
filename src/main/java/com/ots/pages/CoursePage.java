package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ots.helper.Utility;

public class CoursePage 
{
	WebDriver driver;

	public CoursePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By clickOnAddNewCourseButton = By.xpath("//button[normalize-space()='Add New Course']");
	
	private By chooseFileButton = By.xpath("//input[@id='thumbnail']");
	
	private By txtboxCourseName = By.xpath("//input[@id='name']");
	
	private By txtboxDescription = By.xpath("//textarea[@id='description']");
	
	private By txtboxInstructor = By.xpath("//input[@id='instructorNameId']");
	
	private By txtboxPriceInput = By.xpath("//input[@id='price']");
	
	private By selectCategory = By.xpath("//div[normalize-space()='Select Category']");
	
	private By categoryName = By.xpath("//button[normalize-space()='Java']");
	
	private By saveButton = By.xpath("//button[normalize-space()='Save']");
	
	private By courseVerify= By.xpath("//td[normalize-space()='Java']");
	
	private By deactivateCourseButton = By.xpath("//button[normalize-space()='Deactivate Courses']");
	
	private By checkBoxCourseToDeactivate = By.xpath("//td[text()='Java']/.././td[3]/span/../../td[4]/../td/div/input[@type='checkbox']");
	
	
	public void addCourse(String filePath, String coursename, String description, String instructor, String price) throws InterruptedException
	{
		Utility.clickElement(driver,Utility.getElement(driver, clickOnAddNewCourseButton));
		
		Utility.getElement(driver, chooseFileButton).sendKeys(filePath);
		
		Utility.getElement(driver, txtboxCourseName).sendKeys(coursename);
		
		Utility.getElement(driver, txtboxDescription).sendKeys(description);
		
		Utility.getElement(driver, txtboxInstructor).sendKeys(instructor);
		
		Utility.getElement(driver, txtboxPriceInput).clear();
		
		Utility.getElement(driver, txtboxPriceInput).sendKeys(price);
		
		Utility.getElement(driver, selectCategory).click();
		
		Utility.getElement(driver, categoryName).click();
		
		Utility.getElement(driver, saveButton).click();
		
		Thread.sleep(2000);
		
	}
	
	public boolean checkCoursePresence()
	{
		boolean coursePresence=Utility.getElement(driver, courseVerify).isDisplayed();
		
		return coursePresence;
	}
	
	public void courseDeactivate() throws InterruptedException
	{
		Thread.sleep(5000);
		Utility.getElement(driver, checkBoxCourseToDeactivate).click();
		Thread.sleep(5000);
		
		Utility.getElement(driver, deactivateCourseButton).click();
			
	}
}
