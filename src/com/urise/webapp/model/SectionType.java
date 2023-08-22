package com.urise.webapp.model;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public enum SectionType {

    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private final String title;

    SectionType(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

}
