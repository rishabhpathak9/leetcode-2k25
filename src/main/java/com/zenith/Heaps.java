package com.zenith;

import java.util.ArrayList;
import java.util.List;

public class Heaps {

    private List<Integer> arr = new ArrayList<>();

    public void insert(int val) {
        arr.add(val);
        bubbleUp(arr.size() - 1);
    }

    private void bubbleUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (arr.get(i) >= arr.get(parent)) {
                break;
            }

            int temp = arr.get(i);
            arr.set(i, arr.get(parent));
            arr.set(parent, temp);

            i = parent;
        }
    }

    public int pop() {
        if (arr.isEmpty()) {
            return -1;
        }

        int smallest = arr.get(0);
        int last = arr.remove(arr.size() - 1);

        if (!arr.isEmpty()) {
            arr.set(0, last);
            heapify(0);
        }
        return smallest;
    }

    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < arr.size() && arr.get(left) < arr.get(smallest)) {
            smallest = left;
        }
        if (right < arr.size() && arr.get(right) < arr.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, temp);
            heapify(smallest);
        }
    }

    public List<Integer> heapSort(List<Integer> list) {
        // Copy input so we don't destroy the original list
        arr = new ArrayList<>(list);

        // Build heap bottom-up
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            heapify(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!arr.isEmpty()) {
            result.add(pop());
        }

        return result;
    }

}
