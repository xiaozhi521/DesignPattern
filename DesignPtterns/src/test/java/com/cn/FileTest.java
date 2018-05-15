package com.cn;

import org.junit.Test;

import java.io.File;

public class FileTest {
    @Test
    public void test(){
        File file = new File("D:\\workbook.xls");
        System.out.println(file.exists());
    }
    @Test
    public void reaName(){
        File file =  new File("D:\\workbook.xls");

        if(!file.exists()){
            System.out.println("文件不存在");
        }else{
            File file1 = new File("D:\\workbook1.xls");
            if(file1.exists()){
                System.out.println("file1 文件已存在");
            }else{
                file.renameTo(new File("D:\\workbook1.xls"));
            }
        }
    }
}
