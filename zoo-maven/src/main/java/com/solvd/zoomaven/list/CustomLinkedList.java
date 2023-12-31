package com.solvd.zoomaven.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<T> implements List<T> {
    Node<T> head;
    int size;

    public CustomLinkedList() {
    }

    public CustomLinkedList(Collection<? extends T> c) {
        this();
        addAll(c);
    }
    public void show(){
        Node<T> current = head;
        while (current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        if (head == null) return false;
        Node<T> current = head;
        while (current.next != null) {
            if (o.equals(current.data)) return true;
            current = current.next;
        }

        return o.equals(current.data);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T x : c) {
            add(x);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("index out of bounds");
        if (index == 0) return head.data;

        Node<T> current = head;
        for (int i = 0; i <= index; i++) {
            if (i == index){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("index out of bounds");
        T data = null;
        if (index == 0){
            head.data = element;
            data = element;
        }else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.data = element;
            data = element;
        }
        return data;
    }

    @Override
    public void add(int index, T element) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("index out of bounds");
        Node<T> newNode = new Node<>(element);

        if (index == 0){
            newNode.next = head;
            head = newNode;
        }else {

            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;

        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("index out of bounds");
        T data = null;
        if (index == 0) {
            data = head.data;
            head = head.next;
        }else {
            Node<T> current = head;
            Node<T> nodeToEliminate = null;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
            nodeToEliminate = current.next;
            current.next = nodeToEliminate.next;
            data = nodeToEliminate.data;
        }
        --size;
        return data;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;
        while (current != null){
            if (o.equals(current.data)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}
