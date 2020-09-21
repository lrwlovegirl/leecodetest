package com.lrw.other.util;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 工具类，一个压缩包里有好多的图片，但是在很多文件下，将这些文件夹下的所有图片都移到一起
 */
public class UnpackImg {

    public static void main(String[] args) throws IOException {

//        ZipFile zipFile = new ZipFile("");
//        Enumeration<? extends ZipEntry> entries = zipFile.entries();
//        while (entries.hasMoreElements()){
//            ZipEntry zipEntry = entries.nextElement();
//
//        }
        File file = new File("D:\\BaiduNetdiskDownload\\2018mima111\\2018");
        helper(file);

    }

    public static void helper(File file) throws IOException {
        if (file.isDirectory()) {//是目录
            if ("arw".equals(file.getName())||"raw".equals(file.getName())||file.getName().contains("ARW")||file.getName().equals("arw")){
                System.out.println("什么也不做");
            }else {
                System.out.println(file.getName() + "是目录");
                File[] childFiles = file.listFiles();
                if (childFiles == null || childFiles.length == 0) {
                    return;
                } else {
                    for (int x = 0; x < childFiles.length; x++) {
                        helper(childFiles[x]);
                    }
                }
            }
        } else {
            System.out.println("正在复制：" + file.getAbsolutePath());
            FileUtils.copyFile(file, new File("D:\\BaiduNetdiskDownload\\2018mima111\\套图\\"+file.getName()));
        }
    }


}
