package leetcode;

public class ReverseKGroup25 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k){
        //  head本身就含有值，设置一个假节点dummy用来进行操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        //全部链表的遍历
        while(end.next!=null){
            for(int i=0; i<k && end!=null; ++i){
                end = end.next;
            }
            if(end==null){
                //说明前面是在判定条件end!=null失效的情况下跳出的循环，这时候直接返回即可
                break;
            }
            //指向起点，同时也是翻转后的终点
            ListNode start = pre.next;
            ListNode next = end.next;
            //为了只翻转这一段链表，要在end处将链表断开
            end.next = null;
            pre.next = reverse(start);
            //翻转后的终点还是start指针指向的那个节点
            start.next = next;
            //重置标记指针
            pre = start;
            //前面的end指针已经被断开了，这里要重置一下end指针
            end = pre;
        }
        return dummy.next;
    }

    //  单组翻转
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}
