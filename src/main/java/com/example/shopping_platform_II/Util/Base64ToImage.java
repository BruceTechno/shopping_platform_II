package com.example.shopping_platform_II.Util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

public class Base64ToImage {
    public static void Base64ToImg(String imgBase64) throws FileNotFoundException, IOException {

        // 寫入到 txt 檔案
        try {
            String filePath = "D:\\Intellij_java\\animal_adoption\\src\\main\\resources\\img\\base64.txt";
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(imgBase64);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 將 txt 檔案讀取並轉換成圖片
        FileInputStream fis = new FileInputStream("src/main/resources/img/base64.txt");
        String stringTooLong = IOUtils.toString(fis, "UTF-8");
        // 關閉檔案
        fis.close();
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] b = decoder.decode(stringTooLong);
            Path imgFilePath = Path.of("D:\\Intellij_java\\animal_adoption\\src\\main\\resources\\img\\new.jpg");
            Files.write(imgFilePath, b, StandardOpenOption.CREATE);

            // 刪除 txt 檔案
            File fileToDelete = new File("src/main/resources/img/base64.txt");
            if (fileToDelete.delete()) {
                System.out.println("Txt file deleted.");
            } else {
                System.out.println("Failed to delete txt file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
