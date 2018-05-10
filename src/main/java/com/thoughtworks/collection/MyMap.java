package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {
    ;

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        //将集合A中的元素映射成集合B中的元素
        List<Integer> al = new ArrayList<Integer>();
        al = array.stream().map(n -> 3 * n).collect(Collectors.toList());
        return al;
    }

    public List<String> mapLetter() {
        //数字映射为字母
        return array.stream().map(num -> letters[num - 1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        List<String> al = new ArrayList<>();
        String[] result = new String[]{"a", "m", "aa", "ad", "az", "ba"};
        return  array.stream().map(num -> (num/26 > 0? letterList.get((num - 1) / 26 - 1): "") + letterList.get((num - 1) % 26)).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        List<Integer> al = new ArrayList<>();
        al = array.stream().sorted((x1, x2) -> x1.compareTo(x2)).collect(Collectors.toList());
        Collections.reverse(al);
        return al;
//        throw new NotImplementedException();
    }

    public List<Integer> sortFromSmall() {
        List<Integer> al = new ArrayList<>();
        al = array.stream().sorted((x1, x2) -> x1.compareTo(x2)).collect(Collectors.toList());
        return al;
//        throw new NotImplementedException();
    }
}
