package 链表;

/**
 * @author fanxing
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 */
public class _206_反转链表 {
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


    public ListNode reverseList(ListNode head) {
        // 用递归的方式
        if (head == null || head.next == null) {
            return head;
        }
        ListNode toolNode = head.next;
        ListNode node = reverseList(head.next);
        toolNode.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseList1(ListNode head) {
        // 用迭代的方式：可以当做从头将每个节点拆下，然后采用头插法，对链表进行重构
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultNode = null;
        ListNode newHead = null; // 写在循环外面可以节省内存空间
        while(head != null) {
            newHead = head.next;
            head.next = resultNode;
            resultNode = head;
            head = newHead;
        }
        return resultNode;
    }
}
