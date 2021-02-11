package 链表;

import java.util.LinkedList;

public class _203_移除链表元素 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    /**
     * 递归
     * */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 这样递归，我们已经将head.next及其之后的val的节点删除
        // 注意递归的返回值
        head.next = removeElements(head.next, val);
        // 之后我们只需要对头结点进行一个判断操作：头结点的val值
        return head.val == val ? head.next : head;
    }
    /**
     * 虚拟头结点
     * */
    public ListNode removeElements1(ListNode head, int val) {
        // 我们直到要删除某个节点，知道前一个节点是最常规的方法
        // 虚拟头节点
        ListNode vmNode = new ListNode(-1);
        vmNode.next = head;
        // 创建一个指针，指向虚拟头结点
        ListNode point = vmNode;
        while (point.next != null) {
            if (point.next.val == val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return head;
    }
    /**
     * 不用虚拟头结点
     */
    public ListNode removeElements2(ListNode head, int val) {
        // 不用虚拟头结点，我们就先要考虑头结点的问题
        while (head !=null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        // 定义一个指针
        ListNode point = head;
        while (point.next != null) {
            if (point.next.val == val) {
                point.next = point.next.next;
            }else {
                point = point.next;
            }
        }
        return head;
    }
}
