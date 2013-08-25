package com.xysoft.springstudy.guava;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * User: jinyanhua
 * Date: 13-8-25
 * Time: 下午9:31
 */
public class GuavaCollections {
    public static void main(String[] args) {
        System.out.println("start...");
        List<String> list = Lists.newArrayList("1","2","3","4");
        Optional<String> opt = getName("test");
        if(opt.isPresent()){
            System.out.printf("here is name");
        }else {
            System.out.println("there is no value");
        }
    }

    private static Optional<String> getName(String test) {
        if(test.length()>5)
            return Optional.of(test);
        return Optional.fromNullable(null);
    }
}
