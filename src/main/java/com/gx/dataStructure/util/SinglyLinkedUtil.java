package com.gx.dataStructure.util;

import com.gx.dataStructure.linkedList.SinglyLinkedList;

/**
 * 单向链表工具类
 */
public class SinglyLinkedUtil{
    public SinglyLinkedList head = null;
    /**
     * 初始化一个单向链表
     * @param n 链表长度
     */
    public void init(int n){
        SinglyLinkedList p = null;
        for(int i=1; i<=n; i++){
            SinglyLinkedList newNode = new SinglyLinkedList();
            newNode.data = i*2;
            if(head == null){
                head = p = newNode;
            }else{
                p.next = newNode;
                p = p.next;
            }

        }
    }

    /**
     * 新增节点 - 在链表最后插入节点
     * @param node 新增的节点
     */
    public void add(SinglyLinkedList node){
        SinglyLinkedList p = head;
        if(p == null){
            p = head = node;
        }else{
            while(p.next != null)
                p = p.next;
            p.next = node;
        }
        print();
    }

    /**
     * 在参考接口后面插入该节点
     * @param refNode 参考节点
     * @param insertNode 插入节点
     */
    public void insert(SinglyLinkedList refNode, SinglyLinkedList insertNode){
        SinglyLinkedList p = head;
        if(head == null){
            System.out.println("空链表");
        }else{

            for(; p.next != null; p = p.next){
                if(p.data == refNode.data){
                    insertNode.next = p.next;
                    p.next = insertNode;
                    break;
                }
            }
            if(p.next == null){
                if(p.data == refNode.data){
                    p.next = insertNode;
                }
                else {
                    System.out.println("没有对应的节点");
                }
            }
        }
        print();
    }

    /**
     * 按照数据大小插入节点
     * @param insertNode 待插入的节点
     */
    public void insertSort(SinglyLinkedList insertNode){
        if(head == null){
            head = insertNode;
            return;
        }
        if(insertNode.data < head.data){
            insertNode.next = head;
            head = insertNode;
        }else {
            SinglyLinkedList p1 = head;
            for(; p1!= null; p1 = p1.next){
                if(p1.next == null || insertNode.data < p1.next.data){
                    insertNode.next = p1.next;
                    p1.next = insertNode;
                    break;
                }
            }
        }
        print();
    }

    /**
     * 删除节点
     * @param delNode 需要删除的节点
     */
    public void del(SinglyLinkedList delNode){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        if(head.data == delNode.data){
            head = head.next;
        }else{
            SinglyLinkedList p1 = head.next;
            SinglyLinkedList p2 = head;
            for(; p1 != null; p2 = p1, p1 = p1.next){
                if (p1.data == delNode.data){
                    p2.next = p1.next;
                    return;
                }
            }
            if(p1 == null){
                System.out.println("没有需要删除的节点");
            }
        }
    }

    /**
     * 打印链表数据
     */
    public void print(){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        SinglyLinkedList p = head;
        while(p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}
