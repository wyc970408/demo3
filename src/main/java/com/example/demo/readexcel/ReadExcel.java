package com.example.demo.readexcel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static void main(String[] args){
        ReadExcel obj=new ReadExcel();
        File file=new File("D:/readExcel.xls");
        List excelList=obj.readExcel(file);
        System.out.println("list数据");
        for(int i=0;i<excelList.size();i++){
            List list=(List) excelList.get(i);
            for (int j=0;j<list.size();j++){
                System.out.println(list.get(j));
            }
            System.out.println();
        }
    }



    public List readExcel(File file){
        try {
            InputStream inputStream=new FileInputStream(file.getAbsolutePath());
            Workbook wb=Workbook.getWorkbook(inputStream);
            int sheet_size=wb.getNumberOfSheets();
            for (int index=0;index<sheet_size;index++){
                List<List>outerList=new ArrayList<>();
                Sheet sheet = wb.getSheet(index);
                for(int i=0;i<sheet.getRows();i++){
                    List innerList=new ArrayList();
                    for(int j=0;j<sheet.getColumns();j++){
                        String cellinfo=sheet.getCell(j,i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                       // System.out.print(cellinfo);
                    }
                    outerList.add(i,innerList);
                    //System.out.println();
                }
                return outerList;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (BiffException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
