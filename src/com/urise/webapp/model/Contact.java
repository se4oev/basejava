package com.urise.webapp.model;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public class Contact {

    private final ContactType contactType;
    private final String text;

    public Contact(ContactType contactType, String text) {
        this.contactType = contactType;
        this.text = text;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public String getText() {
        return text;
    }

}
