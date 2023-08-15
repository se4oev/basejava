package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by karpenko on 14.08.2023.
 * Description:
 */
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());

        Object o = field.get(resume);
        System.out.println(o);

        field.set(resume, "5553535");
        Object o1 = field.get(resume);
        System.out.println(o1);

        Method toString = resume.getClass().getDeclaredMethod("toString");
        String str = (String) toString.invoke(resume);
        System.out.println(str);
    }

}
