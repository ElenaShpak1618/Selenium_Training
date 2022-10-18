package pk_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;

public void LaunchBrowser(String browser) throws Exception {

	if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	} else if (browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	} else if (browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}

	else {

		throw new Exception("Browser is not correct");
	}

}

public void CloseBrowser() {

	driver.quit();
   }

//Bellow code is to read Excel file
private static Sheet ExcelWSheet;
private static Workbook ExcelWBook;

// This method is to read the test data from the Excel
public String[][] getExcelData(String fileName, String sheetName)
		throws EncryptedDocumentException, IOException, IllegalFormatException {
	String[][] arrayExcelData = null;
	FileInputStream ExcelFile = new FileInputStream(fileName);
	ExcelWBook = WorkbookFactory.create(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet(sheetName);
	// System.out.println(ExcelWSheet);	
	int totalNoOfRows = ExcelWSheet.getLastRowNum();
	int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();
	arrayExcelData = new String[totalNoOfRows][totalNoOfCols_0];
	for (int i = 0; i < totalNoOfRows; i++) {
		int totalNoOfCols = ExcelWSheet.getRow(i).getLastCellNum();
		// arrayExcelData = new String [totalNoOfRows][totalNoOfCols];
		for (int j = 0; j < totalNoOfCols; j++) {
			arrayExcelData[i][j] = ExcelWSheet.getRow(i + 1).getCell(j).getStringCellValue();
			// System.out.println(arrayExcelData[i][j]);
		}
	}
	System.out.println(arrayExcelData);
	return arrayExcelData;
  }

//==========Assignment========//
/*public class ConnectDB {

	@Test
	public void ConnectSQLDB(String dbUrl, String uNme, String password, String querry,String fValue, String sValue) throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl1 = "jdbc:mysql://localhost:3306/weborder";
		// Database Username
		String username = "uName";
		// Database Password
		String password1 = "pWord";
		// Query to Execute
		String query = "Query;";
		// Step1 : Load mysql jdbc driver
		Class.forName("DBConnector");
		// Step2: Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl1, username, password1);
		// Step3 : Create Statement Object
		Statement stmt = con.createStatement();
		// Step4 : Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String Username = rs.getString(fValue);
			String Password = rs.getString(sValue);
			System.out.println(Username + "  " + Password);

		}
		// Step5 : closing DB Connection
		con.close();
	}*/

   
//Read DB Function
	// Connection objectmy
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	
public ArrayList<String> ConnectMySQLDatabase(String DB_URL, String DB_USER, String DB_PASSWORD, String DB_QUERY)
		throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

	String dbClass = "com.mysql.jdbc.Driver";
	Class.forName(dbClass);
	// Get connection to DB
	con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	// Statement object to send the SQL statement to the Database
	stmt = con.createStatement();
	String query = DB_QUERY;
	// Get the contents of userinfo table from DB
	ResultSet res = stmt.executeQuery(query);
	// Print the result untill all the records are printed
	// res.next() returns true if there is any next record else returns
	// false

	ArrayList<String> sqlData = new ArrayList<String>();
	while (res.next()) {
		System.out.print("\t" + res.getString("uname"));
		System.out.println("\t" + res.getString("upass"));
		sqlData.add(res.getString("uname") + "~" + res.getString("upass"));
		// Adminadmin123
	}

	// Close DB connection
	if (con != null) {
		con.close();
	}
	return sqlData;
  }

//Code for Success and failure screenshots
static String filePath = System.getProperty("user.dir");

static String Relativepath_failure = filePath + "\\Screenshot_Failure";
static String Relativepath_success = filePath + "\\Screenshot_Success";

public static String getScreenshotfailure(WebDriver driver, String screenshotName) throws Exception {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = Relativepath_failure + "//"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
}

public static String getScreenshotSuccess(WebDriver driver, String screenshotName) throws Exception {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = Relativepath_success + "//"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
}
//To make screenshot
public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/Screenshot_Failure/"+screenshotName+dateName+".png";
	//String destination = System.getProperty("user.dir") + "/Screenshot_Failure/"+screenshotName+dateName+".mov";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
  }


} 

  


