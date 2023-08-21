package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by karpenko on 21.08.2023.
 * Description:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapResumeStorageTest.class,
        MapUuidStorageTest.class
})
public class AllStorageTest {
}
