package com.urise.webapp;

/**
 * Created by karpenko on 14.08.2023.
 * Description:
 */
public class MainString {

    public static void main(String[] args) {
        String[] strArray = new String[]{"1", "2", "3", "4", "5"};
        StringBuilder result = new StringBuilder();
        for (String str : strArray) {
            result.append(str).append(", ");
        }
        System.out.println(result);

        String str1 = "abc";
        //intern - в рантайме добавляет объект в пул строк
        String str2 = (str1 + "").intern();
        System.out.println(str1 == str2);
    }

}
