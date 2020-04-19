package com.gx.dataStructure;

/**
 * @Author: gx
 * @Date: Created in 2020/4/12 20:45
 * @Description: 单向链表练习 - 增删查改
 */

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

/**
 * 定义单向链表结构
 */
class SinglyLinked{
    int data;
    SinglyLinked next = null;

    public SinglyLinked() {
    }

    public SinglyLinked(int data) {
        this.data = data;
    }
}

/**
 * 单向链表工具类
 */
class SinglyLinkedUtil{
    public SinglyLinked head = null;
    /**
     * 初始化一个单向链表
     * @param n 链表长度
     */
    public void init(int n){
        SinglyLinked p = null;
        for(int i=1; i<=n; i++){
            SinglyLinked newNode = new SinglyLinked();
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
    public void add(SinglyLinked node){
        SinglyLinked p = head;
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
    public void insert(SinglyLinked refNode, SinglyLinked insertNode){
        SinglyLinked p = head;
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
    public void insertSort(SinglyLinked insertNode){
        if(head == null){
            head = insertNode;
            return;
        }
        if(insertNode.data < head.data){
            insertNode.next = head;
            head = insertNode;
        }else {
            SinglyLinked p1 = head;
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
    public void del(SinglyLinked delNode){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        if(head.data == delNode.data){
            head = head.next;
        }else{
            SinglyLinked p1 = head.next;
            SinglyLinked p2 = head;
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
        SinglyLinked p = head;
        while(p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}

/**
 * 带头节点的单向链表工具类
 * 可以不用特殊处理空链表，以及链表头。代码更简洁
 */
class SinglyHeadLinkedUtil{
    public SinglyLinked head = new SinglyLinked(-1);

    /**
     * 初始化一个单向链表
     * @param n 链表长度
     */
    public void init(int n){
        SinglyLinked p = head;
        for(int i=1; i<=n; i++, p = p.next){
            SinglyLinked newNode = new SinglyLinked();
            newNode.data = i*2;
            p.next = newNode;
        }
    }

    /**
     * 添加一个节点（按照data大小）
     * @param addNode 待添加的节点
     */
    public void add(SinglyLinked addNode){
        // 使用双指针遍历
//        SinglyLinked p1 = head;
//        SinglyLinked p2 = head.next;
//        for(; p1 != null; p1 = p1.next, p2 = p2.next){
//            if(p2 == null || addNode.data <= p2.data){
//                addNode.next = p2;
//                p1.next = addNode;
//                break;
//            }
//        }

        // 使用单指针遍历
        SinglyLinked p1 = head;
        for(; p1 != null; p1 = p1.next){
            if(p1.next == null || addNode.data <= p1.next.data){
                addNode.next = p1.next;
                p1.next = addNode;
                break;
            }
        }
        print();
    }

    /**
     * 删除一个节点
     * @param delNode 待删除节点
     */
    public void del(SinglyLinked delNode){
        // 使用双指针遍历
//        SinglyLinked p1 = head;
//        SinglyLinked p2 = head.next;
//        for(; p1 != null; p1 = p1.next, p2 = p2.next){
//            if(delNode.data == p2.data){
//                p1.next = p2.next;
//                return;
//            }
//        }
//        if(p1 == null){
//            System.out.println("没有要删除的节点");
//        }

        // 使用单指针遍历
        SinglyLinked p1 = head;
        for(; p1.next != null; p1 = p1.next){
            if(delNode.data == p1.next.data){
                p1.next = p1.next.next;
                return;
            }
        }
        if(p1.next == null){
            System.out.println("没有要删除的节点");
        }

    }

    /**
     * 打印链表
     */
    public void print(){
        SinglyLinked p = head.next;
        for(; p != null; p = p.next){
            System.out.println(p.data);
        }
    }
}

public class SinglyLinkedPractise {

    public static void main(String[] args) {
        // 单向链表（不带头节点）练习
//        SinglyLinkedUtil singlyLinkedUtil = new SinglyLinkedUtil();
//        singlyLinkedUtil.init(5);
//        singlyLinkedUtil.print();
//        SinglyLinked node = new SinglyLinked(9);
//        singlyLinkedUtil.add(node);
//        SinglyLinked inSertNode = new SinglyLinked(11);
//        singlyLinkedUtil.insertSort(inSertNode);

//        SinglyLinked refNode = new SinglyLinked(5);
//        SinglyLinked insertNode = new SinglyLinked(10);
//        singlyLinkedUtil.insert(refNode, insertNode);
//        SinglyLinked delNode = new SinglyLinked(7);
//        singlyLinkedUtil.del(delNode);

        // 单向链表（带头节点）练习
        SinglyHeadLinkedUtil singlyHeadLinkedUtil = new SinglyHeadLinkedUtil();
        singlyHeadLinkedUtil.init(5);
//        SinglyLinked addNode = new SinglyLinked(11);
//        singlyHeadLinkedUtil.add(addNode);
        SinglyLinked delNode = new SinglyLinked(10);
        singlyHeadLinkedUtil.del(delNode);
        singlyHeadLinkedUtil.print();
    }


}
