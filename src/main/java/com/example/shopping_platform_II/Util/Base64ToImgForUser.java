package com.example.shopping_platform_II.Util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.UUID;

public class Base64ToImgForUser {
    public static String Base64ToImgForUser(String imgBase64 ,String account) throws FileNotFoundException, IOException {

        // 寫入到 txt 檔案
        try {                                                               //txt檔案生成位置 =>生在Java
            String filePath = "D:\\java_project\\shopping_platform_II\\src\\main\\resources\\Img\\base64.txt";
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(imgBase64);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 將 txt 檔案讀取並轉換成圖片                                     路徑同上喔 =>生在Java
        FileInputStream fis = new FileInputStream("D:\\java_project\\shopping_platform_II\\src\\main\\resources\\Img\\base64.txt");
        String stringTooLong = IOUtils.toString(fis, "UTF-8");
        // 關閉檔案
        fis.close();
        Base64.Decoder decoder = Base64.getDecoder();
        try {

            byte[] b = decoder.decode(stringTooLong);    //>>這裡改直接放在前端資料夾
            String imgPath = "C:\\Users\\Yuzhe\\Desktop\\shopping_platform_Front_End\\shopping_platform_front_end\\pic"+account+".jpg";

            //圖片生成的路徑 +要生成的檔名
            Path imgFilePath = Path.of(imgPath);
            Files.write(imgFilePath, b, StandardOpenOption.CREATE);

            // 刪除 txt 檔案                            //這裡的路徑為上面txt檔案生成的路徑
            File fileToDelete = new File("src/main/resources/img/base64.txt");
            if (fileToDelete.delete()) {
                System.out.println("Txt file deleted.");
            } else {
                System.out.println("Failed to delete txt file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return account;
    }
}


