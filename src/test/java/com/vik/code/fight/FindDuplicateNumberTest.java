package com.vik.code.fight;

import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class FindDuplicateNumberTest {

    @Test
    public void testFindDuplicates() {
        List<Integer> numbers = Arrays.asList(5, 1, 4, 2, 3, 3, 4);
        Map<Integer, List<Integer>> valueIndices = FindDuplicateNumber.findDuplicates(numbers);
        Integer firstDuplicate = FindDuplicateNumber.findFirstDuplicate(valueIndices);
        System.out.println("First Duplicate : " + firstDuplicate);
    }

    @Test
    public void test() {
        Set<String> supportedFileAttribute = FileSystems.getDefault().supportedFileAttributeViews();
        if (supportedFileAttribute.contains("posix")) {
            // do posix code here
        } else if (supportedFileAttribute.contains("acl")) {
            // do acl code here
        } else {
            // create a file without permission with a warning message in the log
        }
    }

}
