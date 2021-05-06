package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class ExcelReadNWrite {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    private int k = 1;

    File src;
    FileOutputStream fos;

    public ExcelReadNWrite(String pathToExcelFile, String sheetName) throws IOException {

        src = new File(pathToExcelFile);
        FileInputStream fis = new FileInputStream(src);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public XSSFSheet getExcel() {
        return sheet;

    }

    public void openExcel() throws FileNotFoundException {
        fos = new FileOutputStream(src);

    }

    public void closeExcel() throws IOException {
        fos = new FileOutputStream(src);
        workbook.write(fos);
        fos.close();
    }


    public String getColumnStringValue(String ColumnStringValue, int ColumnNumber, int rowNumber) throws IOException {
        try {
            openExcel();
            ColumnStringValue = getExcel().getRow(rowNumber).getCell(ColumnNumber).getStringCellValue();
            closeExcel();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("<<<<<<<<Something wrong with getting String Value from Excel data (1)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
        } catch (IOException e) {
            System.out.println("<<<<<<<<Something wrong with getting String Value from Excel data (2)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println("<<<<<<<<Something wrong with getting String Value from Excel data (3)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
        }

        return ColumnStringValue;
    }

    public int getColumnIntValue(int ColumnIntValue, int ColumnNumber, int rowNumber) throws IOException {
        try {
            openExcel();
            ColumnIntValue = (int) getExcel().getRow(rowNumber).getCell(ColumnNumber).getNumericCellValue();
            closeExcel();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("<<<<<<<<Something wrong with getting Int Value from Excel data (1)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
        } catch (IOException e) {
            System.out.println("<<<<<<<<Something wrong with getting Int Value from Excel data (2)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println("<<<<<<<<Something wrong with getting Int Value from Excel data (3)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
        }

        return ColumnIntValue;
    }

    public void setColumnValue(String ColumnIntValue, int ColumnNumber, int rowNumber) throws IOException {
        try {
            openExcel();
            getExcel().getRow(rowNumber).createCell(ColumnNumber).setCellValue(ColumnIntValue);
            closeExcel();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("<<<<<<<<Something wrong with setting Value into Excel data (1)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
        } catch (IOException e) {
            System.out.println("<<<<<<<<Something wrong with setting Value into Excel data (2)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println("<<<<<<<<Something wrong with setting Value into Excel data (3)>>>>>>>>" + "\n" + e);
            openExcel();
            closeExcel();
        }

    }


}
