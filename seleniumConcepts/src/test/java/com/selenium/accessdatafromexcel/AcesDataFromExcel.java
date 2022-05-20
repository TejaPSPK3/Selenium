package com.selenium.accessdatafromexcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AcesDataFromExcel {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");
		
		File file = new File("C:\\Users\\KAMTEJA\\HSBC-java practice\\TestSheetOfSelenium.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		//or
		//XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow r = sheet.getRow(2);
		for(Cell cells : r)
		{
			System.out.print(cells+" ");
		}
		
		
		System.out.println("\n");
		XSSFSheet sheet3 = wb.getSheet("sheet3");
		int numrows = sheet3.getLastRowNum();
		for(int i=0;i<=numrows;i++)
		{
			XSSFRow rows = sheet3.getRow(i);
			for(Cell allcells : rows)
			{
				System.out.print(allcells+"  ");
			}
			System.out.println();
			 
			//OR
			/*int lastcel = rows.getLastCellNum();
			for(int j=0;j<lastcel;j++)
			{
				System.out.print(rows.getCell(j)+" ");
			}*/
		}
		
		System.out.println();
		Iterator<Cell> f = sheet3.getRow(4).cellIterator();
		while(f.hasNext())
		{
			System.out.print(f.next()+" ");
		}
		
		System.out.println();
		sheet3.getRow(6).getCell(3).setCellValue("Economy");
		System.out.println(sheet3.getRow(6).getCell(3).toString());
	}

}
