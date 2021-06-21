package Excelutil;

import java.util.ArrayList;

import utiliReader.Xls_Reader;

public class BookFlightExcelUtil 
{
	static Xls_Reader reader;


	public static ArrayList<Object[]> getDataFromExcel() {

	ArrayList<Object[]> myData = new ArrayList<Object[]>();
	 
	try {
	//Get the Excel data
	reader=new Xls_Reader("C:\\Users\\dell\\eclipse-workspace\\YatraAssign\\src\\main\\java\\Testdata\\Test.xlsx");
	}
	catch(Exception e) {
	e.printStackTrace();
	}
	//parameterization

	for(int rownum=2; rownum<= reader.getRowCount("FlightCity"); rownum++ ) {

	String Dept=reader.getCellData("FlightCity", "Depart", rownum);
	String Arrive=reader.getCellData("FlightCity", "Arrival", rownum);
	Object ob[]= {Dept, Arrive};
	//myData.add(ob);
	myData.add(new Object[] {Dept,Arrive});
	}
    return myData;
}

}
