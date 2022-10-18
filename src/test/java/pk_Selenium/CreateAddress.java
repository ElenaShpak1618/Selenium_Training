package pk_Selenium;

import org.testng.annotations.DataProvider;

public class CreateAddress {
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
}