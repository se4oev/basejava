package com.urise.webapp.model;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public enum ContactType {

    PHONE_NUMBER("Телефонный номер"),
    SKYPE("Skype"),
    EMAIL("Электронная почта"),
    LINKED_IN("LinkedIn"),
    GITHUB("Github"),
    STACK_OVER_FLOW("Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
