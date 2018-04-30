package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        //选出给定区间中所有的数字
        List<Integer> al1 = new ArrayList<>();
        if(left<=right) {
            al1 = IntStream.range(left,right+1).boxed().collect(Collectors.toList());
        }else{
            al1 = Stream.iterate(left,n->n-1).limit(left-right+1).collect(Collectors.toList());
        }
        System.out.print(al1);
        return al1;
//      throw new NotImplementedException();
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        //选出给定区间中所有的偶数
        List<Integer> al = new ArrayList<Integer>();
        int[] array = new int[Math.abs(left - right) + 1];
        if (left <= right) {
            al = IntStream.range(left, right + 1).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());
        } else {
            al = Stream.iterate(left, n -> n - 1).limit(left - right + 1).filter(n -> n % 2 == 0).collect(Collectors.toList());
        }
        System.out.println(al);
        return al;
//       throw new NotImplementedException();
    }

    public List<Integer> popEvenElments(int[] array) {
        //选出给定区间中所有的偶数
        List<Integer> al = new ArrayList<>();
        al = Arrays.stream(array).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());
        return al;
//      throw new NotImplementedException();

    }

    public int popLastElment(int[]  array) {
        int last_Element = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            s.push(array[i]);
        }
        last_Element = s.peek();
        return last_Element;
        //throw new NotImplementedException();s

    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        //弹出两个集合的交集
        List<Integer> al = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j <secondArray.length ; j++) {
                if(firstArray[i]==secondArray[j]){
                    al.add(firstArray[i]);
                }
            }
        }
        return  al;
//        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        // 将集合二中与集合一不同的元素加入集合一
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i <firstArray.length ; i++) {
            al.add(firstArray[i]);
        }
        for(int j=0;j<secondArray.length;j++){
            if(!al.contains(secondArray[j])){
                al.add(secondArray[j]);
            }
        }
        return al;
//        throw new NotImplementedException();
    }
}
