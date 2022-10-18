package com.spreecom;
import org.testng.annotations.DataProvider;

import pk_Selenium.BaseClass;
public class TestData {
	
	
	@DataProvider (name = "Create_Address")
	public Object[][] getChangedAdress() {
		return new Object [][] {
			
			
{"Street", "Ivan", "Stepanov", "Sun Francisco", "Sun Sun", "California", 94016, "9162873650"},
{"Frame", "Ilon", "Mask", "Sacramento", "Sun Moon", "California", 94016, "9162877650" },
{"Beach", "Nina", "Sum", "Santa Rosa", "Sun Sun", "California",95404, "9166073650" },
{"Home", "Helena", "Shpa3", "Sun Jose", "Sun Sun", "California", 94088, "9162878850" },
{"Home", "Selena", "Shpa4", "Sun Diego", "Sun Fun", "California", 22400, "9772873650" },
{"Home", "Milena", "Shpa5", "Sun F", "Sun Sun", "California",90291 ," 4162873650" },

};
		
		}
	


@DataProvider(name = "Weborder_Login_Scenario")
public Object[][] LoginTcs() {
	// Multidimensional Object
	// 3X3 or 4X3 or 4X5
	return new Object[][] {

			{"Tester","test","List of All Orders"},
			{"Tester1","test","Invalid Login or Password."},
			{"Tester","test1","Invalid Login or Password."},
			{"","test","Invalid Login or Password."},
			{"Farid","","Invalid Login or Password."},
			};
			
			
			
}


@DataProvider(name = "Input_Data") //Last
public Object[][] FirstLoginTcs() {
	// Objects for  register

	return new Object[][] {

			{"20","100","lena","Test","Sun","San Fransico","California","9585","12345","05/24" },
			{"30","100","Elen","Test1","Sun1","San Fransico","California","9835","1245","06/24" },
			{"10","100","Elna","Test2","Sun2","San Fransico","California","5835","1345","07/24" },
			{"3","100","Eena","Test3","Su3","San Fransico","California","9583","1235","12/24" },
			{"7","100","Ele","Test4","Sun4","San Fransico","California","9585","1235","01/24" },
			{"9","100","ena","Test5","Sun5","San Fransico","California","95835","125","10/24" },
			
	};
	

}
@DataProvider(name = "LoginExcelData")
public Object[][] ReadDataFromExcel() throws Exception{
	BaseClass excel = new BaseClass();
	String RelativePath = System.getProperty("user.dir");
	//Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xls","Login");
	Object[][] testObjArray = excel.getExcelData(RelativePath+"\\WebOrder.xls","Login");
	System.out.println(testObjArray);
	return testObjArray;
  }


}


		
	
		

  

