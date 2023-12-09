package nonlineardatastructures;

import java.util.ArrayList;

public class MaxHeap <T extends Comparable<T>> {

    public ArrayList<T> heap;
    public int size;

    public MaxHeap() {
        this.heap = new ArrayList<T>();
        this.size = 0;
    }

    public void add(T value) {
        this.heap.add(value);
        this.size++;
        this.bubbleUp();
    }

    private void bubbleUp() {
        int current = this.size - 1;
         while (current > 0 && this.getValueAtIndex(this.getParent(current)).compareTo(this.getValueAtIndex(current)) < 0) {
             this.swap(current, this.getParent(current));
             current = this.getParent(current);
         }
    }

    public T popMax() {
        if (this.size == 0) {
            throw new Error("Heap is empty!");
        }

        this.swap(this.size - 1, 0);
        T max = this.heap.removeLast();
        this.size--;

        this.heapify();
        return max;
    }

    private void heapify() {
        int current = 0;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);

        while (this.canSwap(current, leftChild, rightChild)) {
            if (this.exists(leftChild) && this.exists(rightChild)) {
                if (this.getValueAtIndex(leftChild).compareTo(this.getValueAtIndex(rightChild)) > 0) {
                    this.swap(current, leftChild);
                    current = leftChild;
                } else {
                    this.swap(current, rightChild);
                    current = rightChild;
                }
            } else {  // Only the left Child exists
                this.swap(current, leftChild);
                current = leftChild;
            }

            leftChild = this.getLeft(current);;
            rightChild = this.getRight(current);
        }

    }

    private void swap(int a, int b) {
        T temp = this.getValueAtIndex(a);
        this.heap.set(a, this.getValueAtIndex(b));
        this.heap.set(b, temp);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return (index * 2) + 1;
    }

    private int getRight(int index) {
        return (index * 2) + 2;
    }

    private boolean canSwap(int parent, int leftChild, int rightChild) {
        if (this.exists(leftChild)) {
            return this.getValueAtIndex(parent).compareTo(this.getValueAtIndex(leftChild)) < 0;
        } else if (this.exists(rightChild)) {
            return this.getValueAtIndex(parent).compareTo(this.getValueAtIndex(rightChild)) < 0;
        } else {
            return false;
        }
    }

    private boolean exists(int index) {
        return index < this.size;
    }

    private T getValueAtIndex(int index) {
        return this.heap.get(index);
    }

}
