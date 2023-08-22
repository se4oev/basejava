package com.urise.webapp;

import com.urise.webapp.model.SectionType;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public class TestSingleton {

    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null)
            instance = new TestSingleton();
        return instance;
    }

    private TestSingleton() {

    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());

        for (SectionType sectionType : SectionType.values()) {
            System.out.println(sectionType.title());
        }
    }

    public enum Singleton {
        INSTANCE
    }

}
