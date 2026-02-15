package com.zenith.patterns.modifiedBinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int result = search(arr, 3, 0, arr.length - 1);
        assert result == 2 : "search(arr, 3) should return 2";
        result = searchIterative(arr, 2);
        assert result == 1 : "searchIterative(arr, 2) should return 1";
        result = searchIterative(arr, 3);
        assert result == 2 : "searchIterative(arr, 3) should return 2";
        result = searchIterative(arr, 5);
        assert result == -1 : "searchIterative(arr, 5) should return -1";
        result = searchIterative(arr, 1);
        assert result == 0 : "searchIterative(arr, 1) should return 0";

        int[] arr2 = {5};
        result = search(arr2, 5, 0, arr2.length - 1);
        assert result == 0 : "search(arr2, 5) should return 0";
        result = searchIterative(arr2, 5);
        assert result == 0 : "searchIterative(arr2, 5) should return 0";

        int[] arr3 = {1, 3, 5, 7, 9, 11};
        result = search(arr3, 7, 0, arr3.length - 1);
        assert result == 3 : "search(arr3, 7) should return 3";
        result = searchIterative(arr3, 1);
        assert result == 0 : "searchIterative(arr3, 1) should return 0";
        result = searchIterative(arr3, 11);
        assert result == 5 : "searchIterative(arr3, 11) should return 5";
        result = searchIterative(arr3, 6);
        assert result == -1 : "searchIterative(arr3, 6) should return -1";
    }

    static int search(int[] arr, int val, int beg, int end) {
        int mid = (beg + end) / 2;
        if (beg == end) {
            return arr[mid] == val ? mid : -1;
        }
        if (arr[mid] == val) {
            return mid;
        } else if (val < arr[mid]) {
            return search(arr, val, beg, mid);
        } else {
            return search(arr, val, mid + 1, end);
        }
    }

    private static int searchIterative(int[] arr, int val) {
        int beg = 0;
        int end = arr.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (beg == end) {
                return arr[mid] == val ? mid : -1;
            }
            if (arr[mid] == val) {
                return mid;
            } else if (val < arr[mid]) {
                end = mid;
            } else {
                beg = mid + 1;
            }
        }
        return -1;

    }
}
