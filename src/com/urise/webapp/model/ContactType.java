package com.urise.webapp.model;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public enum ContactType {

    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
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
