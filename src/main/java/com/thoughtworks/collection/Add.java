package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        //求leftBorder 和rightBorder之间的偶数和
        int sum;
        if(leftBorder<=rightBorder) {
            sum = IntStream.range(leftBorder, rightBorder + 1).filter(n -> n % 2 == 0).sum();
        }else{
            sum = Stream.iterate(leftBorder, n -> n - 1)
                    .limit(leftBorder - rightBorder + 1).filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        }
        System.out.println(sum);
        return sum;
        //  throw new NotImplementedException();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        if(leftBorder<=rightBorder) {
            sum = IntStream.range(leftBorder, rightBorder + 1).filter(n -> n % 2!= 0).sum();
        }else{
            sum = Stream.iterate(leftBorder, n -> n - 1)
                    .limit(leftBorder - rightBorder + 1).filter(x -> x % 2 != 0).mapToInt(x -> x).sum();
        }
        return sum;
//        throw new NotImplementedException();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        //求数组中每个元素的3倍加2的和
        int sum = 0;
        List<Integer> temp = arrayList.stream().map(n -> n * 3 + 2).collect(Collectors.toList());
        for (int i = 0; i < temp.size(); i++) {
            sum += temp.get(i);
        }
        return sum;
//        throw new NotImplementedException();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加2，偶数元素不变的数组
        Integer[] array = new Integer[]{1, 5, 7, 12, 11, 35, 54, 67, 70};
        ArrayList<Integer> al = new ArrayList<>();
        int size = arrayList.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i)% 2 != 0) {
                al.add(arrayList.get(i) * 3 + 2);
            } else {
                al.add(arrayList.get(i));
            }
        }
        return al;
//        throw new NotImplementedException();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加5的和
        ArrayList<Integer> al = new ArrayList<>();
        int size = arrayList.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i)% 2 != 0) {
                sum += (arrayList.get(i) * 3 + 5);
            }
        }
        return sum;
//      throw new NotImplementedException();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        // 数组中前一个元素和后一个元素的和的3倍的数组
        double midNumber = 0;
        int size = arrayList.size();
        int len =  0;
        List<Integer> al = new ArrayList<>();
        al = arrayList.stream().filter(x->x%2==0).sorted((x1,x2)->x1.compareTo(x2))
                .collect(Collectors.toList());
        len = al.size();
        if(len%2==0){
            midNumber = (al.get(len/2-1)+al.get(len/2))/2;
        }else{
            midNumber = al.get(len/2);
        }
        return midNumber;
//        throw new NotImplementedException();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        //求数组中所有偶数组成的数组的中位数
        int count = 0;
        double sum = 0;
        double average_Even = 0;
        for (int i = 0; i <arrayList.size() ; i++) {
            if(arrayList.get(i)%2==0){
                count++;
                sum+=arrayList.get(i);
            }
        }
        average_Even = sum/count;
        return average_Even;
//        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        //求数组中所有偶数组成的数组是否包含某特定的数specialElment
        boolean result = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                if (specialElment.equals(arrayList.get(i))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
//        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        //去除数组中所有偶数组成的数组的重复数
        List<Integer> temp = arrayList.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
        return temp;
//       throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        //排序数组 结果使数组偶数在递增在前，奇数递减在后
        Object[] array = arrayList.toArray();
        int i, j;
        int[] temp = new int[array.length];
        for (i = 0; i < array.length; i++) {
            temp[i] = (int) array[i];
        }
        for (i = 0; i < temp.length; i++) {
            if (temp[i] % 2 != 0) {

            } else {
                int current = 0;
                current = temp[i];
                temp[i] = temp[temp.length - i - 1];
                temp[temp.length - i - 1] = current;
            }
        }
        int midIndex = 0;
        for (j = 0; j < temp.length; j++) {
            if (temp[j] % 2 == 0) {

            } else {
                midIndex = j;
                break;
            }
        }
        int even_Array[] = new int[midIndex];
        int odd_Array[] = new int[temp.length - midIndex];
        System.out.println();
        for (i = 0; i <even_Array.length; i++) {
            even_Array[i] = temp[i];
        }
        for (j = 0; j <=temp.length - midIndex - 1; j++) {
            odd_Array[j] = temp[midIndex + j];
        }
        sortBubble(even_Array);
        sortBubbleR(odd_Array);
        for (i = 0; i < even_Array.length; i++) {
            temp[i] = even_Array[i];
        }
        for (j = 0; j < odd_Array.length; j++) {
            temp[midIndex + j] = odd_Array[j];
        }
        ArrayList<Integer> re = new ArrayList<Integer>();
        for (i = 0; i < temp.length; i++) {
            re.add(temp[i]);
        }
        return re;
        //throw new NotImplementedException();
    }

    public void sortBubble(int[] array) {
        int i, j;
        int length = array.length;
        for (i = 0; i < length; i++) {
            for (j = length - i - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    int temp = 0;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void sortBubbleR(int[] array) {
        int i, j;
        int length = array.length;
        for (i = 0; i < length; i++) {
            for (j = length - i - 1; j > i; j--) {
                if (array[i] < array[j]) {
                    int temp = 0;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        int sum = 0;
        int size = arrayList.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size-1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
//        throw new NotImplementedException();
    }
}
