package com.workspace.demo.companies.twitter;

public class DuplicateInSortedArray {

    public static int singleNonDuplicate2(int[] nums) {

        int n = -1;
        for (int i = 0; i < nums.length; i++) {
            if (n == -1)
                n = nums[i];
            else if (nums[i] == n)
                n = -1;
            else break;
        }

        return n;
    }

    public static int singleNonDuplicate(int[] nums, int start, int end) {


        if (start > end)
            return -1;
        if (start == end)
            return nums[start];

        int mid = (end - start) / 2;

        if (mid % 2 == 0) {
            if (nums[mid] == nums[mid + 1])
                return singleNonDuplicate(nums, mid + 2, end);
            else return singleNonDuplicate(nums, start, mid);
        } else {
            if (nums[mid] == nums[mid - 1])
                return singleNonDuplicate(nums, mid + 1, end);
            else return singleNonDuplicate(nums, start, mid);
        }

    }

    public static void main(String[] args) {

//        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] arr = new int[]{3,3,7,7,10,11,11};
        System.out.println("non duplicate= " + singleNonDuplicate(arr, 0, arr.length - 1));
    }
}
