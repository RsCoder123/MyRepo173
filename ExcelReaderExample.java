package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderExample {

	public static void main(String[] args)  {
		HashMap<String,Integer> map1=new HashMap<>();
		HashMap<String,Integer> map2=new HashMap<>();
		HashMap<String,String> map3=new HashMap<>();
		ArrayList<String> arraylist=new ArrayList<>();
		ArrayList<String> arraylist1=new ArrayList<>();
		
		
		 try
	        {
	            FileInputStream file = new FileInputStream(new File("/Users/rahul.singh/Documents/Input-1.xlsx"));
	            FileInputStream file1 = new FileInputStream(new File("/Users/rahul.singh/Documents/Input2.xlsx"));
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            XSSFSheet sheet1 = workbook1.getSheetAt(0);
	            for (Row row : sheet) {
	                Cell cell = row.getCell(0);
	               System.out.println(cell.toString());
	                if(!map1.containsKey(cell.toString()))
	                {
	                	map1.put(cell.toString(), 1);
	                }
	                else
	                	map1.put(cell.toString(),map1.get(cell.toString())+1);
	                arraylist.add(cell.toString());
	            }
	            for (Row row : sheet1) { 
	                Cell cell = row.getCell(0);
	               System.out.println(cell.toString());
	                if(!map2.containsKey(cell.toString()))
	                	map2.put(cell.toString(), 1);
	                else
	                	map2.put(cell.toString(),map2.get(cell.toString())+1);
	                arraylist1.add(cell.toString());
	            }
	            for(String str:map1.keySet())
	            {
	            	if(map1.get(str)>1)
	            	{
	            		if(map2.containsKey(str))
	            			map3.put(str, "red");
	            		else
	            			map3.put(str, "blue");
	            	}
	            	else
	            		map3.put(str,"white");
	            	
	            }
	            for(String str:map2.keySet())
	            {
	            	if(map2.get(str)>1)
	            	{
	            		if(map1.containsKey(str))  
	            			map3.put(str, "red");
	                     
	            		else
	            			map3.put(str, "blue");
	            	}
	            	else
	            		if(map1.containsKey(str))  
	            		if(map1.get(str).equals(1))
	            		map3.put(str,"green");
	            		else
	            	    if(map1.get(str)>1)
	            		map3.put(str,"red");
	            		else
	            			map3.put(str,"white");	
	            }
	            
	            System.out.println(map1);
	            System.out.println(map2);
             System.out.println(map3);
	       
	            file.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		 coloringExcelSheet(arraylist,arraylist1,map3);
	    } 
	static void coloringExcelSheet(ArrayList<String> arr,ArrayList<String> arr1,HashMap<String,String>map)
			{
		Workbook workbook = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("example");
        int count=0;
        for(int i=0;i<arr.size();i++)
        {
        Row row = sheet.createRow(count++);
        Cell cell = row.createCell(0);
        cell.setCellValue(arr.get(i));
        CellStyle cellStyle = workbook.createCellStyle();
        if(map.get(arr.get(i)).equals("red"))
        {
        cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.ALT_BARS);
        cell.setCellStyle(cellStyle);
        }
        else if(map.get(arr.get(i)).equals("blue"))
        {
        	cellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.ALT_BARS);
            cell.setCellStyle(cellStyle);
        }
        else if(map.get(arr.get(i)).equals("green"))
        {
        	cellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
            cellStyle.setFillPattern(FillPatternType.ALT_BARS);
            cell.setCellStyle(cellStyle);
        }

        cell = row.createCell(1);
        cell.setCellValue(arr1.get(i));
        cellStyle = workbook.createCellStyle();
        if(map.containsKey(arr1.get(i)))
        if(map.get(arr1.get(i)).equals("red"))
        {
        cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.ALT_BARS);
        cell.setCellStyle(cellStyle);
        }
        else if(map.get(arr1.get(i)).equals("blue"))
        {
        	cellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.ALT_BARS);
            cell.setCellStyle(cellStyle);
        }
        else if(map.get(arr1.get(i)).equals("green"))
        {
        	cellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
            cellStyle.setFillPattern(FillPatternType.ALT_BARS);
            cell.setCellStyle(cellStyle);
        }

        try(OutputStream outputStream = new FileOutputStream("/Users/rahul.singh/output.xlsx")) {
            workbook.write(outputStream);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        }

}
	}
