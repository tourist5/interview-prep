package com.example.interview_prep.Prep;

import java.util.*;

public class Day2 {
    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
//
//        if(map.getOrDefault("A",0) == 1){
//            System.out.println("Yes");
//        }


//        List<String> list = new ArrayList<>();
//
//        Iterator<String> it = list.iterator();
//
////
////        list.add("abhi");
////
////
////        for(String s : list){
////            list.remove(s);
////        }
//
//        while(it.hasNext()) {
//            it.remove();
//        }

//        Stack<Integer> stack=new Stack<>();
//
//        stack.pop();

//        Queue<Integer> q=new LinkedList<>();
//
//        System.out.println(q.poll());

//        PriorityQueue<String> pq =
//                new PriorityQueue<>((a,b)->Integer.compare(Integer.parseInt(a),Integer.parseInt(b)));
//        PriorityQueue<String> pq =
//                new PriorityQueue<>();
//
//        pq.offer("100");
//        pq.offer("20");
//        pq.offer("3");
//
//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }
//        double a = 0.1 + 0.2;
//
//        System.out.println(a);
        binarySearch(new int[]{1,3,4,6,7},3);
    }



        public static int binarySearch(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[mid] < target) {
                    left = mid ;
                } else {
                    right = mid ;
                }
            }

            return -1;
        }

//    100 A Home
//120 B Home
//130 A Product
//150 A Home
//170 C Home
//200 B Product
//250 A Checkout

}
