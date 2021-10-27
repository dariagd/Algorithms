package ddg;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static LinkedList<ListNode> mergeTwoLists(LinkedList<ListNode> l1, LinkedList<ListNode> l2){
        LinkedList<ListNode> list = new LinkedList<>();
        list.addAll(l1);
        list.addAll(l2);
        return sort(list);
    }
    public static LinkedList<ListNode> sort(LinkedList<ListNode> list){
        if(list.size() < 2){
            return list;
        }
        else {
            int pivot = list.get(0).val;
            ListNode daddyOfPivot = list.get(0);
            LinkedList<ListNode> lessList = new LinkedList<>();
            LinkedList<ListNode> greaterList = new LinkedList<>();
            LinkedList<ListNode> averageList = new LinkedList<>();
            list.remove(0);
            for(ListNode node : list){
                if(node.val <= pivot){
                    lessList.add(node);
                } else {
                    greaterList.add(node);
                }
            }
            averageList.addAll(sort(lessList));
            averageList.add(daddyOfPivot);
            averageList.addAll(sort(greaterList));
            return averageList;
        }
    }

    public static void main(String[] args) {
//        ListNode first3 = new ListNode(3);
//        ListNode first2 = new ListNode(2, first3);
//        ListNode first1 = new ListNode(1, first2);
//        LinkedList<ListNode> list1 = new LinkedList<>();
//        list1.add(first1);
//        list1.add(first2);
//        list1.add(first3);
//        ListNode second3 = new ListNode(6);
//        ListNode second2 = new ListNode(5, second3);
//        ListNode second1 = new ListNode(4, second2);
//        LinkedList<ListNode> list2 = new LinkedList<>();
//        list2.add(second1);
//        list2.add(second2);
//        list2.add(second3);
//        LinkedList<ListNode> list = mergeTwoLists(list1, list2);
//        for(ListNode item : list){
//            System.out.println(item.val);
//        }
        System.out.println(duplicateZeros(new int[]{1,0,2,3,0,4,5,0}));
    }

    public static String duplicateZeros(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
            int j = i + counter;
            if(j < arr.length) {
                if (arr[i] == 0){
                    map.put(j, arr[i]);
                    //System.out.println("put " + arr[i] + " with index " + i);
                    counter++;
                    map.put(i+counter, arr[i]);
                    //System.out.println("put " + arr[i] + " with index " + (i + counter));
                } else {
                    map.put(j, arr[i]);
                    //System.out.println("put " + arr[i] + " with index " + j);
                }
            } else {
                break;
            }
        }
        //System.out.println(map);
        return map.values().toString().replaceAll("\\s","");
    }

    public void duplicate(int[] arr){

    }
}