package com.gx.dataStructure;

class CycleLinkedUtil{
    private SinglyLinkedList head = null;

    /**
     * 循环链表初始化
     * @param n 初始化个数
     */
    public void init(int n){
        SinglyLinkedList p = null;
        for(int i=1; i <= n; i++, p = p.next){
            SinglyLinkedList newNode = new SinglyLinkedList(2*i);
            if(head == null){
                head = newNode;
                p = head;
            }else {
                p.next = newNode;
            }
            newNode.next = head;
        }
    }

    /**
     * 循环链表打印
     */
    public void print(){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        SinglyLinkedList p1 = head;
        for(; p1.next != null; p1 = p1.next){
            System.out.println(p1.data);
        }
        System.out.println(p1.data);
    }

    /**
     * 增加节点（根据从小到大的排序）
     * @param addNode
     */
    public void add(SinglyLinkedList addNode){
        // 处理空链表
        if(head == null){
            head = addNode;
            addNode.next = head;
            return;
        }
        SinglyLinkedList p = head;
        // 插入位置是头节点
        if(addNode.data <= p.data){
            // 获得最后一个节点的指针
            for(; p.next != head; p = p.next);
            addNode.next = head;
            head = addNode;
            // 最后一个节点指向头节点，继续形成循环链表
            p.next = head;
            return;
        }
        for(; p != null; p = p.next){
            if(p.next == head || addNode.data <= p.next.data){
                addNode.next = p.next;
                p.next = addNode;
                break;
            }
        }
    }

    /**
     * 删除链表节点
     * @param delNode 待删除节点
     */
    public void del(SinglyLinkedList delNode){
        if(head == null){
            System.out.println("没有要删除的节点");
            return;
        }
        // 删除的是头节点
        SinglyLinkedList p;
        if(head.data == delNode.data){
            for(p = head; p.next != head; p = p.next);
            head = head.next;
            p.next = head;
            return;
        }
        for(p = head; p.next != head; p = p.next){
            if(delNode.data == p.next.data){
                p.next = p.next.next;
                break;
            }
        }
        if(p.next == head){
            System.out.println("没有要删除的节点");
        }

    }
}

/**
 * @Author: gx
 * @Date: Created in 2020/4/19 10:53
 * @Description: 循环链表练习
 */
public class CycleLinkedPractise {
    public static void main(String[] args) {
        CycleLinkedUtil cycleLinkedUtil = new CycleLinkedUtil();
        cycleLinkedUtil.init(5);
//        cycleLinkedUtil.print();
//        SinglyLinkedList addNode = new SinglyLinkedList(3);
//        cycleLinkedUtil.add(addNode);
//        cycleLinkedUtil.print();
        SinglyLinkedList delNode = new SinglyLinkedList(11);
        cycleLinkedUtil.del(delNode);
        cycleLinkedUtil.print();
    }
}
