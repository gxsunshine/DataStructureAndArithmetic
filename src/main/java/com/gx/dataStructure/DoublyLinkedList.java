package com.gx.dataStructure;

/**
 * @Author: gx
 * @Date: Created in 2020/4/19 21:22
 * @Description: 双向链表数据结构
 */
public class DoublyLinkedList {
    int data;
    DoublyLinkedList last = null;
    DoublyLinkedList next = null;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int data) {
        this.data = data;
    }
}
