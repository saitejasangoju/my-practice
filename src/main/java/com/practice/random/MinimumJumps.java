package com.practice.random;

public class MinimumJumps {

    public static void main(String[] args) {
//        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int arr[] = {1, 4, 3, 2, 6, 7};
//        int arr[] = {1, 10, 20};
//        int arr[] = {1, 1, 10, 20};
        int arr[] = { 9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1 };
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {

        if (arr[0] == 0) {
            return -1;
        }
        int n = arr.length;
        int cnt = 0;
        int i = 0;
        while (i < n - 1) {
            if (arr[i] == 0) {
                return -1;
            }
            if (arr[i] == 1) {
                i = i + 1;
            } else {
                i = arr[i] + i;
            }
            cnt++;
        }
        if (cnt > 0) {
            return cnt;
        } else {
            return -1;
        }

//        int steps = 0;
//        int noOfSteps = 0;
//        int step = -1;
//        int highest = 0;
//        boolean isLengthExceeded = false;
//        for (int i=0; i<arr.length; i++) {
//            if (isLengthExceeded) {
//                break;
//            }
//            highest = 0;
//            if (step == -1) {
//                step = arr[i];
//                noOfSteps += step;
//                continue;
//            }
//            for (int j=i; j<step+i; j++) {
//                if (noOfSteps >= arr.length) {
//                    isLengthExceeded = true;
//                } else if (j < arr.length && highest < arr[j]) {
//                    highest = arr[j];
//                }
//            }
//            i = highest;
//            step = highest;
//            noOfSteps += step;
//            steps++;
//        }
//        return steps;

    }

}
