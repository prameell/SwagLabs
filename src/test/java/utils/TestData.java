package utils;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class TestData {
    static FileInputStream file;

    static Map<Integer, String> keys = new LinkedHashMap<>();
    static Map<Integer, String> values = new LinkedHashMap<>();
    static Map<String, String> dataComb = new LinkedHashMap<>();

    public static void readTestData(String testCaseNum) {
        try {
            file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.xlsx");
            Workbook wb = WorkbookFactory.create(file);        //read the workbook from the file
            Sheet sh = wb.getSheet("Sheet1");               // read the sheet
            for (Row row : sh) {                       //sheet data is in row now
                Cell firstCell = row.getCell(0);    //read the cell number only
                String cellValue = firstCell.getStringCellValue(); //get the cell value

                if (cellValue.equals("TestCaseNumber")) {           //TestCaseNumber taken as a base
                    for (Cell cell : row) {                          // row1 data
                        keys.put(cell.getColumnIndex(), cell.getStringCellValue()); //row1 data should be stored in object reference i.e., keys now
                    }
                } else if (cellValue.equals(testCaseNum)) {
                    for (Cell cell : row) {
                        values.put(cell.getColumnIndex(), cell.getStringCellValue());
                    }
                }

            }
            for (int i : values.keySet()) {               //keySet() means all the available keys i.e., getColumnIndex() in values object reference and keys are integer so type int taken
                dataComb.put(keys.get(i), values.get(i));  //add keys values & values values i.e., getStringCellValue()
            }
            //we can give the above foreach loop before closing of 1st foreach loop
//            System.out.println(keys);
//            System.out.println(values);
        } catch (Exception e) {
            System.out.println("unable to read the data " + e.getMessage());
        }
    }

    public static String getData(String key){
        return dataComb.get(key);
    }


//    public static void main(String[] args) {
//        readTestData("TC002");
//        System.out.println(dataComb);
//        // System.out.println(keys);
//        // System.out.println(values);  //here also we can write sout
//    }
}