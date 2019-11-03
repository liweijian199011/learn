package com.jack.learn.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author liweijian.
 * @date 2019/7/12.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = Collections.singletonList("a");
        System.out.println(list);

        String[] strArray = new String[] {"a", "b", "c"};
        List<String> strList = Arrays.asList(strArray);
        System.out.println(strList);
    }
}
