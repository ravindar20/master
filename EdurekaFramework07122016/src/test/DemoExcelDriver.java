package test;

import commonLibs.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) {
		
		String sFilename = "C:\\workspace_edureka\\EdurekaFramework03092016\\InputFolder\\Test.xlsx";
		
		String sSheetName = "Test Sheet";
		ExcelDriver excel = new ExcelDriver();
		
		excel.createExcelWorkbook(sFilename);
		
		excel.openExcelWorkbook(sFilename);
		
		excel.createSheet(sSheetName);
		
		excel.setCellData(sSheetName, 1, 1, "Saurabh");
		
		excel.setCellData(sSheetName, 1, 2, "Dhingra");
		
		excel.setCellData(sSheetName, 2, 1, "Mousumi");
		
		excel.setCellData(sSheetName, 2, 2, "chakroborty");
		
		excel.setCellData(sSheetName, 3, 1, "Avishek");
		
		excel.setCellData(sSheetName, 3, 2, "Saha");
		
		
		excel.save();
		
		excel.close();
	}

}
