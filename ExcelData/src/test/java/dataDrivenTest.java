import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenTest {
	
	
	public ArrayList<String> getData(String testcasename) throws IOException
	{

		ArrayList<String> a= new ArrayList<String>();
		
		//read the file path and file
		FileInputStream fs= new FileInputStream("D:\\XEROX\\eclipse\\TestData\\DataDrivenTesting.xlsx");
		XSSFWorkbook workbooks = new XSSFWorkbook(fs);
		
		//count the sheets
		int sheets = workbooks.getNumberOfSheets();
		
		for (int i=0; i<sheets;i++)
		{
			if (workbooks.getSheetName(i).equalsIgnoreCase("sample"))
			{
				XSSFSheet sheet = workbooks.getSheetAt(i); 
			
				Iterator<Row> rows= sheet.iterator();
				
				Row firstrow = rows.next();
				
				Iterator<Cell> cells= firstrow.cellIterator();
			
				int k=0, column =0;
				
			while(cells.hasNext())
			{
				Cell value = cells.next();
				if (value.getStringCellValue().equalsIgnoreCase("Testcases"))
						{
				column = k;	
						}
				 k++;
			}
			System.out.println(column);
			
			while(rows.hasNext())
			{
			Row	r=rows.next();
			
			
				if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
				{
				
				Iterator<Cell> cv2 = r.iterator();
				while (cv2.hasNext())
				{
					Cell c =cv2.next();
					if (c.getCellTypeEnum()==CellType.STRING)
					{
						a.add(c.getStringCellValue());
					}
					else{
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
					
				
				} 
				
				
				}
				
				
				}
				
			}
			
			
	}
		return a;
	}

	
}
