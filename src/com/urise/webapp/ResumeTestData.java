package com.urise.webapp;

import com.urise.webapp.model.*;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.getContacts().put(ContactType.PHONE_NUMBER, new Contact(ContactType.PHONE_NUMBER, "+7(921) 855-0482"));
        resume.getContacts().put(ContactType.SKYPE, new Contact(ContactType.SKYPE, "+7(921) 855-0482"));
        resume.getContacts().put(ContactType.EMAIL, new Contact(ContactType.EMAIL, "+7(921) 855-0482"));
        resume.getContacts().put(ContactType.LINKED_IN, new Contact(ContactType.LINKED_IN, "+7(921) 855-0482"));
        resume.getContacts().put(ContactType.GITHUB, new Contact(ContactType.GITHUB, "+7(921) 855-0482"));
        resume.getContacts().put(ContactType.STACK_OVER_FLOW, new Contact(ContactType.STACK_OVER_FLOW, "+7(921) 855-0482"));
        resume.getContacts().put(ContactType.HOME_PAGE, new Contact(ContactType.HOME_PAGE, "+7(921) 855-0482"));

        for (SectionType sectionType : SectionType.values()) {
            Section section = new Section(sectionType);
            section.getText().add("Some Information");
            resume.getSections().put(sectionType, section);
        }

        System.out.println(resume);
    }

}
