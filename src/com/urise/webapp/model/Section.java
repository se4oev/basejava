package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karpenko on 22.08.2023.
 * Description:
 */
public class Section {

    private final SectionType sectionType;
    private final List<String> text = new ArrayList<>();

    public Section(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public List<String> getText() {
        return text;
    }

}
