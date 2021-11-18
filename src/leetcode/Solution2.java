package leetcode;

import java.util.List;

public class Solution2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, pointer = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //将两个链表视为一样长的，短的用零补上
            int newVal = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            //进位符置0
            carry = 0;
            //处理进位
            if (newVal >= 10) {
                carry = newVal / 10;
                newVal %= 10;
            }

            if (head == null) {//首次初始化头指针
                head = new ListNode(newVal);
                pointer = head;
            } else {
                pointer.next = new ListNode(newVal);
                pointer = pointer.next;
            }
            if (l1 != null)//空指针判断
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry != 0) {//如果最后还有进位，则再添加一个
            pointer.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode p1 = l1;
        for (int i = 5; i < 6; i++) {
            p1.next = new ListNode(i, null);
            p1 = p1.next;
        }
        ListNode l2 = new ListNode(1, null);
        ListNode p2 = l2;
        for (int i = 5; i < 7; i++) {
            p2.next = new ListNode(i, null);
            p2 = p2.next;
        }
        addTwoNumbers(l1, l2);
    }
}

