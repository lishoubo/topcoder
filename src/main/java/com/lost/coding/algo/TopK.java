package com.lost.coding.algo;

/**
 * Created by lishoubo on 17/12/4.
 */
public class TopK {
    private final int k;

    private int[] heap;

    public TopK(int k) {
        this.k = k;
    }

    public void init() {
        heap = new int[k];
    }


    public void insert(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (heap[0] >= data[i]) {
                continue;
            }
            heap[0] = data[i];
            adjustHeapLine(0);
        }
    }

    private void adjustHeap(final int i) {
        int minIndex = i, leftChild = leftChild(i), rightChild = rightChild(i);

        if (leftChild < heap.length && heap[leftChild] < heap[minIndex]) {
            minIndex = leftChild;
        }

        if (rightChild < heap.length && heap[rightChild] < heap[minIndex]) {
            minIndex = rightChild;
        }

        if (minIndex == i) {
            return;
        }

        final int temp = heap[i];
        heap[i] = heap[minIndex];
        heap[minIndex] = temp;

        adjustHeap(minIndex);
    }

    private void adjustHeapLine(final int i) {
        int index = i;
        while (true) {
            int minIndex = index, leftChild = leftChild(index), rightChild = rightChild(index);
            if (leftChild >= heap.length) {
                return;
            }

            if (leftChild < heap.length && heap[leftChild] < heap[minIndex]) {
                minIndex = leftChild;
            }

            if (rightChild < heap.length && heap[rightChild] < heap[minIndex]) {
                minIndex = rightChild;
            }

            if (minIndex == index) {
                return;
            }

            final int temp = heap[index];
            heap[index] = heap[minIndex];
            heap[minIndex] = temp;

            index = minIndex;
        }
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    public int[] topk() {
        return heap;
    }
}
