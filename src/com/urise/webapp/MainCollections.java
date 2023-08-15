package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by karpenko on 15.08.2023.
 * Description:
 */
public class MainCollections {

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        for (Resume resume : collection) {
            System.out.println(resume);
//            низзя удалять в цикле
//            if (Objects.equals(resume.getUuid(), UUID_1)) {
//                collection.remove(resume);
//            }
        }
        System.out.println(collection);

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            System.out.println(resume);
            //можно удалять через итератор
            if (Objects.equals(resume.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection);

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);

        //not correct
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }
        //correct
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
