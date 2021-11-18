package leetcode;

public class 剑指offer_22 {
    public static void main(String[] args) {

    }

    /**
     * 遍历两次，第一次获取链表长度，第二次返回第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int num = length - k;
        temp = head;
        while (num != 0) {
            temp = temp.next;
            num--;
        }
        return temp;
    }

    /**
     * 使用双指针，两个指针相距k，第二个指针指向最后一个元素时，第一个指针指向第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (; k != 1; k--) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}