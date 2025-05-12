package dev.playground.training.ds;

public class DynamicArray<T> {

    private Object[] array;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public DynamicArray() {
        this(10);
    }

    public void add(T element) {
        if (size == capacity) {
            resize();
        }
        array[size++] = element;
    }

    private void resize() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array,0, newArray, 0, size);
        array = newArray;
    }





}
