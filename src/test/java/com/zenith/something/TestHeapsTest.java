package com.zenith.something;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.zenith.Heaps;

public class TestHeapsTest {

    @Test
    public void testHeapSort() {
        Heaps heaps = new Heaps();
        List<Integer> randomArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            randomArray.add(random.nextInt(100));
        }

        System.out.println("Original array: " + randomArray);
        System.out.println("Sorted array: " + heaps.heapSort(randomArray));
    }

    @Test
    public void testInsertAndPop() {
        Heaps heaps = new Heaps();
        heaps.insert(5);
        heaps.insert(3);
        heaps.insert(7);
        heaps.insert(1);

        assert heaps.pop() == 1;
        assert heaps.pop() == 3;
        assert heaps.pop() == 5;
        assert heaps.pop() == 7;
    }
}
