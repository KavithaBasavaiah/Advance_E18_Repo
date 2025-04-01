package DDT_Practice_AS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage {
	
	@Test(dataProvider="getData")
	public void testCase(String firstName,String lastName)
	{
		System.out.println("firstname is "+firstName+"lastname is " + lastName);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][2];
		objArr[0][0]="Ram ";
		objArr[0][1]="Krishna ";
		objArr[1][0]="Vijaya ";
		objArr[1][1]="Lakshmi ";
		objArr[2][0]="Anna ";
		objArr[2][1]="Poora ";
		return objArr;
	}

}
