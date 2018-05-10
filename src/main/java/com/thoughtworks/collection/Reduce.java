package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce implements SingleLink<Integer> {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {

        this.arrayList = arrayList;
    }

    public int getMaximum() {
        // 获取数组中的最大值
        int maxValue = 0;
        maxValue = arrayList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        return maxValue;
    }

    public double getMinimum() {
        int minValue = 0;
        minValue = arrayList.stream().min(Comparator.comparing(Integer::valueOf)).get();
        return minValue;
    }

    public double getAverage() {
        double average = 0;
        average = arrayList.stream().mapToInt(n -> n).average().getAsDouble();
        return average;
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
    }

    public int getFirstEven() {
        int firstEven = 0;
        firstEven = arrayList.stream().filter(n -> n % 2 == 0).findFirst().get();
        return firstEven;
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
    }

    public boolean isEqual(List<Integer> arrayList1) {
        Collections.sort(arrayList1);
        Collections.sort(arrayList);
        return arrayList.equals(arrayList1);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        this.arrayList.stream().forEach(singleLink::addTailPointer);
        return (double) ((int) singleLink.getNode(this.arrayList.size() / 2) + (int) singleLink.getNode(this.arrayList.size() / 2 + 1)) / 2;
    }

    public int getLastOdd() {
        int lastOdd = 0;
        List<Integer> al = new ArrayList<Integer>();
        Collections.reverse(arrayList);
        lastOdd = arrayList.stream().filter(n -> n % 2 != 0).findFirst().get();
        return lastOdd;
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
    }

    @Override
    public Integer getHeaderData() {
        return this.arrayList.get(0);
    }

    @Override
    public Integer getTailData() {
        return this.arrayList.get(this.arrayList.size() - 1);
    }

    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public Integer getNode(int index) {
        return this.arrayList.get(index - 1);
    }

    @Override
    public boolean deleteFirst() {
        return this.arrayList.remove(this.getHeaderData());
    }

    @Override
    public boolean deleteLast() {
        return this.arrayList.remove(this.getTailData());
    }

    @Override
    public void addHeadPointer(Integer item) {
        this.arrayList.add(0, item);
    }

    @Override
    public void addTailPointer(Integer item) {
        this.arrayList.add(item);
    }
}
