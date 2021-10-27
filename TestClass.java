package ddg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        System.out.println(countNumber(list));

//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(7);
//        list.add(10);
//        list.add(3);
//        list.add(15);
//        System.out.println(max(list));

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(5);
        array.add(10);
        array.add(3);
        array.add(25);
        array.add(2);
        array.add(7);
        array.add(4);
        ArrayList<Integer> newArray = quickSort(array);
//        for(Integer i : newArray){
//            System.out.println(i);
//        }
        System.out.println(newArray);
    }
    public static int countNumber(List list){
        if(list.size() < 1){
            return 0;
        } else {
            list.remove(0);
            return 1 + countNumber(list);
        }
    }

    public static int max(LinkedList<Integer> list){
        if(list.size() == 2){
            if(list.get(0) > list.get(1)) return list.get(0);
            else return list.get(1);
        }
        LinkedList<Integer> cloneList = (LinkedList<Integer>) list.clone();
        cloneList.remove(list.get(0));
        int subMax = max(cloneList);
        if(list.get(0) > subMax) return list.get(0);
        else return subMax;
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> array){
        if(array.size() < 2) return array;
        else {
            int pivot = array.get(0);
            ArrayList<Integer> lessArray = new ArrayList<>();
            ArrayList<Integer> greaterArray = new ArrayList<>();
            ArrayList<Integer> lastArray = new ArrayList<>();
            array.remove(0);
            for(Integer i : array){
                if(i <= pivot) {
                    lessArray.add(i);
                    //System.out.println("pivot is " + pivot + " and less i is " + i);
                }
                else {
                    greaterArray.add(i);
                    //System.out.println("pivot is " + pivot + " and greater i is " + i);
                }
            }
//            System.out.println(lessArray);
//            System.out.println(greaterArray);
            lastArray.addAll(quickSort(lessArray));
            lastArray.add(pivot);
            lastArray.addAll(quickSort(greaterArray));
            return lastArray;
        }
    }

//    public int searchInsert(int[] nums, int target) {
//
//    }
}
