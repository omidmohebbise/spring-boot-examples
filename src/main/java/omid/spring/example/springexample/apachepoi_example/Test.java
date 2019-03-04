package omid.spring.example.springexample.apachepoi_example;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 17
 * Created by anirudh on 20/10/14.
 * 18
 */
public class Test {
    private static final String FILE_PATH = "/home/omidmohebbi/AAomidmohebbi/temphse/folad.xlsx";
    private static final String TAG = "#### ==>";

    public  void main(String args[]) {
        List studentList = getStudentsListFromExcel();
        System.out.println(studentList);
    }

    private static List<Patient> getStudentsListFromExcel() {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(FILE_PATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = null;
            try {
                workbook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int numberOfSheets = workbook.getNumberOfSheets();
            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();
                //iterating over each row
                boolean isFirst = true;
                while (rowIterator.hasNext()) {

                    Row row = (Row) rowIterator.next();
                    if (isFirst) {
                        isFirst = false;
                        continue;
                    }

                    Iterator cellIterator = row.cellIterator();
                    Patient patient = new Patient();
                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {
                        Cell cell = (Cell) cellIterator.next();
                        if (cell.getColumnIndex() == 1) {
                            // patient ID
                            String obj = cell.getStringCellValue();
                            Integer id = obj == null ? null : Integer.parseInt(obj);
                            patient.setId(id);
                        } else if (cell.getColumnIndex() == 2) {
                            //Patient Name
                            String obj = cell.getStringCellValue();
                            patient.setPatientName((String) obj);
                        } else if (cell.getColumnIndex() == 3) {
                            //Patient family
                            String obj = cell.getStringCellValue();
                            patient.setPatientFamily((String) obj);
                        } else if (cell.getColumnIndex() == 4) {
                            // Patient age
                            String obj = cell.getStringCellValue();
                            Integer age = obj == null ? null : Integer.parseInt(obj);
                            patient.setAge(age);
                        } else if (cell.getColumnIndex() == 5) {
                            //Patient mobile
                            String obj = cell.getStringCellValue();
                            patient.setPhoneCell((String) obj);
                        } else if (cell.getColumnIndex() == 6) {
                            //Nationa Code
                            String obj = cell.getStringCellValue();
                            patient.setNationalCode((String) obj);
                        } else if (cell.getColumnIndex() == 7) {
                            //date reciept
                            String obj = cell.getStringCellValue();
                            patient.setDateRecept((String) obj);
                        } else if (cell.getColumnIndex() == 7) {
                            //date reciept
                            String obj = cell.getStringCellValue();
                            patient.setDateRecept((String) obj);
                        } else if (cell.getColumnIndex() == 8) {
                            //doktor
                            String obj = cell.getStringCellValue();
                            patient.setDoktorCode((String) obj);
                        } else if (cell.getColumnIndex() == 9) {
                            //price
                            String obj = cell.getStringCellValue();
                            Long price = obj == null ? null : Long.parseLong(obj);
                            patient.setPrice(price);
                        } else if (cell.getColumnIndex() == 10) {
                            //expriment name
                            String obj = cell.getStringCellValue();
                            patient.setExprementName((String) obj);
                        } else if (cell.getColumnIndex() == 11) {
                            //Response
                            String obj = cell.getStringCellValue();
                            patient.setResponse((String) obj);
                        } else if (cell.getColumnIndex() == 12) {
                            //normal pain
                            String obj = cell.getStringCellValue();
                            patient.setPain((String) obj);
                        } else if (cell.getColumnIndex() == 13) {
                            //unit
                            String obj = cell.getStringCellValue();
                            patient.setUnit((String) obj);
                        } else if (cell.getColumnIndex() == 14) {
                            //part
                            String obj = cell.getStringCellValue();
                            patient.setPart((String) obj);
                        }
                        patients.add(patient);

                        // studentList.add(student);
                    }//end ot iterating ce..
                }//end iterating a row, add all the elements of a row in list
            } //end iterating a sheet,
            fis.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


        Patient.printPatients(patients);

        return patients;

    }

}



