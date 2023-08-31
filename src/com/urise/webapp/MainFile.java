package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by karpenko on 31.08.2023.
 * Description:
 */
public class MainFile {

    public static void main(String[] args) {
        File file = new File("E:\\topjava\\BaseJava\\basejava\\.gitignore");
        File file2 = new File(".\\.gitignore");
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        try {
            System.out.println(file2.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Fatal Error", e);
        }

        File dir = new File("./src/com/urise/webapp");
        System.out.println("Is directory: " + dir.isDirectory());
        String[] list = dir.list();

        if (list != null)
            Arrays.stream(list).forEach(System.out::println);

        String filePath = "./.gitignore";
        //omg
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //right use try catch with resources
        try(FileInputStream fis2 = new FileInputStream(filePath)) {
            int read = fis2.read();
            System.out.println(read);
        } catch (IOException e ) {
            throw new RuntimeException(e);
        }
    }

}
