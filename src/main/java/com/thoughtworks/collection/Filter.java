package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Filter {

    List<Integer> array;


    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        //求数组中的偶数
        return array.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        //求数组中3的倍数
        List<Integer> al  =  new ArrayList<>();
        al = array.stream().filter(n->n%3==0).collect(Collectors.toList());
        System.out.println(al);
        return al;

//        throw new NotImplementedException();
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        ////求两数组的公共元素
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            if (secondList.contains(firstList.get(i)))
                al.add(firstList.get(i));
        }
        return al;
//        throw new NotImplementedException();
    }

    public List<Integer> getDifferentElements() {
        //去除数组中的重复元素
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (result.contains(array.get(i))) {

            } else {
                result.add(array.get(i));
            }
        }
        return result;
//        throw new NotImplementedException();
    }
}
