package com.gx.dataStructure;

/**
 * @Author: gx
 * @Date: Created in 2020/4/19 21:23
 * @Description: 双向链表操作练习
 */
public class DoublyLinkedListPractise {
    public static void main(String[] args) {
        DoublyLinkedListUtil doublyLinkedListUtil = new DoublyLinkedListUtil();
        doublyLinkedListUtil.init(5);
//        doublyLinkedListUtil.print();
//        DoublyLinkedList addNode = new DoublyLinkedList(11);
//        doublyLinkedListUtil.add(addNode);
        DoublyLinkedList delNode = new DoublyLinkedList(2);
        doublyLinkedListUtil.del(delNode);
        doublyLinkedListUtil.print();
    }
}

/**
 * 双向链表工具类
 */
class DoublyLinkedListUtil{
    DoublyLinkedList head = null;

    /**
     * 初始化n个节点双向链表
     * @param n 节点数量
     */
    public void init(int n){
        DoublyLinkedList p = null;
        for(int i = 1; i <= n; i++){
            DoublyLinkedList newNode = new DoublyLinkedList(i * 2);
            if(head == null){
                head = newNode;
                p = head;
            }else{
                p.next =  newNode;
                newNode.last = p;
                p = p.next;
            }
        }
    }

    /**
     * 新增一个节点 - 根据数据大小
     * @param addNode 待新增节点
     */
    public void add(DoublyLinkedList addNode){
        // 处理空链表
        if(head == null){
            head = addNode;
            return;
        }
        // 插入是头节点
        if(addNode.data <= head.data){
            addNode.next = head;
            head.last = addNode;
            head = addNode;
            return;
        }
        DoublyLinkedList p = head;
        for(; p != null; p = p.next){
            if(p.next == null || addNode.data <= p.next.data){
                addNode.next = p.next;
                // 如果插入的不是最后一个节点
                if(p.next != null){
                    p.next.last = addNode;
                }
                p.next = addNode;
                addNode.last = p;
                break;
            }
        }

    }

    /**
     * 删除一个节点
     * @param delNode 待删除的节点
     */
    public void del(DoublyLinkedList delNode){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        if(delNode.data == head.data){
            head = head.next;
            head.last = null;
            return;
        }
//        DoublyLinkedList p = head;
//        for(; p.next != null; p = p.next){
//            if(delNode.data == p.next.data){
//                if(p.next.next != null){
//                    p.next.next.last = p;
//                }
//                p.next = p.next.next;
//                return;
//            }
//        }
        DoublyLinkedList p = head.next;
        for(; p != null; p = p.next){
            if(delNode.data == p.data){
                // 删除的不是最后一个节点
                if(p.next != null){
                    p.next.last = p.last;
                }
                p.last.next = p.next;
                return;
            }
        }
        System.out.println("没有要删除的节点");
    }

    /**
     * 遍历双向链表
     */
    public void print(){
        DoublyLinkedList p = head;
        DoublyLinkedList p2;
        System.out.println("正向遍历双向链表：");
        for(; p != null; p = p.next){
            System.out.println(p.data);
            if(p.next == null){
                System.out.println("方向遍历双向链表：");
                for(p2 = p; p2 != null; p2 = p2.last){
                    System.out.println(p2.data);
                }
            }
        }

    }
}
