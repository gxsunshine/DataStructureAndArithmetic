package com.gx.arithmetic.linkedListRelated;

import com.gx.dataStructure.SinglyLinkedList;
import com.gx.dataStructure.util.SinglyLinkedUtil;

/**
 * @Author: gx
 * @Date: Created in 2020/4/25 10:19
 * @Description: 链表反转操作
 */
public class LinkedListReverse {
    public static void main(String[] args) {
        SinglyLinkedListReverse singlyLinkedListReverse = new SinglyLinkedListReverse();
        singlyLinkedListReverse.init(10);
        System.out.println("------反转之前链表数据：----------------");
        singlyLinkedListReverse.print();
        System.out.println("------反转之后链表数据：----------------");
        singlyLinkedListReverse.reverse();
        singlyLinkedListReverse.print();
    }
}

/**
 * 单向链表反转
 */
class SinglyLinkedListReverse extends SinglyLinkedUtil {

    /**
     * 链表反转
     */
    public void reverse(){
        // 处理空链表
        if(head == null){
           return;
        }
        SinglyLinkedList p1 = head;
        SinglyLinkedList p2 = p1.next;
        SinglyLinkedList p3 = null;
        p1.next = null;
        while(p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head = p1;
    }
}
