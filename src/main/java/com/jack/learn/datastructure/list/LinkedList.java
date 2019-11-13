package com.jack.learn.datastructure.list;

/**
 * <p>
 *     链表的数据结构以及一些问题
 * </p>
 *
 * @author liweijian.
 * @date 2019/11/10.
 */
public class LinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node4;
        System.out.println("is cycle: " + isCycle(node1));
    }

    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
    static class Node {
        int data = 0;
        Node next = null;
        public Node(int data) {
            this.data = data;
        }
    }
}
