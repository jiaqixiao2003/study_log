package study.java.colletction.map;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Code19_RemoveN {
    public static ListNode removeNFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
//        dummyNode.next = head;
        ListNode cur = dummyNode;
        // 双指针：
        ListNode first = head;
        for(int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;



        /*
        // 方法二：栈：
        LinkedList<ListNode> que = new LinkedList<>();
        Deque<ListNode> que1 = new LinkedList<>();

        while (cur != null) {
            que.add(cur);
            que1.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            que.pop();
            que1.pop();
        }
        ListNode prev = que1.peek();
        prev.next = prev.next.next;
        */

        /*
        // 方法一：
        int length = 0;
        while(head != null) {
            length ++;
            head = head.next;
        }
        for (int i = 0; i < length-n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        */

        return dummyNode.next;
    }

    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        // 测试用例 1: head = [1,2,3,4,5], n = 2
        System.out.println("测试用例 1:");
        int[] input1 = {1, 2, 3, 4, 5};
        ListNode head1 = createLinkedList(input1);
        printLinkedList(head1);

        ListNode new1 = removeNFromEnd(head1, 2);
        printLinkedList(new1);
    }
}
