package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;

/**
 * Created by karpenko on 14.08.2023.
 * Description:
 */
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());

        Object o = field.get(resume);
        System.out.println(o);

        field.set(resume, "5553535");
        Object o1 = field.get(resume);
        System.out.println(o1);
    }

}
