package com.solvd.zoomaven.list;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
