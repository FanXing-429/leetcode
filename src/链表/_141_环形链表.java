package 链表;

/**
 * @author fanxing
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环形链表 {
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public boolean hasCycle(ListNode head) {
        // 使用快慢指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPoint = head;
        ListNode fastPoint = head.next;
        while(fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
            if (slowPoint == fastPoint)
                return true;
        }
        return false;
    }
}
