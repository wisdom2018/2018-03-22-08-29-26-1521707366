package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        //把二维数组变成一维数组
        List<Integer> al = new ArrayList<>();
        al = Arrays.stream(array)                    //'array' is two-dimensional
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        return al;
//        throw new NotImplementedException();
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> al = new ArrayList<>();
        al = Arrays.stream(array)                    //'array' is two-dimensional
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList());
        return al;
//        throw new NotImplementedException();
    }
}
