package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce implements SingleLink<Integer>{

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {

        this.arrayList = arrayList;
    }
    public Integer getHeaderData(){
        int HeaderDate = 0;

        return 0;
    }
    public Integer getTailData(){
        return 0;
    }
    public int size(){
        return 0;
    }
    public boolean isEmpty(){
        return false;
    }
    public boolean deleteFirst(){
        return false;
    }
    public boolean deleteLast(){
        return false;
    }              //删除尾部元素；
    public void addHeadPointer(Integer item){

    }   //添加头指针
    public void addTailPointer(Integer item){

    }
    public Integer getNode(int index){
        return 0;
    }

    public int getMaximum() {
        // 获取数组中的最大值
        int maxValue = 0;
        maxValue = arrayList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        return maxValue;
//      throw new NotImplementedException();
    }

    public double getMinimum() {
        int minValue = 0;
        minValue = arrayList.stream().min(Comparator.comparing(Integer::valueOf)).get();
        return minValue;
//        throw new NotImplementedException();
    }

    public double getAverage() {
        double average = 0;
        average = arrayList.stream().mapToInt(n -> n).average().getAsDouble();
        return average;
//        throw new NotImplementedException();
    }

    public double getOrderedMedian() {
        // 获取数组中位数
        double midNumber = 0;
        int size = arrayList.size();
        int len = 0;
        List<Integer> al = new ArrayList<>();
        al = arrayList.stream().sorted((x1, x2) -> x1.compareTo(x2))
                .collect(Collectors.toList());
        len = al.size();
        if (len % 2 == 0) {
            midNumber = (al.get(len / 2 - 1) + al.get(len / 2)) / 2;
        } else {
            midNumber = al.get(len / 2);
        }
        return midNumber;
//        throw new NotImplementedException();
    }

    public int getFirstEven() {
        int firstEven = 0;
        firstEven = arrayList.stream().filter(n -> n % 2 == 0).findFirst().get();
        return firstEven;
//        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        int indexOfFirstEven = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                indexOfFirstEven = i;
                break;
            }
        }
        return indexOfFirstEven;

//        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean result = false;
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            al.add(arrayList.get(i));
        }
        if (arrayList.size() != al.size()) {
            result = false;
        } else if (arrayList.stream().equals(al)) {
            result = true;
        } else {
            result = false;
        }
        return result;
//        throw new NotImplementedException();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        //获取单链表中的中位数
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        int lastOdd = 0;
        List<Integer> al = new ArrayList<Integer>();
        Collections.reverse(arrayList);
        lastOdd = arrayList.stream().filter(n -> n % 2 != 0).findFirst().get();
        return lastOdd;
//        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        //获取数组中最后一个奇数的下标
        int lastOddIndex = 0;
        Collections.reverse(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                lastOddIndex = i;
            }
        }
        return lastOddIndex;
//        throw new NotImplementedException();
    }
}
