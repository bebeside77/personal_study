package com.may.java.ctci;

import java.util.Iterator;

/**
 * @author bebeside77
 */
public class CircularArray<T> implements Iterable<T> {
    private static final int INITIAL_SIZE = 10;

    private int offset;
    private Object[] elements = new Object[INITIAL_SIZE];
    private int size;

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void add(T element) {
        ensureArrayCapacity();
        elements[size++] = element;
    }

    public void set(T element, int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException(index + " is not in bound of range.");
        }

        ensureArrayCapacity();
        elements[(index + offset) % size] = element;
    }

    private void ensureArrayCapacity() {
        if (size >= elements.length) {
            Object[] dest = new Object[size * 2];
            System.arraycopy(elements, 0, dest, 0, size);
            elements = dest;
        }
    }

    public T get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " is not in bound of range.");
        }

        return (T) elements[(index + offset) % size];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int head = 0;

            @Override
            public boolean hasNext() {
                return head <= size - 1;

            }

            @Override
            public T next() {
                return (T) elements[(head++ + offset) % size];
            }
        };
    }

}
